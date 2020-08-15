package com.matez.wildnature;

import com.matez.wildnature.commands.BiomeArgument;
import com.matez.wildnature.compatibility.WNMinecraftCopatibility;
import com.matez.wildnature.compatibility.WNMobSpawnFix;
import com.matez.wildnature.compatibility.WNMobSpawning;
import com.matez.wildnature.entity.EntityRegistry;
import com.matez.wildnature.entity.render.RenderRegistry;
import com.matez.wildnature.event.*;
import com.matez.wildnature.gui.container.PouchContainer;
import com.matez.wildnature.gui.initGuis;
import com.matez.wildnature.gui.tileEntities.DungeonCommanderTileEntity;
import com.matez.wildnature.gui.tileEntities.GravityShroomTileEntity;
import com.matez.wildnature.gui.tileEntities.HydrothermalVentTileEntity;
import com.matez.wildnature.items.*;
import com.matez.wildnature.items.recipes.KnifeCrafting;
import com.matez.wildnature.items.recipes.PotCrafting;
import com.matez.wildnature.items.recipes.cooking.*;
import com.matez.wildnature.items.tier.WNItemTier;
import com.matez.wildnature.lists.WNBlocks;
import com.matez.wildnature.lists.WNItems;
import com.matez.wildnature.packets.WNSSpawnParticlePacket;
import com.matez.wildnature.particles.*;
import com.matez.wildnature.proxy.ClientProxy;
import com.matez.wildnature.proxy.IProxy;
import com.matez.wildnature.proxy.ServerProxy;
import com.matez.wildnature.registry.*;
import com.matez.wildnature.render.WNBlockRenderLayer;
import com.matez.wildnature.world.gen.biomes.setup.WNBiomes;
import com.matez.wildnature.world.gen.carvers.CarverRegistry;
import com.matez.wildnature.world.gen.chunk.WNChunkGeneratorType;
import com.matez.wildnature.world.gen.feature.FeatureRegistry;
import com.matez.wildnature.world.gen.feature.features.RockGen;
import com.matez.wildnature.world.gen.provider.WNBiomeProviderType;
import com.matez.wildnature.world.gen.provider.WNWorldType;
import com.matez.wildnature.world.gen.structures.nature.SchemFeature;
import com.matez.wildnature.blocks.colors.WNBlockColors;
import com.matez.wildnature.blocks.colors.WNItemColors;
import com.matez.wildnature.blocks.config.ConfigSettings;
import com.matez.wildnature.commands.WNCommand;
import com.matez.wildnature.customizable.CommonConfig;
import com.matez.wildnature.customizable.WNConfig;
import com.matez.wildnature.gui.tileEntities.CustomPistonTileEntity;
import com.matez.wildnature.itemGroup.wnItemGroup;
import com.matez.wildnature.itemGroup.wnItemGroupBuilding;
import com.matez.wildnature.itemGroup.wnItemGroupDeco;
import com.matez.wildnature.itemGroup.wnItemGroupUnderground;
import com.matez.wildnature.items.recipes.DyeableRecipe;
import com.matez.wildnature.items.recipes.GiftCrafting;
import com.matez.wildnature.sounds.SoundRegistry;
import com.matez.wildnature.world.gen.surface.SurfaceRegistry;
import net.minecraft.block.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ClientResourcePackInfo;
import net.minecraft.command.arguments.ArgumentSerializer;
import net.minecraft.command.arguments.ArgumentTypes;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.network.PacketDirection;
import net.minecraft.network.ProtocolType;
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
import java.util.*;

@Mod("wildnature")
public class Main {
    public static Main instance;
    public static final String modid = "wildnature";
    public static final String version = "2.1.7";
    public static final Logger LOGGER = LogManager.getLogger(modid);
    public static final wnItemGroup WILDNATURE_GROUP = new wnItemGroup();
    public static final wnItemGroupUnderground WILDNATURE_UNDERGROUND_GROUP = new wnItemGroupUnderground();
    public static final wnItemGroupDeco WILDNATURE_DECO_GROUP = new wnItemGroupDeco();
    public static final wnItemGroupBuilding WILDNATURE_BUILDING_GROUP = new wnItemGroupBuilding();
    public static final String WildNaturePrefix = TextFormatting.GOLD.toString()+TextFormatting.BOLD.toString()+"["+TextFormatting.GREEN.toString()+TextFormatting.BOLD.toString()+"WN"+TextFormatting.GOLD.toString()+TextFormatting.BOLD.toString()+"] "+TextFormatting.AQUA.toString();
    public static WorldType WNWorldType = new WNWorldType("wildnature").setCustomOptions(true);
    private static WNChunkGeneratorType chunkGeneratorType = new WNChunkGeneratorType();
    private static WNBiomeProviderType biomeProviderType = new WNBiomeProviderType();
    public static ArrayList<SchemFeature> treesList = new ArrayList<>();
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    public static boolean gotInfoAboutWorld = true, loadedNewVersion = false;
    public ArrayList<String> supportedLanguages = new ArrayList<>();
    public static boolean usesFancyGraphics = true;
    public static StringTextComponent WNPrefix = new StringTextComponent(Main.WildNaturePrefix);
    public static boolean canShowAdvancedTooltip = false;
    public static World runningWorld;


    public Main(){
        LOGGER.info("Initializing WildNature mod");
        instance=this;
        addSupportedLanguages();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onServerStarting);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerParticles);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::dedicatedServerSetup);

        File f = new File(FMLPaths.GAMEDIR.get().resolve("wildnature/").toString());
        if(!f.exists()){
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

        WNPrefix.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,new StringTextComponent(TextFormatting.GOLD + "WildNature " + TextFormatting.LIGHT_PURPLE + version)));
        WNPrefix.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL,"https://wildnaturemod.com"));


        //ProtocolType.PLAY.registerPacket(PacketDirection.CLIENTBOUND, WNSSpawnParticlePacket.class); TODO Registering packets
    }



    private void setup(final FMLCommonSetupEvent event){
        LOGGER.info("Setup...");
        RockGen.setupRocks();
        MinecraftForge.EVENT_BUS.addListener(new ParticleFactoryEvent()::registerParticles);

        ArgumentTypes.register("biome_argument", BiomeArgument.class, new ArgumentSerializer<>(BiomeArgument::createArgument));
        Main.LOGGER.info("Using Version "+ CommonConfig.currentVersion+" / " + version);

        if(!CommonConfig.currentVersion.get().equals(version)){
            loadedNewVersion=true;
            Main.LOGGER.info("Using new version! Current: " + version);
            CommonConfig.currentVersion.set(version);
        }
        CommonConfig.compile();

        com.matez.wildnature.world.gen.biomes.setup.WNBiomes.registerAll();

        WNMinecraftCopatibility.init();


        Main.LOGGER.info("Re-registering entity spawns. Found " + EntitySpawnPlacementRegistry.REGISTRY.size());
        /*EntitySpawnPlacementRegistry.REGISTRY.forEach((entity,entry) -> {
            EntitySpawnPlacementRegistry.Entry e = EntitySpawnPlacementRegistry.REGISTRY.get(entity);
            entrySpawnType=e;
            EntitySpawnPlacementRegistry.REGISTRY.replace(entity,e, new EntitySpawnPlacementRegistry.Entry(e.type,e.placementType,Main::getEntitySpawnPlacementPredicate));
        });*/
        WNMobSpawnFix.fixAll();
        WNMobSpawning.registerAll();

        EntityRegistry.registerEntitySpawns();



        WNBiomes.unregisterBlacklisted();
        proxy.init();
        wnInfo("Setup completed");
    }

    private void clientRegistries(final FMLClientSetupEvent event){
        LOGGER.info("Client setup...");
        WNBlockColors blockColors = new WNBlockColors();
        WNItemColors itemColors = new WNItemColors();
        MinecraftForge.EVENT_BUS.addListener(new GuiEvent()::guiScreenEvent);
        MinecraftForge.EVENT_BUS.addListener(new KeyEvent()::onKey);
        MinecraftForge.EVENT_BUS.addListener(new FogEvent()::fogEvent);
        MinecraftForge.EVENT_BUS.addListener(new FogEvent()::fogColorEvent);
        //MinecraftForge.EVENT_BUS.addListener(new KeySipkeEvent()::onKey);
        MinecraftForge.EVENT_BUS.addListener(new RenderCapeHandler()::onRender);
        //MinecraftForge.EVENT_BUS.addListener(new FogEvent()::fogEvent);
        //MinecraftForge.EVENT_BUS.addListener(new ClientPlayerEventHandler()::onPlayerJoin);

        RenderRegistry.registryEntityRenders();
        ForgeRegistries.BLOCKS.forEach(WNBlockRenderLayer::setProperRenderLayer);
        //MinecraftForge.EVENT_BUS.addListener(new AmbientSoundPlayer(Minecraft.getInstance())::playerTick);



        wnInfo("Client setup completed");
    }

    @SubscribeEvent
    public void enqueueIMC(InterModEnqueueEvent event) {
        proxy.enqueueIMC(event);
    }

    private void addSupportedLanguages(){
        supportedLanguages.add("en_us");
        supportedLanguages.add("pl_pl");
        supportedLanguages.add("ru_ru");
        supportedLanguages.add("de_de");
    }

    public ArrayList<String> getSupportedLanguages() {
        return supportedLanguages;
    }

    @SubscribeEvent
    public void registerParticles(final net.minecraftforge.client.event.ParticleFactoryRegisterEvent event){
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
    public void onServerStarting(FMLServerStartingEvent e)
    {
        Main.LOGGER.debug("Registering commands");
        MinecraftForge.EVENT_BUS.addListener(new PlayerEventHandler()::onPlayerJoin);
        MinecraftForge.EVENT_BUS.addListener(new PlayerEventHandler()::onPlayerExit);
        MinecraftForge.EVENT_BUS.addListener(new CraftingTweaker()::playerCraftedEvent);



        WNCommand.register(e.getCommandDispatcher());


        wnInfo("Successfully initialized server-side");
    }
    @SubscribeEvent
    public void dedicatedServerSetup(FMLDedicatedServerSetupEvent event)
    {
        ServerProperties serverProperties = event.getServerSupplier().get().getServerProperties();

        if (CommonConfig.useWNOnServer.get())
        {
            LOGGER.info(String.format("Using WildNature on server. Original value: %s", serverProperties.worldType.getName()));
            serverProperties.serverProperties.setProperty("level-type", "wildnature");
            serverProperties.worldType = Main.WNWorldType;
        }
        else
        {
            Main.LOGGER.info("WN Server Gen disabled");
        }
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents{
        public static RegistryEvent.Register<Item> itemEvent;
        public static RegistryEvent.Register<Block> blockEvent;
        public static RegistryEvent.Register<Biome> biomeEvent;
        public static RockRegistry rockRegistry = new RockRegistry();
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event){
            LOGGER.info("Registering items...");


            itemEvent=event;

            int ib = 0;
            while(ib< WNBlocks.ITEMBLOCKS.size()){
                event.getRegistry().register(WNBlocks.ITEMBLOCKS.get(ib));
                ib++;
            }
            Food smallFruit = (new Food.Builder()).hunger(2).saturation(0.6F).fastToEat().build();

            Food CHERRY = (new Food.Builder()).hunger(2).saturation(0.6F).build();
            Food PLUM = (new Food.Builder()).hunger(2).saturation(0.6F).build();
            Food CORN = (new Food.Builder()).hunger(2).saturation(0.3F).build();
            Food TOMATO = (new Food.Builder()).hunger(2).saturation(0.5F).build();
            Food TOMATO_SOUP = (new Food.Builder()).hunger(16).saturation(1F).build();
            Food CANDY_CANE = (new Food.Builder()).hunger(3).saturation(0.3F).build();
            Food CANDY = (new Food.Builder()).hunger(3).saturation(0.3F).build();
            Food DONUTS = (new Food.Builder()).hunger(2).saturation(0.3F).build();
            Food CHOCOLATE = (new Food.Builder()).hunger(5).saturation(0.3F).build();
            Food CARAMEL = (new Food.Builder()).hunger(1).saturation(0.2F).build();
            Food DRINK = (new Food.Builder()).hunger(0).saturation(0.7F).build();


            event.getRegistry().registerAll(
                    WNItems.ROSACEAE_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.ROSACEAE_SIGN, WNBlocks.ROSACEAE_WALL_SIGN).setRegistryName(location("rosaceae_sign")),
                    WNItems.BAOBAB_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.BAOBAB_SIGN, WNBlocks.BAOBAB_WALL_SIGN).setRegistryName(location("baobab_sign")),
                    WNItems.BEECH_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.BEECH_SIGN, WNBlocks.BEECH_WALL_SIGN).setRegistryName(location("beech_sign")),
                    WNItems.CEDAR_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.CEDAR_SIGN, WNBlocks.CEDAR_WALL_SIGN).setRegistryName(location("cedar_sign")),
                    WNItems.CHERRY_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.CHERRY_SIGN, WNBlocks.CHERRY_WALL_SIGN).setRegistryName(location("cherry_sign")),
                    WNItems.EBONY_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.EBONY_SIGN, WNBlocks.EBONY_WALL_SIGN).setRegistryName(location("ebony_sign")),
                    WNItems.JACARANDA_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.JACARANDA_SIGN, WNBlocks.JACARANDA_WALL_SIGN).setRegistryName(location("jacaranda_sign")),
                    WNItems.LARCH_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.LARCH_SIGN, WNBlocks.LARCH_WALL_SIGN).setRegistryName(location("larch_sign")),
                    WNItems.MAHOGANY_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.MAHOGANY_SIGN, WNBlocks.MAHOGANY_WALL_SIGN).setRegistryName(location("mahogany_sign")),
                    WNItems.MANGROVE_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.MANGROVE_SIGN, WNBlocks.MANGROVE_WALL_SIGN).setRegistryName(location("mangrove_sign")),
                    WNItems.MAPLE_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.MAPLE_SIGN, WNBlocks.MAPLE_WALL_SIGN).setRegistryName(location("maple_sign")),
                    WNItems.PALM_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.PALM_SIGN, WNBlocks.PALM_WALL_SIGN).setRegistryName(location("palm_sign")),
                    WNItems.PLUM_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.PLUM_SIGN, WNBlocks.PLUM_WALL_SIGN).setRegistryName(location("plum_sign")),
                    WNItems.REDWOOD_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.REDWOOD_SIGN, WNBlocks.REDWOOD_WALL_SIGN).setRegistryName(location("redwood_sign")),
                    WNItems.WILLOW_SIGN = new SignItem((new Item.Properties()).maxStackSize(16), WNBlocks.WILLOW_SIGN, WNBlocks.WILLOW_WALL_SIGN).setRegistryName(location("willow_sign"))

            );



            event.getRegistry().registerAll(
                    //FRUITS
                    WNItems.GREEN_APPLE = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.APPLE)).setRegistryName(location("green_apple")),
                    WNItems.PARADISE_APPLE = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.APPLE)).setRegistryName(location("paradise_apple")),
                    WNItems.CHERRY = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CHERRY)).setRegistryName(location("cherry")),
                    WNItems.PEAR = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.APPLE)).setRegistryName(location("pear")),
                    WNItems.RASPBERRY = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("raspberry")),
                    WNItems.BLUEBERRY = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("blueberry")),
                    WNItems.LINGONBERRY = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("lingonberry")),
                    WNItems.BLACKBERRY = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("blackberry")),
                    WNItems.GOOSEBERRY = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("gooseberry")),
                    WNItems.CHOKE_BERRY = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("chokeberry")),
                    WNItems.BLACK_CURRANT = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("black_currant")),
                    WNItems.RED_CURRANT = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("red_currant")),
                    WNItems.WHITE_CURRANT = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("white_currant")),
                    WNItems.HAWTHORN_BERRY = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("hawthorn_berry")),
                    WNItems.KAMCHATKA_BERRY = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("kamchatka_berry")),
                    WNItems.WILD_STRAWBERRY = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("wild_strawberry")),
                    WNItems.QUINCE_FRUIT = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("quince_fruit")),
                    WNItems.BILBERRIES = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("bilberries")),
                    WNItems.BLACK_LILAC_BERRIES = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("black_lilac_berries")),
                    WNItems.CRANBERRIES = new Item(new Item.Properties().group(ItemGroup.FOOD).food(smallFruit)).setRegistryName(location("cranberries")),


                    WNItems.PLUM = new Item(new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("plum")),
                    WNItems.MIRABELLE_PLUM = new Item(new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("mirabelle_plum")),
                    WNItems.ACORN = new Item(new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("acorn")),
                    WNItems.GREEN_WATERLILY = new WaterlilyItem(getBlockByID("wildnature:green_waterlily"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("green_waterlily")),
                    WNItems.RED_WATERLILY = new WaterlilyItem(getBlockByID("wildnature:red_waterlily"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("red_waterlily")),
                    WNItems.DUCKWEED = new WaterlilyItem(getBlockByID("wildnature:duckweed"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("duckweed")),
                    WNItems.WATER_POPPY = new WaterlilyItem(getBlockByID("wildnature:water_poppy"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("water_poppy")),
                    WNItems.WATER_LILY_WHITE = new WaterlilyItem(getBlockByID("wildnature:water_lily_white"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("water_lily_white")),
                    WNItems.WATER_LILY_YELLOW = new WaterlilyItem(getBlockByID("wildnature:water_lily_yellow"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("water_lily_yellow")),
                    WNItems.LOTUS_PINK = new WaterlilyItem(getBlockByID("wildnature:lotus_pink"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("lotus_pink")),
                    WNItems.LOTUS_LIGHT_PINK = new WaterlilyItem(getBlockByID("wildnature:lotus_light_pink"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("lotus_light_pink")),
                    WNItems.LOTUS_WHITE = new WaterlilyItem(getBlockByID("wildnature:lotus_white"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("lotus_white")),
                    WNItems.WATER_HYACINTH = new WaterlilyItem(getBlockByID("wildnature:water_hyacinth"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("water_hyacinth")),
                    WNItems.POND_WEED = new WaterlilyItem(getBlockByID("wildnature:pond_weed"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("pond_weed")),
                    WNItems.PARROTS_FEATHER_PLANT = new WaterlilyItem(getBlockByID("wildnature:parrots_feather_plant"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("parrots_feather_plant")),
                    WNItems.MAGMA_PAD = new LavalilyItem(getBlockByID("wildnature:magma_pad"),new Item.Properties().group(WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(location("magma_pad")),

                    WNItems.GRAPES_PURPLE = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.APPLE)).setRegistryName(location("grapes_purple")),
                    WNItems.GRAPES_YELLOW = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.APPLE)).setRegistryName(location("grapes_yellow")),

                    WNItems.WILD_ROSE_FRUIT = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.APPLE)).setRegistryName(location("wild_rose_fruit")),

                    WNItems.BELLADONNA_FRUIT = new BelladonnaItem(new Item.Properties().group(ItemGroup.FOOD).food(Foods.APPLE)).setRegistryName(location("belladonna_fruit")),


                    //CITRUS
                    WNItems.LEMON = new Item(new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("lemon")),
                    WNItems.ORANGE = new Item(new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("orange")),
                    WNItems.GRAPEFRUIT = new Item(new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("grapefruit")),
                    WNItems.BANANA = new Item(new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("banana")),
                    WNItems.LIME = new Item(new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("lime")),
                    WNItems.OLIVES = new Item(new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("olives")),
                    WNItems.PEACH = new Item(new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("peach")),
                    WNItems.PINEAPPLE = new BlockNamedItem(Main.getBlockByID("wildnature:pineapple_plant"),new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("pineapple")),
                    WNItems.POMEGRANATE = new Item(new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("pomegranate")),
                    WNItems.MANGO = new Item(new Item.Properties().group(ItemGroup.FOOD).food(PLUM)).setRegistryName(location("mango")),

                    WNItems.LEMON_WEDGE = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("lemon_wedge")),



                    //PLANTS
                    WNItems.BROCCOLI = new BlockNamedItem(Main.getBlockByID("wildnature:broccoli_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("broccoli")),
                    WNItems.CABBAGE = new BlockNamedItem(Main.getBlockByID("wildnature:cabbage_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("cabbage")),
                    WNItems.CAULIFLOWER = new BlockNamedItem(Main.getBlockByID("wildnature:cauliflower_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("cauliflower")),
                    WNItems.CELERY = new BlockNamedItem(Main.getBlockByID("wildnature:celery_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("celery")),
                    WNItems.CHIVES = new BlockNamedItem(Main.getBlockByID("wildnature:chives_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("chives")),
                    WNItems.CORN = new BlockNamedItem(Main.getBlockByID("wildnature:corn_bush"),new Item.Properties().group(ItemGroup.FOOD).food(CORN)).setRegistryName(location("corn")),
                    WNItems.CUCUMBER = new BlockNamedItem(Main.getBlockByID("wildnature:cucumber_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("cucumber")),
                    WNItems.EGGPLANT = new BlockNamedItem(Main.getBlockByID("wildnature:eggplant_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("eggplant")),
                    WNItems.GARLIC = new BlockNamedItem(Main.getBlockByID("wildnature:garlic_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("garlic")),
                    WNItems.GINGER = new BlockNamedItem(Main.getBlockByID("wildnature:ginger_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("ginger")),
                    WNItems.GREEN_BEANS = new BlockNamedItem(Main.getBlockByID("wildnature:green_bean_bush"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("green_beans")),
                    WNItems.GREEN_PEPPER = new BlockNamedItem(Main.getBlockByID("wildnature:green_pepper_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("green_pepper")),
                    WNItems.HORSE_RADISH = new BlockNamedItem(Main.getBlockByID("wildnature:horse_radish_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("horse_radish")),
                    WNItems.LEEK = new BlockNamedItem(Main.getBlockByID("wildnature:leek_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("leek")),
                    WNItems.LETTUCE = new BlockNamedItem(Main.getBlockByID("wildnature:lettuce_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("lettuce")),
                    WNItems.ONION = new BlockNamedItem(Main.getBlockByID("wildnature:onion_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("onion")),
                    WNItems.PEANUT = new BlockNamedItem(Main.getBlockByID("wildnature:peanut_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("peanut")),
                    WNItems.PEAS = new BlockNamedItem(Main.getBlockByID("wildnature:pea_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("peas")),
                    WNItems.RED_ONION = new BlockNamedItem(Main.getBlockByID("wildnature:red_onion_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("red_onion")),
                    WNItems.RED_PEPPER = new BlockNamedItem(Main.getBlockByID("wildnature:red_pepper_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("red_pepper")),
                    WNItems.RHUBARB = new BlockNamedItem(Main.getBlockByID("wildnature:rhubarb_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("rhubarb")),
                    WNItems.RICE = new BlockNamedItem(Main.getBlockByID("wildnature:rice_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("rice")),
                    WNItems.TOMATO = new Item(new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("tomato")),
                    WNItems.TOMATO_SEEDS = new BlockNamedItem(Main.getBlockByID("wildnature:tomato_plant"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("tomato_seeds")),
                    WNItems.TURNIP = new BlockNamedItem(Main.getBlockByID("wildnature:turnip_plant"),new Item.Properties().group(ItemGroup.FOOD).food(TOMATO)).setRegistryName(location("turnip")),



                    WNItems.COTTON = new BlockNamedItem(Main.getBlockByID("wildnature:cotton_plant"),new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("cotton")),





                    WNItems.BASIL = new BlockNamedItem(Main.getBlockByID("wildnature:basil_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("basil")),
                    WNItems.CHOPPED_CHIVES = new FoodItem(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("chopped_chives")),
                    WNItems.CURRY_LEAVES = new BlockNamedItem(Main.getBlockByID("wildnature:curry_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("curry_leaves")),
                    WNItems.DRIED_MARJORAM = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("dried_marjoram")),
                    WNItems.DRIED_PARSLEY = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("dried_parsley")),
                    WNItems.DRIED_SAGE = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("dried_sage")),
                    WNItems.FRESH_MARJORAM = new BlockNamedItem(Main.getBlockByID("wildnature:marjoram_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("fresh_marjoram")),
                    WNItems.FRESH_ROSEMARY = new BlockNamedItem(Main.getBlockByID("wildnature:rosemary_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("fresh_rosemary")),
                    WNItems.GARLIC_CLOVES = new FoodItem(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("garlic_cloves")),
                    WNItems.TURMERIC = new BlockNamedItem(Main.getBlockByID("wildnature:tumeric_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("turmeric")),

                    WNItems.SALT = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("salt")),
                    WNItems.PEPPER = new BlockNamedItem(Main.getBlockByID("wildnature:black_pepper_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("pepper")),

                    WNItems.BUTTER = new FoodItem(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("butter")),
                    WNItems.DOUGH_BALL = new FoodItem(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("dough_ball")),


                    //TEA LEAF
                    WNItems.BLACK_TEA_LEAVES = new BlockNamedItem(Main.getBlockByID("wildnature:black_tea_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("black_tea_leaves")),
                    WNItems.GREEN_TEA_LEAVES = new BlockNamedItem(Main.getBlockByID("wildnature:green_tea_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("green_tea_leaves")),
                    WNItems.MELISSA_TEA_LEAF = new BlockNamedItem(Main.getBlockByID("wildnature:melissa_tea_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("melissa_tea_leaf")),
                    WNItems.MINT = new BlockNamedItem(Main.getBlockByID("wildnature:mint_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("mint")),
                    WNItems.WHITE_TEA_LEAVES = new BlockNamedItem(Main.getBlockByID("wildnature:white_tea_plant"),new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("white_tea_leaves")),

                    WNItems.MUSHROOM_MIX = new FoodItem(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("mushroom_mix")),
                    WNItems.DRIED_MUSHROOM_MIX = new FoodItem(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("dried_mushroom_mix")),


                    WNItems.COFFEE_LEAVES = new Item(new Item.Properties().group(Main.WILDNATURE_GROUP)).setRegistryName(location("coffee_leaves")),
                    WNItems.COFFEE_BRANCH = new Item(new Item.Properties().group(Main.WILDNATURE_GROUP)).setRegistryName(location("coffee_branch")),
                    WNItems.COFFEE_BERRY_GREEN = new Item(new Item.Properties().group(Main.WILDNATURE_GROUP)).setRegistryName(location("coffee_berry_green")),
                    WNItems.COFFEE_BERRY = new Item(new Item.Properties().group(Main.WILDNATURE_GROUP)).setRegistryName(location("coffee_berry")),
                    WNItems.COFFEE_BEAN = new Item(new Item.Properties().group(Main.WILDNATURE_GROUP)).setRegistryName(location("coffee_bean")),
                    WNItems.COFFEE_POWDER = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("coffee_powder")),
                    WNItems.CUP = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("cup")),
                    WNItems.CUP_OF_COFFEE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:cup")).setRegistryName(location("cup_of_coffee")),
                    WNItems.JUG = new JugItem(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("jug")),
                    WNItems.JUG_WATER = new WaterJugItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1)).setRegistryName(location("jug_water")),
                    WNItems.GLASS = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CANDY_CANE)).setRegistryName(location("glass")),
                    WNItems.CACAO = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:glass"),true).setRegistryName(location("cacao")),
                    WNItems.JAR = new JarItem(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("jar")),
                    WNItems.JAR_WATER = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD),("wildnature:jar"),true).setRegistryName(location("jar_water")),
                    WNItems.CARAMEL_JAR = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar"),true).setRegistryName(location("caramel_jar")),
                    WNItems.GLASS_CUP = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("glass_cup")),
                    WNItems.WINE_BOTTLE = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("wine_bottle")),
                    WNItems.WOODEN_MUG = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("wooden_mug")),
                    WNItems.PLATE = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("plate")),


                    //JAMS


                    WNItems.MAPLE_BOWL = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("maple_bowl")),
                    WNItems.DEEP_BOWL = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("deep_bowl")),



                    WNItems.WOODEN_HAMMER = new Item(new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("wooden_hammer")),
                    WNItems.STONE_HAMMER = new Item(new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("stone_hammer")),
                    WNItems.IRON_HAMMER = new Item(new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("iron_hammer")),

                    WNItems.CHEF_KNIFE = new KnifeItem(WNItemTier.KITCHEN_TOOLS,1,5,new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1)).setRegistryName(location("chef_knife")),
                    WNItems.FRYING_PAN = new CookingItem(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1), CookingToolType.FRYING_PAN).setRegistryName(location("frying_pan")),
                    WNItems.POT_EMPTY = new PotEmptyItem(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1)).setRegistryName(location("pot_empty")),
                    WNItems.POT_WATER = new CookingItem(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1), CookingToolType.POT).setRegistryName(location("pot_water")),
                    WNItems.CAKE_PAN = new CookingItem(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1), CookingToolType.CAKE_PAN).setRegistryName(location("cake_pan")),


                    //SOUPS
                    WNItems.CABBAGE_LETTUCE_SALAD = new DeepBowlSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(10).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("cabbage_lettuce_salad")),
                    WNItems.CEASAR_SALAD = new DeepBowlSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(14).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("ceasar_salad")),
                    WNItems.GARDEN_SALAD = new DeepBowlSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(14).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("garden_salad")),
                    WNItems.ONION_SALAD = new DeepBowlSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(14).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("onion_salad")),
                    WNItems.RICE_VEGGIE_CURRY_BOWL = new DeepBowlSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(22).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("rice_veggie_curry_bowl")),
                    WNItems.VEGETABLE_SALAD = new DeepBowlSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(22).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("vegetable_salad")),

                    WNItems.BIGOS = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(12).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("bigos")),
                    WNItems.BEEF_STEW = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(18).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("beef_stew")),
                    WNItems.BORSCHT = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(18).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("borscht")),
                    WNItems.CABBAGE_SOUP = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(16).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("cabbage_soup")),
                    WNItems.CHICKEN_SOUP = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(18).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("chicken_soup")),
                    WNItems.CREAM_OF_BROCCOLI_SOUP = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(12).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("cream_of_broccoli_soup")),
                    WNItems.CREAM_OF_MUSHROOM_SOUP = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(14).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("cream_of_mushroom_soup")),
                    WNItems.CUCUMBER_SOUP = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(15).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("cucumber_soup")),
                    WNItems.CURRY_SOUP = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(11).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("curry_soup")),
                    WNItems.GARLIC_MUSHROOM_GRAVY = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(13).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("garlic_mushroom_gravy")),
                    WNItems.ONION_SOUP = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(15).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("onion_soup")),
                    WNItems.PEA_SOUP = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(15).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("pea_soup")),
                    WNItems.RED_WINE_REDUCTION_SAUCE = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(16).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("red_wine_reduction_sauce")),
                    WNItems.SAUERKRAUT_SOUP = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(14).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("sauerkraut_soup")),
                    WNItems.TOMATO_SOUP = new MapleSoupItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(15).saturation(1F).build()).maxStackSize(1)).setRegistryName(location("tomato_soup")),


                    //MEALS
                    WNItems.ASIAGO_CHEESE = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(4).saturation(0.9F).build())).setRegistryName(location("asiago_cheese")),
                    WNItems.CHEDDAR_CHEESE = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(3).saturation(0.9F).build())).setRegistryName(location("cheddar_cheese")),
                    WNItems.SWISS_CHEESE = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(5).saturation(0.9F).build())).setRegistryName(location("swiss_cheese")),

                    WNItems.BAGEL_POPPY_SEED = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(6).saturation(0.2F).build())).setRegistryName(location("bagel_poppy_seed")),
                    WNItems.BANANA_BREAD = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(6).saturation(0.2F).build())).setRegistryName(location("banana_bread")),
                    WNItems.SLICED_BREAD = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(1).saturation(0.2F).build())).setRegistryName(location("sliced_bread")),
                    WNItems.GARLIC_BREAD = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(2).saturation(0.2F).build())).setRegistryName(location("garlic_bread")),
                    WNItems.TOAST = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(2).saturation(0.2F).build())).setRegistryName(location("toast")),
                    WNItems.FRENCH_TOAST = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(5).saturation(0.4F).build())).setRegistryName(location("french_toast")),

                    WNItems.RAW_BACON = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(4).saturation(0.5F).build())).setRegistryName(location("raw_bacon")),
                    WNItems.COOKED_BACON = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(5).saturation(0.5F).build())).setRegistryName(location("cooked_bacon")),
                    WNItems.BACON_BITS = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(2).saturation(0.5F).build())).setRegistryName(location("bacon_bits")),

                    WNItems.FRIED_EGG = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(4).saturation(0.6F).build())).setRegistryName(location("fried_egg")),

                    WNItems.GRAHAM_CRACKER = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(2).saturation(0.2F).build())).setRegistryName(location("graham_cracker")),
                    WNItems.GRILLED_CAULIFLOWER = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(5).saturation(0.3F).build())).setRegistryName(location("grilled_cauliflower")),
                    WNItems.SAUERKRAUT = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(5).saturation(1F).build()),FillTool.PLATE).setRegistryName(location("sauerkraut")),
                    WNItems.SMORE = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(7).saturation(0.2F).build())).setRegistryName(location("smore")),
                    WNItems.SUSHI = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(6).saturation(1F).build())).setRegistryName(location("sushi")),

                    WNItems.CHEESE_PIZZA = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(22).saturation(0.5F).build())).setRegistryName(location("cheese_pizza")),
                    WNItems.HAWAIIAN_PIZZA = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(22).saturation(0.7F).build())).setRegistryName(location("hawaiian_pizza")),
                    WNItems.PEPPERONI_PIZZA = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(22).saturation(0.5F).build())).setRegistryName(location("pepperoni_pizza")),
                    WNItems.CEBULARZ = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(10).saturation(0.7F).build())).setRegistryName(location("cebularz")),

                    WNItems.TORTILLA = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(4).saturation(0.5F).build())).setRegistryName(location("tortilla")),
                    WNItems.BEEF_AND_PEPPER_BURRITO = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(18).saturation(0.5F).build())).setRegistryName(location("beef_and_pepper_burrito")),
                    WNItems.CHICKEN_AND_CORN_BURRITO = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(18).saturation(0.5F).build())).setRegistryName(location("chicken_and_corn_burrito")),
                    WNItems.PORK_AND_GREEN_BEAN_BURRITO = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(18).saturation(0.5F).build())).setRegistryName(location("pork_and_green_bean_burrito")),
                    WNItems.VEGETABLE_AND_CHEESE_BURRITO = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(18).saturation(0.5F).build())).setRegistryName(location("vegetable_and_cheese_burrito")),

                    WNItems.BEEF_SANDWICH = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(14).saturation(0.6F).build())).setRegistryName(location("beef_sandwich")),
                    WNItems.BEEF_SANDWICH_WITH_CHEDDAR = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(18).saturation(0.8F).build())).setRegistryName(location("beef_sandwich_with_cheddar")),
                    WNItems.CHICKEN_SANDWICH = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(14).saturation(0.6F).build())).setRegistryName(location("chicken_sandwich")),
                    WNItems.PORK_SANDWICH = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(14).saturation(0.6F).build())).setRegistryName(location("pork_sandwich")),


                    WNItems.BREAKFAST_MEAL = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(12).saturation(0.6F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("breakfast_meal")),
                    WNItems.BROCCOLI_AND_CHEESE = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(10).saturation(0.8F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("broccoli_and_cheese")),
                    WNItems.MUTTON_DINNER_WITH_REDWINE_SAUCE = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(16).saturation(0.7F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("mutton_dinner_with_redwine_sauce")),
                    WNItems.OMELET_BREAKFAST = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(11).saturation(0.5F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("omelet_breakfast")),
                    WNItems.PANCAKES = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(12).saturation(0.4F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("pancakes")),
                    WNItems.PIEROGIES = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(14).saturation(0.5F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("pierogies")),
                    WNItems.ROAST_CHICKEN_DINNER = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(14).saturation(0.5F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("roast_chicken_dinner")),
                    WNItems.ROASTED_VEGGIES = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(8).saturation(0.6F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("roasted_veggies")),
                    WNItems.SAUTEED_VEGGIES_WITH_GRAVY = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(12).saturation(0.8F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("sauteed_veggies_with_gravy")),
                    WNItems.STEAK_DINNER_WITH_GRAVY = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(15).saturation(0.8F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("steak_dinner_with_gravy")),
                    WNItems.STEAK_DINNER_WITH_REDWINE_SAUCE = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(19).saturation(0.9F).build()).maxStackSize(1),FillTool.PLATE).setRegistryName(location("steak_dinner_with_redwine_sauce")),




                    //OTHER
                    WNItems.LEMON_MERINGUE_PIE = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(10).saturation(0.4F).build())).setRegistryName(location("lemon_meringue_pie")),
                    WNItems.STRAWBERRY_RHUBARB_PIE = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food((new Food.Builder()).hunger(10).saturation(0.4F).build())).setRegistryName(location("strawberry_rhubarb_pie")),
                    WNItems.BREAD_ROLL = new FoodItem(new Item.Properties().group(ItemGroup.FOOD).food(Foods.BREAD)).setRegistryName(location("bread_roll")),

                    WNItems.CANDY_1 = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CANDY)).setRegistryName(location("candy_1")),
                    WNItems.CANDY_2 = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CANDY)).setRegistryName(location("candy_2")),
                    WNItems.CANDY_3 = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CANDY)).setRegistryName(location("candy_3")),
                    WNItems.CANDY_CANE_1 = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CANDY_CANE)).setRegistryName(location("candy_cane_1")),
                    WNItems.CANDY_CANE_2 = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CANDY_CANE)).setRegistryName(location("candy_cane_2")),
                    WNItems.CARAMEL_CANDY = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.BREAD)).setRegistryName(location("caramel_candy")),
                    WNItems.CREAM_CARAMEL = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.BREAD)).setRegistryName(location("cream_caramel")),
                    //ItemsList.DONUT = new Item(new Item.Properties().group(ItemGroup.FOOD).food(DONUTS)).setRegistryName(location("donut")),
                    //ItemsList.DONUT_2 = new Item(new Item.Properties().group(ItemGroup.FOOD).food(DONUTS)).setRegistryName(location("donut_2")),
                    WNItems.EMPTY_BAG = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("empty_bag")),

                    //ItemsList.GINGERBREAD_1 = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.BREAD)).setRegistryName(location("gingerbread_1")),
                    //ItemsList.GINGERBREAD_2 = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.BREAD)).setRegistryName(location("gingerbread_2")),
                    WNItems.MARSHMALLOW = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.BREAD)).setRegistryName(location("marshmallow")),
                    WNItems.CHOCOLATE_DARK = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CHOCOLATE)).setRegistryName(location("chocolate_dark")),
                    WNItems.CHOCOLATE_MILK = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CHOCOLATE)).setRegistryName(location("chocolate_milk")),
                    WNItems.CHOCOLATE_WHITE = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CHOCOLATE)).setRegistryName(location("chocolate_white")),
                    WNItems.CHOCOLATE_CARAMEL = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CHOCOLATE)).setRegistryName(location("chocolate_caramel")),

                    WNItems.CARAMEL = new Item(new Item.Properties().group(ItemGroup.FOOD).food(CANDY)).setRegistryName(location("caramel")),

                    WNItems.FLOUR = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("flour")),
                    WNItems.POPPY_SEED = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("poppy_seed")),
                    WNItems.RICE_BAG = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("rice_bag")),
                    WNItems.YEAST = new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName(location("yeast")),


                    WNItems.GIFT_1 = new GiftItem(new Item.Properties().group(ItemGroup.DECORATIONS), GiftItem.GiftColor.CYAN_RED).setRegistryName(location("gift_1")),
                    WNItems.GIFT_2 = new GiftItem(new Item.Properties().group(ItemGroup.DECORATIONS), GiftItem.GiftColor.RED_YELLOW).setRegistryName(location("gift_2")),
                    WNItems.GIFT_3 = new GiftItem(new Item.Properties().group(ItemGroup.DECORATIONS), GiftItem.GiftColor.BLUE_PINK).setRegistryName(location("gift_3")),
                    WNItems.XMAS_PAPER_1 = new WrappingPaperItem(new Item.Properties().group(ItemGroup.DECORATIONS), GiftItem.GiftColor.CYAN_RED).setRegistryName(location("xmas_paper_1")),
                    WNItems.XMAS_PAPER_2 = new WrappingPaperItem(new Item.Properties().group(ItemGroup.DECORATIONS), GiftItem.GiftColor.RED_YELLOW).setRegistryName(location("xmas_paper_2")),
                    WNItems.XMAS_PAPER_3 = new WrappingPaperItem(new Item.Properties().group(ItemGroup.DECORATIONS), GiftItem.GiftColor.BLUE_PINK).setRegistryName(location("xmas_paper_3")),
                    WNItems.XMAS_SOCK = new Item(new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(location("xmas_sock")),

                    WNItems.POUCH = new PouchItem(new Item.Properties().group(WILDNATURE_GROUP).maxStackSize(1)).setRegistryName(location("pouch")),

                    //DRINKS
                    WNItems.BEER = new AlcoItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:wooden_mug")).setRegistryName(location("beer")),
                    WNItems.RED_WINE = new AlcoItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:wine_bottle")).setRegistryName(location("red_wine")),
                    WNItems.WHITE_WINE = new AlcoItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:wine_bottle")).setRegistryName(location("white_wine")),

                    WNItems.COMPOT_APPLE_PEAR = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_apple_pear")),
                    WNItems.COMPOT_APPLE_RASPBERRY_CURRANT = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_apple_raspberry_currant")),
                    WNItems.COMPOT_BLACK_CURRANT = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_black_currant")),
                    WNItems.COMPOT_BLACKBERRY_GOOSEBERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_blackberry_gooseberry")),
                    WNItems.COMPOT_CHERRY_BLUEBERRY_RASPBERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_cherry_blueberry_raspberry")),
                    WNItems.COMPOT_CHOKEBERRY_BLACKBERRY_LINGONBERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_chokeberry_blackberry_lingonberry")),
                    WNItems.COMPOT_CRANBERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_cranberry")),
                    WNItems.COMPOT_PLUM_APPLE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_plum_apple")),
                    WNItems.COMPOT_WHITE_CURRANT = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:jug")).setRegistryName(location("compot_white_currant")),

                    WNItems.JUICE_APPLE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_apple")),
                    WNItems.JUICE_GRAPE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_grape")),
                    WNItems.JUICE_GRAPEFRUIT = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_grapefruit")),
                    WNItems.JUICE_LEMON = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_lemon")),
                    WNItems.JUICE_MANGO_PINEAPPLE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_mango_pineapple")),
                    WNItems.JUICE_ORANGE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_orange")),
                    WNItems.JUICE_PEACH = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_peach")),
                    WNItems.JUICE_PINEAPPLE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("juice_pineapple")),
                    WNItems.LEMONADE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass_cup")).setRegistryName(location("lemonade")),

                    WNItems.TEA_BLACK = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_black")),
                    WNItems.TEA_BLACK_LEMON = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_black_lemon")),
                    WNItems.TEA_GREEN = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_green")),
                    WNItems.TEA_GREEN_CHERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_green_cherry")),
                    WNItems.TEA_GREEN_QUINCE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_green_quince")),
                    WNItems.TEA_MELISSA_PEACH = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_melissa_peach")),
                    WNItems.TEA_MINT = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_mint")),
                    WNItems.TEA_MINT_LEMON = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_mint_lemon")),
                    WNItems.TEA_WHITE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_white")),
                    WNItems.TEA_WHITE_ORANGE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).food(DRINK).maxStackSize(1),("wildnature:glass")).setRegistryName(location("tea_white_orange")),


                    WNItems.JAM_BLACKBERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_blackberry")),
                    WNItems.JAM_BLUEBERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_blueberry")),
                    WNItems.JAM_CHOKE_BERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_choke_berry")),
                    WNItems.JAM_GOOSEBERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_gooseberry")),
                    WNItems.JAM_HAWTHORN_BERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_hawthorn_berry")),
                    WNItems.JAM_KAMCHATKA_BERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_kamchatka_berry")),
                    WNItems.JAM_ORANGE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_orange")),
                    WNItems.JAM_PEACH = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_peach")),
                    WNItems.JAM_QUINCE = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_quince")),
                    WNItems.JAM_RASPBERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_raspberry")),
                    WNItems.JAM_WILD_STRAWBERRY = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("jam_wild_strawberry")),



                    WNItems.MAPLE_SYRUP = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jug"),true).setRegistryName(location("maple_syrup")),
                    WNItems.PEANUT_BUTTER = new DrinkItem(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1),("wildnature:jar")).setRegistryName(location("peanut_butter")),

                    WNItems.CHISEL = new Item(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1)).setRegistryName(location("chisel"))

            );
            GemRegistry gems = new GemRegistry();
            event.getRegistry().registerAll(gems.getItem());


            event.getRegistry().registerAll(
                    WNItems.DUNGEON_TORCH = new WallOrFloorItem(getBlockByID("wildnature:dungeon_torch"), getBlockByID("wildnature:dungeon_torch_wall"), (new Item.Properties()).group(WILDNATURE_DECO_GROUP)).setRegistryName("wildnature:dungeon_torch"),
                    WNItems.CRYSTAL_TORCH = new WallOrFloorItem(getBlockByID("wildnature:crystal_torch"), getBlockByID("wildnature:crystal_torch_wall"), (new Item.Properties()).group(WILDNATURE_DECO_GROUP)).setRegistryName("wildnature:crystal_torch"),
                    WNItems.DUNGEON_REDSTONE_TORCH = new WallOrFloorItem(getBlockByID("wildnature:dungeon_redstone_torch"), getBlockByID("wildnature:dungeon_redstone_torch_wall"), (new Item.Properties()).group(ItemGroup.REDSTONE)).setRegistryName("wildnature:dungeon_redstone_torch"),
                    WNItems.RS_PISTON1 = new BlockNamedItem(Main.getBlockByID("wildnature:rs_piston1"),new Item.Properties().group(ItemGroup.REDSTONE)).setRegistryName(location("rs_piston1")),
                    WNItems.GEYSER_ESSENCE = new GeyserEssenceItem(new Item.Properties().group(WILDNATURE_GROUP)).setRegistryName(location("geyser_essence")),
                    WNItems.JELLY_BALL_BLUE = new Item(new Item.Properties().group(WILDNATURE_GROUP).maxStackSize(16)).setRegistryName(location("jelly_ball_blue")),
                    WNItems.JELLY_BALL_ORANGE = new Item(new Item.Properties().group(WILDNATURE_GROUP).maxStackSize(16)).setRegistryName(location("jelly_ball_orange")),
                    WNItems.JELLY_BALL_PINK = new Item(new Item.Properties().group(WILDNATURE_GROUP).maxStackSize(16)).setRegistryName(location("jelly_ball_pink")),
                    WNItems.JELLY_BALL_RED = new Item(new Item.Properties().group(WILDNATURE_GROUP).maxStackSize(16)).setRegistryName(location("jelly_ball_red")),
                    WNItems.JELLY_BALL_WHITE = new Item(new Item.Properties().group(WILDNATURE_GROUP).maxStackSize(16)).setRegistryName(location("jelly_ball_white")),
                    WNItems.GLOWSHROOM_DUST = new Item(new Item.Properties().group(WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(location("glowshroom_dust")),
                    WNItems.ICESHROOM_DUST = new Item(new Item.Properties().group(WILDNATURE_UNDERGROUND_GROUP)).setRegistryName(location("iceshroom_dust"))


            );

            EntityRegistry.registerSpawningEggs(event);


        }



        @SubscribeEvent
        public static void registerRecipeSerializers(final RegistryEvent.Register<IRecipeSerializer<?>> event){
            LOGGER.info("Registering recipe serializers...");
            event.getRegistry().register(new SpecialRecipeSerializer<>(GiftCrafting::new).setRegistryName("wildnature:gift_crafting"));
            event.getRegistry().register(new SpecialRecipeSerializer<>(DyeableRecipe::new).setRegistryName("wildnature:dyeable_recipe"));
            event.getRegistry().register(new SpecialRecipeSerializer<>(PotCrafting::new).setRegistryName("wildnature:pot_crafting"));
            event.getRegistry().register(new SpecialRecipeSerializer<>(KnifeCrafting::new).setRegistryName("wildnature:knife_chopping"));

            //CUSTOM
            event.getRegistry().register(new WNCookingRecipeSerializer<>(WNCookingRecipe::new,200).setRegistryName("wildnature:cooking"));
            event.getRegistry().register(new SpecialRecipeSerializer<>(WNCookingSmelting::new).setRegistryName("wildnature:furnace_cooking"));
            event.getRegistry().register(new SpecialRecipeSerializer<>(WNCookingSmelting::new).setRegistryName("wildnature:smoker_cooking"));

        }


        @SubscribeEvent
        public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){
            LOGGER.info("Registering entities...");



            event.getRegistry().registerAll(
                    EntityRegistry.SEAT,EntityRegistry.GOBLIN,EntityRegistry.DRAKE,EntityRegistry.DUCK,EntityRegistry.DUCKLING,EntityRegistry.BOAR,EntityRegistry.PIRANHA,EntityRegistry.DRAGONFLY,EntityRegistry.SPARROW_MALE,EntityRegistry.BUCK,EntityRegistry.DOE,EntityRegistry.FAWN
            );

        }

        @SubscribeEvent
        public static void registerFeatures(final RegistryEvent.Register<Feature<?>> event){
            LOGGER.info("Registering features...");
            FeatureRegistry.registerAll(event);
        }

        @SubscribeEvent
        public static void registerSurfaceBuilders(final RegistryEvent.Register<SurfaceBuilder<?>> event){
            LOGGER.info("Registering surface builders...");
            SurfaceRegistry.registerAll(event);
        }

        @SubscribeEvent
        public static void registerCarvers(final RegistryEvent.Register<WorldCarver<?>> event){
            LOGGER.info("Registering carvers...");
            CarverRegistry.registerAll(event);
        }



        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event){
            LOGGER.info("Registering blocks...");
            blockEvent=event;


            WoodRegistry woodRegistry = new WoodRegistry();
            FlowerRegistry flowerRegistry = new FlowerRegistry();
            SaplingRegistry saplingRegistry = new SaplingRegistry();


            BuildingRegistry rockAddonRegistry = new BuildingRegistry();
            BuildingAddonsRegistry buildingAddonRegistry = new BuildingAddonsRegistry();
            EngravedRegistry engravedRegistry = new EngravedRegistry();
            SignRegistry signRegistry = new SignRegistry();
            GrassRegistry grassRegistry = new GrassRegistry();
            OtherRegistry otherRegistry = new OtherRegistry();
            OreRegistry oreRegistry = new OreRegistry();


            event.getRegistry().registerAll(
                    woodRegistry.getWoods()

            );
            event.getRegistry().registerAll(
                    signRegistry.getSign()

            );
            event.getRegistry().registerAll(
                    saplingRegistry.getSaplings()

            );
            event.getRegistry().registerAll(
                    rockRegistry.getRocks()

            );
            event.getRegistry().registerAll(
                    oreRegistry.getOres()

            );
            event.getRegistry().registerAll(
                    rockAddonRegistry.getRocks()

            );
            event.getRegistry().registerAll(
                    buildingAddonRegistry.getBlock()

            );
            event.getRegistry().registerAll(
                    engravedRegistry.getEngraved()

            );
            event.getRegistry().registerAll(
                    flowerRegistry.getFlowers()
            );
            event.getRegistry().registerAll(
                    grassRegistry.getGrass()
            );
            event.getRegistry().registerAll(
                    otherRegistry.getBlock()
            );

        }


        @SubscribeEvent
        public static void registerBiomes(final RegistryEvent.Register<Biome> event){
            LOGGER.info("Registering biomes...");

            event.getRegistry().registerAll(
                    com.matez.wildnature.world.gen.biomes.setup.WNBiomes.River,
                    com.matez.wildnature.world.gen.biomes.setup.WNBiomes.FrozenRiver,
                    com.matez.wildnature.world.gen.biomes.setup.WNBiomes.AmazonRiver,
                    com.matez.wildnature.world.gen.biomes.setup.WNBiomes.NileRiver,
                    WNBiomes.CanyonRiver, WNBiomes.IcelandRiver, WNBiomes.DaintreeRiver, WNBiomes.TatraStream

            );



            int x = 0;
            while(x< WNBiomes.registerBiomes.size()){
                Biome b = WNBiomes.registerBiomes.get(x);
                event.getRegistry().register(b);
                x++;
            }

            com.matez.wildnature.world.gen.biomes.setup.WNBiomes.registerBiomes();

            //WNBiomeManager.removeAllBiomes("minecraft:");



        }

        @SubscribeEvent
        public static void registerParticles(final RegistryEvent.Register<ParticleType<?>> event){
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
            initGuis.PISTON_TYPE=piston_type;

            TileEntityType<DungeonCommanderTileEntity> dungeonCommander = TileEntityType.Builder.create(DungeonCommanderTileEntity::new, WNBlocks.DUNGEON_COMMANDER).build(null);
            dungeonCommander.setRegistryName("wildnature", "dungeon_commander");
            evt.getRegistry().register(dungeonCommander);
            initGuis.DUNGEON_COMMANDER=dungeonCommander;

            TileEntityType<HydrothermalVentTileEntity> hydrothermalVent = TileEntityType.Builder.create(HydrothermalVentTileEntity::new, WNBlocks.HYDROTHERMAL_VENT).build(null);
            hydrothermalVent.setRegistryName("wildnature", "hydrothermal_vent");
            evt.getRegistry().register(hydrothermalVent);
            initGuis.HYDROTHERMAL_VENT_TILE_ENTITY=hydrothermalVent;

            TileEntityType<GravityShroomTileEntity> gravityShroom = TileEntityType.Builder.create(GravityShroomTileEntity::new, WNBlocks.GRAVITYSHROOM).build(null);
            gravityShroom.setRegistryName("wildnature", "gravityshroom");
            evt.getRegistry().register(gravityShroom);
            initGuis.GRAVITY_SHROOM_TILE_ENTITY=gravityShroom;
        }

        private static final List<ContainerType<?>> CONTAINER_TYPES = new ArrayList<>();


        @SubscribeEvent
        public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {
            LOGGER.info("Registering containers...");
            registerContainer("wildnature:pouch",PouchContainer::new);

            CONTAINER_TYPES.forEach(container_type -> event.getRegistry().register(container_type));

        }

        private static <T extends Container> void registerContainer(String name, IContainerFactory<T> container)
        {
            ContainerType<T> type = IForgeContainerType.create(container);
            type.setRegistryName(name);
            CONTAINER_TYPES.add(type);
        }


        @SubscribeEvent
        public static void registerSounds(final RegistryEvent.Register<SoundEvent> event){
            LOGGER.info("Registering sounds...");
            //event.getRegistry().register(new SoundEvent(new ResourceLocation("wildnature","block/piston/2s_open")));
            event.getRegistry().registerAll(SoundRegistry.register());


        }



        public static ResourceLocation location(String name){
            return new ResourceLocation(modid,name);
        }

    }

    public static Block getBlockByID(String resLoc){
        return Registry.BLOCK.getOrDefault(new ResourceLocation(resLoc));
    }

    public static Item getItemByID(String resLoc){
        return Registry.ITEM.getOrDefault(new ResourceLocation(resLoc));
    }

    public static Biome getBiomeByID(String resLoc){
        return Registry.BIOME.getOrDefault(new ResourceLocation(resLoc));
    }
    public static ParticleType getParticleByID(String resLoc){
        return Registry.PARTICLE_TYPE.getOrDefault(new ResourceLocation(resLoc));
    }
    public static SoundEvent getSoundByID(String resLoc){
        return Registry.SOUND_EVENT.getOrDefault(new ResourceLocation(resLoc));
    }

    public static String yesNoReturner(boolean bool){
        return bool ? "y" : "n";
    }

    public static void sendServerChatMessage(MinecraftServer server, PlayerEntity playerEntity, String message){
        if(hasEffect(playerEntity,Effects.INVISIBILITY)){
            Main.LOGGER.debug("---> Player is invisible, message won't be send");
            return;
        }
        if(server!=null) {
            server.sendMessage(new StringTextComponent(message));
            for (PlayerEntity p : server.getPlayerList().getPlayers()) {
                if(p!=playerEntity){
                    sendChatMessage(p, message);
                }
            }
        }else{
            Main.LOGGER.debug("---> Cannot send message. Server == null");
        }
    }
    public static void sendServerChatMessage(MinecraftServer server, PlayerEntity playerEntity, ITextComponent message){
        Main.LOGGER.debug("Sending Message to server");
        if(hasEffect(playerEntity,Effects.INVISIBILITY)){
            Main.LOGGER.debug("---> Player is invisible, message won't be send");
            return;
        }
        if(server!=null) {
            server.sendMessage(message);
            for (PlayerEntity p : server.getPlayerList().getPlayers()) {
                if(p!=playerEntity){
                    sendChatMessage(p, message);
                }

            }
        }else{
            Main.LOGGER.debug("---> Cannot send message. Server == null");
        }
    }
    public static void sendChatMessage(PlayerEntity entity, String message){
        entity.sendMessage(new StringTextComponent(message));
    }
    public static void sendChatMessage(PlayerEntity entity, ITextComponent message){
        entity.sendMessage((message));
    }

    public static boolean hasEffect(LivingEntity entity, Effect effect){
        ArrayList<Object> effects = new ArrayList<>(Arrays.asList(entity.getActivePotionEffects().toArray()));
        for(Object e : effects){
            if(e instanceof EffectInstance) {
                if (((EffectInstance)e).getPotion() == effect) {
                    return true;
                }
            }
        }
        return false;
    }


    public static String readFromURL(String sURL){
        if(!netIsAvailable()){
            LOGGER.warn("Internet connection unavailable");
            return null;
        }

        try{
            URL url = new URL(sURL);
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = in.readLine();
            StringBuilder builder = new StringBuilder();
            do {
                builder.append(line+"\n");
            } while ( (line = in.readLine()) != null);
            in.close();
            return builder.toString();
        }catch (Exception e){
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
        if(netIsAvailable()) {
            try {
                URL u = new URL(url);
                HttpURLConnection huc = (HttpURLConnection) u.openConnection();
                huc.setRequestMethod("GET");  //OR  huc.setRequestMethod ("HEAD");
                huc.connect();
                int code = huc.getResponseCode();
                LOGGER.debug("Response code: " + code);
                return code==404;
            } catch (Exception e) {
                LOGGER.warn("Exception during 404 test: " + e.getLocalizedMessage());
            }
        }else{
            LOGGER.debug("Internet not available");
        }
        return true;
    }


    public static void wnInfo(String data){
        LOGGER.info(TextFormatting.AQUA+"---------------------------------");
        LOGGER.info(TextFormatting.GREEN+" WildNature " + version + " // " + ForgeVersion.getVersion());
        LOGGER.info(TextFormatting.GREEN+" https://wildnaturemod.com");
        LOGGER.info(TextFormatting.DARK_AQUA+"---");
        LOGGER.info(TextFormatting.YELLOW+data);
        LOGGER.info(TextFormatting.DARK_AQUA+"---");
        LOGGER.info(TextFormatting.AQUA+"---------------------------------");

    }

    public static void fixResources(){
        ArrayList<ClientResourcePackInfo> enabledPacks = new ArrayList<>(Minecraft.getInstance().getResourcePackList().getEnabledPacks());
        ArrayList<ClientResourcePackInfo> orderedPacks = enabledPacks;

        int vanillaIndex = 0;
        int modResIndex =0;
        for(int i = 0; i < enabledPacks.size(); i++){
            if (enabledPacks.get(i).getName().equals("vanilla")) {
                vanillaIndex=i;
                orderedPacks.set(0,enabledPacks.get(i));
            }
            else if (enabledPacks.get(i).getName().equals("mod_resources")) {
                modResIndex=i;
                orderedPacks.set(1,enabledPacks.get(i));
            }else{
                orderedPacks.set(i,enabledPacks.get(i));
            }
        }
        Minecraft.getInstance().getResourcePackList().setEnabledPacks(orderedPacks);
    }

    /*public static boolean getEntitySpawnPlacementPredicate(EntityType<?> entity, IWorld world, SpawnReason reason, BlockPos pos, Random random) {
        return entrySpawnType.placementType== EntitySpawnPlacementRegistry.PlacementType.ON_GROUND ? onGroundEntity(entity,world,reason,pos,random) : (entrySpawnType.field_223513_c.test((EntityType)entity,world,reason,pos,random) ? entrySpawnType.field_223513_c.test((EntityType)entity,world,reason,pos,random) : onGroundEntity(entity,world,reason,pos,random));
    }

    private static boolean onGroundEntity(EntityType<?> entity, IWorld world, SpawnReason reason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).getBlock() instanceof GrassBlock && world.getLightSubtracted(pos, 0) > 8;
    }*/
}
