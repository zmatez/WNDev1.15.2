package com.matez.wildnature.init;

import com.matez.wildnature.client.gui.container.BackpackBigContainer;
import com.matez.wildnature.client.gui.container.BackpackMediumContainer;
import com.matez.wildnature.client.gui.container.BackpackSmallContainer;
import com.matez.wildnature.client.gui.tileEntities.*;
import com.matez.wildnature.common.colors.WNBlockColors;
import com.matez.wildnature.common.colors.WNItemColors;
import com.matez.wildnature.common.blocks.config.ConfigSettings;
import com.matez.wildnature.common.commands.BiomeArgument;
import com.matez.wildnature.common.commands.WNCommand;
import com.matez.wildnature.common.compatibility.WNMinecraftCopatibility;
import com.matez.wildnature.common.compatibility.WNMobSpawnFix;
import com.matez.wildnature.common.compatibility.WNMobSpawning;
import com.matez.wildnature.common.effect.WNEffects;
import com.matez.wildnature.common.items.blowpipe.BlowpipeAmmo;
import com.matez.wildnature.network.packet.WNPackets;
import com.matez.wildnature.util.config.CommonConfig;
import com.matez.wildnature.util.config.WNConfig;
import com.matez.wildnature.common.entity.EntityRegistry;
import com.matez.wildnature.common.entity.render.RenderRegistry;
import com.matez.wildnature.util.dataFixer.WNDataFixer;
import com.matez.wildnature.util.event.*;
import com.matez.wildnature.client.gui.container.PouchContainer;
import com.matez.wildnature.client.gui.initGuis;
import com.matez.wildnature.client.gui.tileEntities.item.ItemTileEntity;
import com.matez.wildnature.common.items.recipes.DyeableRecipe;
import com.matez.wildnature.common.items.recipes.GiftCrafting;
import com.matez.wildnature.common.items.recipes.KnifeCrafting;
import com.matez.wildnature.common.items.recipes.PotCrafting;
import com.matez.wildnature.common.items.recipes.cooking.CraftingTweaker;
import com.matez.wildnature.common.items.recipes.cooking.WNCookingRecipe;
import com.matez.wildnature.common.items.recipes.cooking.WNCookingRecipeSerializer;
import com.matez.wildnature.common.items.recipes.cooking.WNCookingSmelting;
import com.matez.wildnature.util.lists.WNBlocks;
import com.matez.wildnature.client.particles.*;
import com.matez.wildnature.network.proxy.ClientProxy;
import com.matez.wildnature.network.proxy.IProxy;
import com.matez.wildnature.network.proxy.ServerProxy;
import com.matez.wildnature.common.registry.WNRegistry;
import com.matez.wildnature.common.registry.blocks.*;
import com.matez.wildnature.common.registry.items.FoodRegistry;
import com.matez.wildnature.common.registry.items.GemRegistry;
import com.matez.wildnature.common.registry.items.ItemRegistry;
import com.matez.wildnature.common.registry.items.WaterlilyRegistry;
import com.matez.wildnature.common.registry.particles.ParticleRegistry;
import com.matez.wildnature.client.render.WNBlockRenderLayer;
import com.matez.wildnature.client.sounds.SoundRegistry;
import com.matez.wildnature.world.generation.biome.registry.WNBiomes;
import com.matez.wildnature.world.generation.carver.CarverRegistry;
import com.matez.wildnature.world.generation.chunk.type.WNChunkGeneratorType;
import com.matez.wildnature.world.generation.feature.WNFeatures;
import com.matez.wildnature.world.generation.feature.features.RockGen;
import com.matez.wildnature.world.generation.provider.WNBiomeProviderType;
import com.matez.wildnature.world.generation.provider.WNWorldType;
import com.matez.wildnature.world.generation.structures.nature.fallen.FallenRegistry;
import com.matez.wildnature.world.generation.structures.nature.SchemFeature;
import com.matez.wildnature.world.generation.surface.WNSurfaceBuilders;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.command.arguments.ArgumentSerializer;
import net.minecraft.command.arguments.ArgumentTypes;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.ServerProperties;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.versions.forge.ForgeVersion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mod("wildnature")
public class WN {
    public static WN instance;

    public static final String modid = "wildnature";
    public static final String version = "3.0-EA3";

    public static final Logger LOGGER = LogManager.getLogger(modid);
    public static final String WildNaturePrefix = TextFormatting.GOLD.toString() + TextFormatting.BOLD.toString() + "[" + TextFormatting.GREEN.toString() + TextFormatting.BOLD.toString() + "WN" + TextFormatting.GOLD.toString() + TextFormatting.BOLD.toString() + "] " + TextFormatting.AQUA.toString();
    public static WorldType WNWorldType = new WNWorldType("wildnature").setCustomOptions(true);
    private static WNChunkGeneratorType chunkGeneratorType = new WNChunkGeneratorType();
    private static WNBiomeProviderType biomeProviderType = new WNBiomeProviderType();
    public static ArrayList<SchemFeature> treesList = new ArrayList<>();
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    public static boolean gotInfoAboutWorld = true, loadedNewVersion = false;
    public ArrayList<String> supportedLanguages = new ArrayList<>();
    public static boolean usesFancyGraphics = true;
    public static StringTextComponent WNPrefix = new StringTextComponent(WN.WildNaturePrefix);
    public static boolean canShowAdvancedTooltip = false;
    public static World runningWorld;
    public static WNDataFixer dataFixer;
    
    public WN() {
        LOGGER.info("Initializing WildNature mod");
        instance = this;
        addSupportedLanguages();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onServerStarting);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerParticles);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::dedicatedServerSetup);


        File f = new File(FMLPaths.GAMEDIR.get().resolve("wildnature/").toString());
        if (!f.exists()) {
            new File(FMLPaths.GAMEDIR.get().resolve("wildnature/").toString()).mkdirs();
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        WNConfig.register(ModLoadingContext.get());
        ConfigSettings.applyCfgs();
        MinecraftForge.EVENT_BUS.register(this);

        WNPrefix.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new StringTextComponent(TextFormatting.GOLD + "WildNature " + TextFormatting.LIGHT_PURPLE + version)));
        WNPrefix.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://wildnaturemod.com"));

        dataFixer = new WNDataFixer();
    }


    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Setup...");
        RockGen.setupRocks();
        MinecraftForge.EVENT_BUS.addListener(new ParticleFactoryEvent()::registerParticles);
        MinecraftForge.EVENT_BUS.addListener(new TreeBreakEvent()::treeEvent);
        dataFixer.registerDataFixer();

        ArgumentTypes.register("biome_argument", BiomeArgument.class, new ArgumentSerializer<>(BiomeArgument::createArgument));
        WN.LOGGER.info("Using Version " + CommonConfig.currentVersion + " / " + version);

        if (!CommonConfig.currentVersion.get().equals(version)) {
            loadedNewVersion = true;
            WN.LOGGER.info("Using new version! Current: " + version);
            CommonConfig.currentVersion.set(version);
        }
        CommonConfig.compile();

        FallenRegistry.registerAll();
        WNBiomes.registerAll();


        WNMinecraftCopatibility.init();


        WN.LOGGER.info("Re-registering entity spawns. Found " + EntitySpawnPlacementRegistry.REGISTRY.size());
        WNMobSpawnFix.fixAll();
        WNMobSpawning.registerAll();

        EntityRegistry.registerEntitySpawns();


        WNBiomes.unregisterBlacklisted();
        proxy.init();
        WNPackets.registerAll();
        wnInfo("Setup completed");
    }

    private void clientRegistries(final FMLClientSetupEvent event) {
        LOGGER.info("Client setup...");
        WNBlockColors blockColors = new WNBlockColors();
        WNItemColors itemColors = new WNItemColors();
        MinecraftForge.EVENT_BUS.addListener(new GuiEvent()::guiScreenEvent);
        MinecraftForge.EVENT_BUS.addListener(new KeyEvent()::onKey);
        MinecraftForge.EVENT_BUS.addListener(new FogEvent()::fogEvent);
        MinecraftForge.EVENT_BUS.addListener(new FogEvent()::fogColorEvent);
        MinecraftForge.EVENT_BUS.addListener(new RenderCapeHandler()::onRender);
        MinecraftForge.EVENT_BUS.addListener(new PlayerClickEvent()::onPlayerClick);

        RenderRegistry.registryEntityRenders();
        RenderRegistry.registryTileEntityRenders();

        ForgeRegistries.BLOCKS.forEach(WNBlockRenderLayer::setProperRenderLayer);


        wnInfo("Client setup completed");
    }

    @SubscribeEvent
    public void enqueueIMC(InterModEnqueueEvent event) {
        proxy.enqueueIMC(event);
    }

    private void addSupportedLanguages() {
        supportedLanguages.add("en_us");
        supportedLanguages.add("pl_pl");
        supportedLanguages.add("ru_ru");
        supportedLanguages.add("de_de");
    }

    public ArrayList<String> getSupportedLanguages() {
        return supportedLanguages;
    }

    @SubscribeEvent
    public void registerParticles(final net.minecraftforge.client.event.ParticleFactoryRegisterEvent event) {
        LOGGER.info("Registering particle factories...");
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.DUNGEON_HEART, DungeonHeartParticle.Factory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.CRYSTAL_SPARK, CrystalSparkParticle.Factory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.CRYSTAL, CrystalSparkParticle.Factory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.GEYSER, GeyserParticle.GeyserParticleFactory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.STEAM, SteamParticle.Factory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.FLOWERING_LEAF_WHITE_DUST, DustParticle.Factory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.POLLEN, PollenParticle.Factory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.WISTERIA_PINK, DustParticle.Factory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.SLIMESHROOM_GREEN, SlimeshroomParticle.Factory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.SLIMESHROOM_BLUE, SlimeshroomParticle.Factory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.THERMAL_SMOKE, ThermalParticle.ThermalParticleFactory::new);
        Minecraft.getInstance().particles.registerFactory(ParticleRegistry.FUZZBALL_EXPLOSION, FuzzballExplosionParticle.Factory::new);
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent e) {
        WN.LOGGER.debug("Registering commands");
        MinecraftForge.EVENT_BUS.addListener(new PlayerEventHandler()::onPlayerJoin);
        MinecraftForge.EVENT_BUS.addListener(new PlayerEventHandler()::onPlayerExit);
        MinecraftForge.EVENT_BUS.addListener(new CraftingTweaker()::playerCraftedEvent);

        //ProtocolType.PLAY.field_229711_h_.put(SSpawnParticlePacket.class, SSpawnParticlePacket::new)

        WNCommand.register(e.getCommandDispatcher());


        wnInfo("Successfully initialized server-side");
    }

    @SubscribeEvent
    public void dedicatedServerSetup(FMLDedicatedServerSetupEvent event) {
        ServerProperties serverProperties = event.getServerSupplier().get().getServerProperties();
        if (CommonConfig.useWNOnServer.get()) {
            wnInfo("Using WildNature generator on server.");
            LOGGER.info(String.format("Using WildNature on server. Original value: %s", serverProperties.worldType.getName()));
            serverProperties.serverProperties.setProperty("level-type", "wildnature");
            serverProperties.worldType = WN.WNWorldType;
        } else {
            wnInfo("WN Server Generator disabled");
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        public static RegistryEvent.Register<Item> itemEvent;
        public static RegistryEvent.Register<Block> blockEvent;
        public static RegistryEvent.Register<Biome> biomeEvent;
        public static RockRegistry rockRegistry = new RockRegistry();

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {
            LOGGER.info("Registering items...");
            itemEvent = event;

            for (Item itemblock : WNBlocks.ITEMBLOCKS) {
                WNRegistry.registerItems(event, itemblock);
            }

            GemRegistry gems = new GemRegistry();
            FoodRegistry food = new FoodRegistry();
            WaterlilyRegistry waterlily = new WaterlilyRegistry();
            ItemRegistry item = new ItemRegistry();
            WNRegistry.registerItems(event, gems.getItems());
            WNRegistry.registerItems(event, food.getItems());
            WNRegistry.registerItems(event, waterlily.getItems());
            WNRegistry.registerItems(event, item.getItems());


            EntityRegistry.registerSpawningEggs(event);
            BlowpipeAmmo.registerAll();
        }

        @SubscribeEvent
        public static void registerRecipeSerializers(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            LOGGER.info("Registering recipe serializers...");
            event.getRegistry().register(new SpecialRecipeSerializer<>(GiftCrafting::new).setRegistryName("wildnature:gift_crafting"));
            event.getRegistry().register(new SpecialRecipeSerializer<>(DyeableRecipe::new).setRegistryName("wildnature:dyeable_recipe"));
            event.getRegistry().register(new SpecialRecipeSerializer<>(PotCrafting::new).setRegistryName("wildnature:pot_crafting"));
            event.getRegistry().register(new SpecialRecipeSerializer<>(KnifeCrafting::new).setRegistryName("wildnature:knife_chopping"));

            //CUSTOM
            event.getRegistry().register(new WNCookingRecipeSerializer<>(WNCookingRecipe::new, 200).setRegistryName("wildnature:cooking"));
            event.getRegistry().register(new SpecialRecipeSerializer<>(WNCookingSmelting::new).setRegistryName("wildnature:furnace_cooking"));
            event.getRegistry().register(new SpecialRecipeSerializer<>(WNCookingSmelting::new).setRegistryName("wildnature:smoker_cooking"));

        }


        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
            LOGGER.info("Registering entities...");
            event.getRegistry().registerAll(
                    EntityRegistry.ROWAN_BLOWDART, EntityRegistry.SEAT, EntityRegistry.GOBLIN, EntityRegistry.DRAKE, EntityRegistry.DUCK, EntityRegistry.DUCKLING, EntityRegistry.BOAR, EntityRegistry.PIRANHA, EntityRegistry.DRAGONFLY, EntityRegistry.SPARROW_MALE, EntityRegistry.BUCK, EntityRegistry.DOE, EntityRegistry.FAWN
            );

        }

        @SubscribeEvent
        public static void registerFeatures(final RegistryEvent.Register<Feature<?>> event) {
            LOGGER.info("Registering features...");
            WNFeatures.registerAll(event);
        }

        @SubscribeEvent
        public static void registerEffects(final RegistryEvent.Register<Effect> event) {
            LOGGER.info("Registering effects...");
            WNEffects.registerAll(event);
        }

        @SubscribeEvent
        public static void registerSurfaceBuilders(final RegistryEvent.Register<SurfaceBuilder<?>> event) {
            LOGGER.info("Registering surface builders...");
            WNSurfaceBuilders.registerAll(event);
        }

        @SubscribeEvent
        public static void registerCarvers(final RegistryEvent.Register<WorldCarver<?>> event) {
            LOGGER.info("Registering carvers...");
            CarverRegistry.registerAll(event);
        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
            LOGGER.info("Registering blocks...");
            blockEvent = event;



            WoodRegistry woodRegistry = new WoodRegistry();
            FlowerRegistry flowerRegistry = new FlowerRegistry();
            SaplingRegistry saplingRegistry = new SaplingRegistry();
            FurnitureRegistry furnitureRegistry = new FurnitureRegistry();
            GrassRegistry grassRegistry = new GrassRegistry();
            BuildingRegistry buildingRegistry = new BuildingRegistry();
            OtherRegistry otherRegistry = new OtherRegistry();
            OreRegistry oreRegistry = new OreRegistry();



            WNRegistry.registerBlocks(event, woodRegistry.getWoods());
            WNRegistry.registerBlocks(event, furnitureRegistry.getBlock());
            WNRegistry.registerBlocks(event, saplingRegistry.getSaplings());
            WNRegistry.registerBlocks(event, rockRegistry.getRocks());
            WNRegistry.registerBlocks(event, oreRegistry.getOres());
            WNRegistry.registerBlocks(event, flowerRegistry.getFlowers());
            WNRegistry.registerBlocks(event, grassRegistry.getGrass());
            WNRegistry.registerBlocks(event, buildingRegistry.getBlocks());
            WNRegistry.registerBlocks(event, rockRegistry.getDecos());
            WNRegistry.registerBlocks(event, otherRegistry.getBlock());
        }


        @SubscribeEvent
        public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
            LOGGER.info("Registering biomes...");

            event.getRegistry().registerAll(
                    WNBiomes.River,
                    WNBiomes.FrozenRiver,
                    WNBiomes.AmazonRiver,
                    WNBiomes.NileRiver,
                    WNBiomes.CanyonRiver, WNBiomes.IcelandRiver, WNBiomes.DaintreeRiver, WNBiomes.TatraStream

            );


            int x = 0;
            while (x < WNBiomes.registerBiomes.size()) {
                Biome b = WNBiomes.registerBiomes.get(x);
                event.getRegistry().register(b);
                x++;
            }

            WNBiomes.registerAllBiomes();

            //WNBiomeManager.removeAllBiomes("minecraft:");


        }

        @SubscribeEvent
        public static void registerParticles(final RegistryEvent.Register<ParticleType<?>> event) {
            LOGGER.info("Registering particles...");
            BasicParticleType type = ParticleRegistry.DUNGEON_HEART;
            type = ParticleRegistry.CRYSTAL_SPARK;
            type = ParticleRegistry.GEYSER;
            type = ParticleRegistry.STEAM;


        }

        @SubscribeEvent
        public static void registerTileEntities(RegistryEvent.Register<TileEntityType<?>> evt) {
            LOGGER.info("Registering tileEntities...");
            TileEntityType<CustomPistonTileEntity> piston_type = TileEntityType.Builder.create(CustomPistonTileEntity::new, WNBlocks.RS_PISTON1_MOVING).build(null);
            piston_type.setRegistryName("wildnature", "rs_piston1");
            evt.getRegistry().register(piston_type);
            initGuis.PISTON_TYPE = piston_type;

            TileEntityType<DungeonCommanderTileEntity> dungeonCommander = TileEntityType.Builder.create(DungeonCommanderTileEntity::new, WNBlocks.DUNGEON_COMMANDER).build(null);
            dungeonCommander.setRegistryName("wildnature", "dungeon_commander");
            evt.getRegistry().register(dungeonCommander);
            initGuis.DUNGEON_COMMANDER = dungeonCommander;

            TileEntityType<HydrothermalVentTileEntity> hydrothermalVent = TileEntityType.Builder.create(HydrothermalVentTileEntity::new, WNBlocks.HYDROTHERMAL_VENT).build(null);
            hydrothermalVent.setRegistryName("wildnature", "hydrothermal_vent");
            evt.getRegistry().register(hydrothermalVent);
            initGuis.HYDROTHERMAL_VENT_TILE_ENTITY = hydrothermalVent;

            TileEntityType<GravityShroomTileEntity> gravityShroom = TileEntityType.Builder.create(GravityShroomTileEntity::new, WNBlocks.GRAVITYSHROOM).build(null);
            gravityShroom.setRegistryName("wildnature", "gravityshroom");
            evt.getRegistry().register(gravityShroom);
            initGuis.GRAVITY_SHROOM_TILE_ENTITY = gravityShroom;

            TileEntityType<CaveLilyTileEntity> caveLily = TileEntityType.Builder.create(CaveLilyTileEntity::new, WNBlocks.CAVE_LILY_FLOWER).build(null);
            caveLily.setRegistryName("wildnature", "cave_lily");
            evt.getRegistry().register(caveLily);
            initGuis.CAVE_LILY_TILE_ENTITY = caveLily;


            TileEntityType<ItemTileEntity> itemTile = TileEntityType.Builder.create(ItemTileEntity::new, ItemTileEntity.SUPPORTED_BLOCKS.toArray(new Block[0])).build(null);
            itemTile.setRegistryName("wildnature", "item_tile_entity");
            evt.getRegistry().register(itemTile);
            initGuis.ITEM_TILE_ENTITY = itemTile;
        }

        private static final List<ContainerType<?>> CONTAINER_TYPES = new ArrayList<>();


        @SubscribeEvent
        public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
            LOGGER.info("Registering containers...");
            registerContainer("wildnature:pouch", PouchContainer::new);
            registerContainer("wildnature:backpack_small", BackpackSmallContainer::new);
            registerContainer("wildnature:backpack_medium", BackpackMediumContainer::new);
            registerContainer("wildnature:backpack_big", BackpackBigContainer::new);

            CONTAINER_TYPES.forEach(container_type -> event.getRegistry().register(container_type));

        }

        private static <T extends Container> void registerContainer(String name, IContainerFactory<T> container) {
            ContainerType<T> type = IForgeContainerType.create(container);
            type.setRegistryName(name);
            CONTAINER_TYPES.add(type);
        }


        @SubscribeEvent
        public static void registerSounds(final RegistryEvent.Register<SoundEvent> event) {
            LOGGER.info("Registering sounds...");
            //event.getRegistry().register(new SoundEvent(new ResourceLocation("wildnature","block/piston/2s_open")));
            event.getRegistry().registerAll(SoundRegistry.register());


        }


        public static ResourceLocation location(String name) {
            return new ResourceLocation(modid, name);
        }

    }

    public static Block getBlockByID(String resLoc) {
        return Registry.BLOCK.getOrDefault(new ResourceLocation(resLoc));
    }

    public static Item getItemByID(String resLoc) {
        return Registry.ITEM.getOrDefault(new ResourceLocation(resLoc));
    }

    public static Biome getBiomeByID(String resLoc) {
        return Registry.BIOME.getOrDefault(new ResourceLocation(resLoc));
    }

    public static ParticleType getParticleByID(String resLoc) {
        return Registry.PARTICLE_TYPE.getOrDefault(new ResourceLocation(resLoc));
    }

    public static SoundEvent getSoundByID(String resLoc) {
        return Registry.SOUND_EVENT.getOrDefault(new ResourceLocation(resLoc));
    }

    public static void sendServerChatMessage(MinecraftServer server, PlayerEntity playerEntity, String message) {
        if (hasEffect(playerEntity, Effects.INVISIBILITY)) {
            WN.LOGGER.debug("---> Player is invisible, message won't be send");
            return;
        }
        if (server != null) {
            server.sendMessage(new StringTextComponent(message));
            for (PlayerEntity p : server.getPlayerList().getPlayers()) {
                if (p != playerEntity) {
                    sendChatMessage(p, message);
                }
            }
        } else {
            WN.LOGGER.debug("---> Cannot send message. Server == null");
        }
    }

    public static void sendServerChatMessage(MinecraftServer server, PlayerEntity playerEntity, ITextComponent message) {
        WN.LOGGER.debug("Sending Message to server");
        if (hasEffect(playerEntity, Effects.INVISIBILITY)) {
            WN.LOGGER.debug("---> Player is invisible, message won't be send");
            return;
        }
        if (server != null) {
            server.sendMessage(message);
            for (PlayerEntity p : server.getPlayerList().getPlayers()) {
                if (p != playerEntity) {
                    sendChatMessage(p, message);
                }

            }
        } else {
            WN.LOGGER.debug("---> Cannot send message. Server == null");
        }
    }

    public static void sendChatMessage(PlayerEntity entity, String message) {
        entity.sendMessage(new StringTextComponent(message));
    }

    public static void sendChatMessage(PlayerEntity entity, ITextComponent message) {
        entity.sendMessage((message));
    }

    public static boolean hasEffect(LivingEntity entity, Effect effect) {
        ArrayList<Object> effects = new ArrayList<>(Arrays.asList(entity.getActivePotionEffects().toArray()));
        for (Object e : effects) {
            if (e instanceof EffectInstance) {
                if (((EffectInstance) e).getPotion() == effect) {
                    return true;
                }
            }
        }
        return false;
    }


    public static String readFromURL(String sURL) {
        if (!netIsAvailable()) {
            LOGGER.warn("Internet connection unavailable");
            return null;
        }

        try {
            URL url = new URL(sURL);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = in.readLine();
            StringBuilder builder = new StringBuilder();
            do {
                builder.append(line + "\n");
            } while ((line = in.readLine()) != null);
            in.close();
            return builder.toString();
        } catch (Exception e) {
            LOGGER.warn("Cannot connect! Is the server unreachable?");
            return null;
        }
    }

    private static boolean netIsAvailable() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean is404(String url) {
        LOGGER.debug("Testing " + url + " for 404 exception...");
        if (netIsAvailable()) {
            try {
                URL u = new URL(url);
                HttpURLConnection huc = (HttpURLConnection) u.openConnection();
                huc.setRequestMethod("GET");  //OR  huc.setRequestMethod ("HEAD");
                huc.connect();
                int code = huc.getResponseCode();
                LOGGER.debug("Response code: " + code);
                return code == 404;
            } catch (Exception e) {
                LOGGER.warn("Exception during 404 test: " + e.getLocalizedMessage());
            }
        } else {
            LOGGER.debug("Internet not available");
        }
        return true;
    }


    public static void wnInfo(String data) {
        LOGGER.info(TextFormatting.AQUA + "---------------------------------");
        LOGGER.info(TextFormatting.GREEN + " WildNature " + version + " // " + ForgeVersion.getVersion());
        LOGGER.info(TextFormatting.GREEN + " https://wildnaturemod.com");
        LOGGER.info(TextFormatting.DARK_AQUA + "---");
        LOGGER.info(TextFormatting.YELLOW + data);
        LOGGER.info(TextFormatting.DARK_AQUA + "---");
        LOGGER.info(TextFormatting.AQUA + "---------------------------------");

    }
}
