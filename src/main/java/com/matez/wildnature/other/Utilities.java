package com.matez.wildnature.other;

import com.matez.wildnature.Main;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeContainer;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.AbstractTreeFeature;

import javax.annotation.Nullable;
import java.awt.*;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.*;

public class Utilities {
    public static int rint(int min, int max) {

        if(min==max){
            return min;
        }

        if (min >= max) {
            return max;
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public static int rint(int min, int max, Random rand) {

        if(min==max){
            return min;
        }

        if (min >= max) {
            return max;
        }


        return rand.nextInt((max - min) + 1) + min;
    }
    public static double rdoub(double min, double max) {

        if(min==max){
            return min;
        }

        if (min >= max) {
            return max;
        }

        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }
    public static double rdoub(double min, double max, Random rand) {

        if(min==max){
            return min;
        }

        if (min >= max) {
            return max;
        }


        return min + (max - min) * rand.nextDouble();
    }
    public static boolean iBetween(int rangeMin, int rangeMax, int number){
        return number>rangeMin&&number<rangeMax;
    }

    public static boolean dBetween(double rangeMin, double rangeMax, double number){
        return number>rangeMin&&number<rangeMax;
    }

    public static boolean chance(double percentChance){
        double x = rdoub(0,100);
        //Crack.LOGGER.info("chance: " + percentChance+"/"+x);
        return percentChance>=x;
    }
    public static boolean chance(double percentChance,Random rand){
        double x = rdoub(0,100,rand);
        return percentChance<=x;
    }

    public static BlockState getWeighBlock(BlockWeighList list){
        if(!(list.size()==0)){
            ArrayList<BlockState> blockStates = list.getNormalArrayList();
            int block = rint(0,blockStates.size()-1);

            return blockStates.get(block);


        }

        return null;
    }

    public static SchemFeature getWeighTree(TreeWeighList list){
        if(!(list.size()==0)){
            ArrayList<SchemFeature> trees = list.getNormalArrayList();
            int block = rint(0,trees.size()-1);

            return trees.get(block);


        }

        return null;
    }

    public static SchemFeature getWeighTree(TreeWeighList list, Random rand){
        if(!(list.size()==0)){
            ArrayList<SchemFeature> trees = list.getNormalArrayList();
            int block = rint(0,trees.size()-1,rand);

            return trees.get(block);


        }


        return null;
    }

    public static Biome getWeighBiome(BiomeWeighList list,Random rand){
        if(!(list.size()==0)){
            ArrayList<Biome> biomes = list.getNormalArrayList();
            int biome = rint(0,biomes.size()-1,rand);

            return biomes.get(biome);


        }

        return null;
    }

    public static Biome getWeighBiome(BiomeWeighList list){
        if(!(list.size()==0)){
            ArrayList<Biome> biomes = list.getNormalArrayList();
            int biome = rint(0,biomes.size()-1);

            return biomes.get(biome);


        }

        return null;
    }

    public static int blockDistance(BlockPos pos1, BlockPos pos2) {
        return (int)Math.sqrt(Math.pow(pos2.getX()-pos1.getX(),2)+Math.pow(pos2.getY()-pos1.getY(),2)+Math.pow(pos2.getZ()-pos1.getZ(),2));
    }

    public static double blockDistanceDouble(BlockPos pos1, BlockPos pos2) {
        return Math.sqrt(Math.pow(pos2.getX()-pos1.getX(),2)+Math.pow(pos2.getY()-pos1.getY(),2)+Math.pow(pos2.getZ()-pos1.getZ(),2));
    }

    @Nullable
    public static PlayerEntity getClosestPlayer(World world, double x, double y, double z) {
        PlayerEntity entity = null;
        double closestDistance = -1D;
        boolean nb = true;

        for(PlayerEntity player : world.getPlayers()){
            if(!player.isSpectator()){
                double distance = blockDistanceDouble(new BlockPos(x,y,z),player.getPosition());;
                if(nb){
                    entity=player;
                    closestDistance=distance;
                    nb = false;
                }else{
                    if(closestDistance>distance){
                        entity=player;
                        closestDistance=distance;
                    }
                }
            }
        }

        return entity;
    }

    public static int SumOfDigits(String str,
                           int n)
    {
        int sum = 0;

        for (int i = 0; i < n; i++)
            sum += (int)(str.charAt(i) - '0');

        return sum;
    }

    // function to Check if a large number
// is divisible by 2, 3 and 5 or not
    public static boolean isDivisible(String str,
                             int n)
    {
        if (SumOfDigits(str, n) % 3 == 0 &&
                str.charAt(n - 1) == '0')
            return true;

        return false;
    }

    public static boolean isStringEqual(String s, String... strings){
        ArrayList sar = new ArrayList(Arrays.asList(strings));
        for (int i = 0; i<sar.size(); i++){
            if(s.equals(sar.get(i))){
                return true;
            }
        }
        return false;
    }


    // N
    //W E   <---
    // S
    public static Direction rotateLeft(Direction old){
        Direction newDir;
        if(old==Direction.NORTH){
            newDir=Direction.WEST;
        }else if(old==Direction.WEST){
            newDir=Direction.SOUTH;
        }else if(old==Direction.SOUTH){
            newDir=Direction.EAST;
        }else{
            newDir=Direction.NORTH;
        }
        return newDir;
    }

    // N
    //W E   --->
    // S
    public static Direction rotateRight(Direction old){
        Direction newDir;
        if(old==Direction.NORTH){
            newDir=Direction.EAST;
        }else if(old==Direction.EAST){
            newDir=Direction.SOUTH;
        }else if(old==Direction.SOUTH){
            newDir=Direction.WEST;
        }else{
            newDir=Direction.NORTH;
        }
        return newDir;
    }

    public static CompoundNBT saveItem(CompoundNBT nbt, ItemStack stack){
        stack.write(nbt);
        return nbt;
    }
    public static ItemStack loadItem(CompoundNBT nbt){
        ItemStack stack = ItemStack.read(nbt);
        return stack;
    }

    public static CompoundNBT saveItems(CompoundNBT nbt, ArrayList<ItemStack> stack){
        if(nbt.contains("Items")){
            nbt.remove("Items");
        }

        ListNBT l = new ListNBT();
        for (ItemStack itemStack : stack) {
            CompoundNBT n = new CompoundNBT();
            itemStack.write(n);
            l.add(n);
        }

        nbt.put("Items",l);

        return nbt;
    }
    public static ArrayList<ItemStack> loadItems(CompoundNBT nbt){
        if(nbt.contains("Items")) {
            ListNBT l = (ListNBT) nbt.get("Items");
            assert l!=null;
            ArrayList<ItemStack> stacks = new ArrayList<>();
            for (INBT inbt : l) {
                ItemStack s = ItemStack.read((CompoundNBT) inbt);
                stacks.add(s);
            }
            return stacks;
        }
        return new ArrayList<>();
    }

    public static Object getRandomEntry(ArrayList<?> array, Random rand){
        return array.get(rint(0,array.size()-1,rand));
    }

    public static Object getWeightedEntry(WeightedList<?> list){
        if(!(list.size()==0)){
            ArrayList<?> objects = list.getSimplifedArray();
            int x = rint(0,objects.size()-1);

            return objects.get(x);
        }
        return null;
    }

    public static Object getWeightedEntry(WeightedList<?> list,Random rand){
        if(!(list.size()==0)){
            ArrayList<?> objects = list.getSimplifedArray();
            int x = rint(0,objects.size()-1,rand);

            return objects.get(x);
        }
        return null;
    }

    public static int countDuplicates(ArrayList<?> list, Object obj){
        return Collections.frequency(list,obj);
    }

    public static int getColorValue(int hex){
        return hex | -16777216;
    }

    public static String blendColors(Color clOne, Color clTwo, float fAmount) {
        float fInverse = (float)1.0 - fAmount;

        // I had to look up getting colour components in java.  Google is good :)
        float afOne[] = new float[3];
        clOne.getColorComponents(afOne);
        float afTwo[] = new float[3];
        clTwo.getColorComponents(afTwo);

        float afResult[] = new float[3];
        afResult[0] = afOne[0] * fAmount + afTwo[0] * fInverse;
        afResult[1] = afOne[1] * fAmount + afTwo[1] * fInverse;
        afResult[2] = afOne[2] * fAmount + afTwo[2] * fInverse;

        Color c = new Color(afResult[0], afResult[1], afResult[2]);

        String hex = String.format("%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());

        return hex;
    }

    public static float getDistance(BlockPos pos1, BlockPos pos2) {
        float f = (float)(pos1.getX() - pos2.getX());
        float f1 = (float)(pos1.getY() - pos2.getY());
        float f2 = (float)(pos1.getZ() - pos2.getZ());
        return MathHelper.sqrt(f * f + f1 * f1 + f2 * f2);
    }

    public static boolean isBlockNear(IWorld world, BlockPos pos, Block... blocks){
        try {
            for (Block block : blocks) {
                if (world.getBlockState(pos.offset(Direction.NORTH)).getBlock() == block) {
                    return true;
                }
                if (world.getBlockState(pos.offset(Direction.SOUTH)).getBlock() == block) {
                    return true;
                }
                if (world.getBlockState(pos.offset(Direction.EAST)).getBlock() == block) {
                    return true;
                }
                if (world.getBlockState(pos.offset(Direction.WEST)).getBlock() == block) {
                    return true;
                }
            }

            return false;
        }catch (Exception e){
            return true;
        }
    }

    public static boolean isUnsolidBlockNear(IWorld world, BlockPos pos){
        try {
            if (!world.getBlockState(pos.offset(Direction.NORTH)).isSolid()) {
                return true;
            }
            if (!world.getBlockState(pos.offset(Direction.SOUTH)).isSolid()) {
                return true;
            }
            if (!world.getBlockState(pos.offset(Direction.EAST)).isSolid()) {
                return true;
            }
            if (!world.getBlockState(pos.offset(Direction.WEST)).isSolid()) {
                return true;
            }

            return false;
        }catch (Exception e){
            return true;
        }
    }

    public static boolean isBlockNear(IChunk world, BlockPos pos, Block... blocks){
        for (Block block : blocks) {
            if(world.getBlockState(pos.offset(Direction.NORTH)).getBlock()==block){
                return true;
            }
            if(world.getBlockState(pos.offset(Direction.SOUTH)).getBlock()==block){
                return true;
            }
            if(world.getBlockState(pos.offset(Direction.EAST)).getBlock()==block){
                return true;
            }
            if(world.getBlockState(pos.offset(Direction.WEST)).getBlock()==block){
                return true;
            }
        }

        return false;
    }

    public static boolean isValidGroundFor(BlockState plant, BlockState placeState, @Nullable IBlockReader world, @Nullable BlockPos pos) throws Exception{
        if (plant.getBlock() instanceof BushBlock){
            Class clazz = plant.getBlock().getClass();
            Class superclass = clazz;
            Method method=null;
            while(superclass!=null){
                try {
                    method = superclass.getDeclaredMethod("func_200014_a_", BlockState.class, IBlockReader.class, BlockPos.class);
                    break;
                }catch (Exception e){
                    superclass=superclass.getSuperclass();
                }

            }
            if(method!=null) {
                method.setAccessible(true);
                return (boolean) method.invoke(plant.getBlock(), placeState, world, pos);
            }
            return false;
        }
        return false;
    }

    public static Biome getBiomeOnPos(BiomeProvider provider, int x, int z){
        return provider.getNoiseBiome(x/4,0,z/4);
    }

    public static Biome getBiomeOnPos(BiomeContainer provider, int x, int z){
        return provider.getNoiseBiome(x/4,0,z/4);
    }
}
