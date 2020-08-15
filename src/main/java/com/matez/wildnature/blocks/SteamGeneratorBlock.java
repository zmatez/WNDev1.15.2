package com.matez.wildnature.blocks;

import com.matez.wildnature.Main;
import com.matez.wildnature.event.ClientPlayerEventHandler;
import com.matez.wildnature.other.Utilities;
import com.matez.wildnature.packets.WNSSpawnParticlePacket;
import com.matez.wildnature.registry.ParticleRegistry;
import com.matez.wildnature.sounds.SoundRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SPlaySoundPacket;
import net.minecraft.network.play.server.SSpawnParticlePacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TickPriority;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class SteamGeneratorBlock extends BlockBase {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final BooleanProperty RUNNING = BooleanProperty.create("running");
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final IntegerProperty STEAM = IntegerProperty.create("steam",0,25);

    public SteamGeneratorBlock(Properties properties, Item.Properties builder, ResourceLocation regName) {
        super(properties, builder, regName);
    }


    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
    }


    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING,context.getNearestLookingDirection().getOpposite()).with(RUNNING,false).with(POWERED, Boolean.valueOf(context.getWorld().isBlockPowered(context.getPos())));
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isRemote) {
            boolean flag = state.get(POWERED);
            if (flag != worldIn.isBlockPowered(pos)) {
                if (flag) {
                    worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
                } else {
                    worldIn.setBlockState(pos, state.cycle(POWERED).with(STEAM,25).with(RUNNING,true), 2);
                    worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1, TickPriority.NORMAL);
                }
            }

        }
    }


    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if (!worldIn.isRemote) {
            if (state.get(POWERED) && !worldIn.isBlockPowered(pos)) {
                worldIn.setBlockState(pos, worldIn.getBlockState(pos).cycle(POWERED).with(STEAM,0).with(RUNNING,false), 2);
            }
            steam(state,(ServerWorld)worldIn,pos,random);
        }

    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        //steam(stateIn,worldIn,pos,rand);
    }

    public void steam(BlockState state, ServerWorld worldIn, BlockPos pos, Random random){
        if(state.get(POWERED)){
            if(state.get(STEAM)>0) {
                if(state.get(STEAM)==25){
                    worldIn.playSound(null,pos.getX(),pos.getY(),pos.getZ(), SoundRegistry.STEAM_GENERATOR, SoundCategory.BLOCKS,1f,1F);

                }
                worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(RUNNING,true).with(POWERED,true).with(STEAM,state.get(STEAM)-1));

                steamParticle(pos, state, worldIn, random);

                worldIn.getPendingBlockTicks().scheduleTick(pos, this, 2, TickPriority.NORMAL);
            }else{
                worldIn.setBlockState(pos,worldIn.getBlockState(pos).with(RUNNING,false));

            }
        }
    }

    public void steamParticle(BlockPos oldPos, BlockState state, ServerWorld world, Random random){
        Direction direction = state.get(FACING);
        double X = offset(oldPos,direction,0.6).getX();
        double Y = offset(oldPos,direction,0.6).getY();
        double Z = offset(oldPos,direction,0.6).getZ();

        double divider = 3;
        double res = 0.15;
        for(int i = 0; i < Utilities.rint(15,40,random); i++) {
            double speedX = -((oldPos.getX()-X)/divider)+ Utilities.rdoub(-res,res);
            double speedY = -((oldPos.getY()-Y)/divider)+ Utilities.rdoub(-res,res);
            double speedZ = -((oldPos.getZ()-Z)/divider)+ Utilities.rdoub(-res,res);
            spawnParticle(world,ParticleRegistry.STEAM,X+0.5, Y+0.5, Z+0.5, 1,speedX,speedY,speedZ,0.1);

        }
    }

    public Vec3d offset(BlockPos pos, Direction facing, double n) {
        return new Vec3d(pos.getX() + facing.getXOffset() * n, pos.getY() + facing.getYOffset() * n, pos.getZ() + facing.getZOffset() * n);
    }


    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING,RUNNING,POWERED,STEAM);
    }

    public static <T extends IParticleData> int spawnParticle(ServerWorld world, T type, double posX, double posY, double posZ, int particleCount, double xSpeed, double ySpeed, double zSpeed, double speed) {
        try{
        if(Objects.requireNonNull(Minecraft.getInstance().getIntegratedServer()).getWorld(world.getDimension().getType())!=world){
            return 0;
        }}catch (Exception e){
            Main.LOGGER.warn("I am trying to register own particle packet, but I don't know how. If you know, write to me on Discord!\nFor now, it will give you these warns on server when the particle packet needs to be sent. (when using steam generator for example) Sorry!");
            return 0;
        }
        WNSSpawnParticlePacket sspawnparticlepacket = new WNSSpawnParticlePacket(type, false, (float)posX, (float)posY, (float)posZ, (float)xSpeed, (float)ySpeed, (float)zSpeed, (float)speed, particleCount);

        int i = 0;


        for(int j = 0; j < world.getPlayers().size(); ++j) {
            ServerPlayerEntity serverplayerentity = world.getPlayers().get(j);
            if (sendPacketWithinDistance(world, serverplayerentity, false, posX, posY, posZ, sspawnparticlepacket)) {
                ++i;
            }
        }

        return i;
    }

    public static boolean sendPacketWithinDistance(ServerWorld world, ServerPlayerEntity player, boolean longDistance, double posX, double posY, double posZ, IPacket<?> packet) {
        if (player.getServerWorld() != world) {
            return false;
        } else {
            BlockPos blockpos = player.getPosition();
            if (blockpos.withinDistance(new Vec3d(posX, posY, posZ), longDistance ? 512.0D : 32.0D)) {
                player.connection.sendPacket(packet);
                return true;
            } else {
                return false;
            }
        }
    }
}
