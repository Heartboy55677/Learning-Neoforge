package net.heartboy.heartboysfirstdraft.main;

import net.heartboy.heartboysfirstdraft.block.ModBlocks;
import net.heartboy.heartboysfirstdraft.item.ModCreativeModeTabs;
import net.heartboy.heartboysfirstdraft.item.ModItems;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import static net.heartboy.heartboysfirstdraft.item.ModItems.BISMUTH;
import static net.heartboy.heartboysfirstdraft.item.ModItems.RAW_BISMUTH;

@Mod(FirstDraft.MOD_ID)
public class FirstDraft
{
    public static final String MOD_ID = "heartboysfirstdraft";
    private static final Logger LOGGER = LogUtils.getLogger();
    public FirstDraft(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void commonSetup(final FMLCommonSetupEvent event){

    }
    private void addCreative(BuildCreativeModeTabContentsEvent event){
    if(event.getTabKey()==CreativeModeTabs.INGREDIENTS){
        event.accept(BISMUTH);
        event.accept(RAW_BISMUTH);
    }
    if(event.getTabKey()==CreativeModeTabs.BUILDING_BLOCKS)
        event.accept(ModBlocks.BISMUTH_BLOCK);
    if(event.getTabKey()==CreativeModeTabs.NATURAL_BLOCKS)
        event.accept(ModBlocks.BISMUTH_ORE);
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event){

    }
    @EventBusSubscriber(modid =  MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
        }
    }
}
