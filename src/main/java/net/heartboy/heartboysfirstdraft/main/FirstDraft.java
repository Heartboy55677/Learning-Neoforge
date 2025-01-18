package net.heartboy.heartboysfirstdraft.main;

import net.heartboy.heartboysfirstdraft.items.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.resources.ResourceLocation;
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

import java.util.Collections;

import static net.heartboy.heartboysfirstdraft.items.ModItems.BISMUTH;

@Mod(FirstDraft.MOD_ID)
public class FirstDraft
{
    public static final String MOD_ID = "heartboysfirstdraft";
    private static final Logger LOGGER = LogUtils.getLogger();
    public FirstDraft(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        ModItems.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void commonSetup(final FMLCommonSetupEvent event){

    }
    private void addCreative(BuildCreativeModeTabContentsEvent event){
    if(event.getTabKey()==CreativeModeTabs.INGREDIENTS)
        event.accept(BISMUTH);
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
