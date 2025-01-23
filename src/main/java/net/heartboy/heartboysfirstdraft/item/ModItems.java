package net.heartboy.heartboysfirstdraft.item;

import net.heartboy.heartboysfirstdraft.item.custom.ChiselItem;
import net.heartboy.heartboysfirstdraft.item.custom.ModConsumableProperties;
import net.heartboy.heartboysfirstdraft.item.custom.ModFoodProperties;
import net.heartboy.heartboysfirstdraft.item.custom.SpecialTextItem;
import net.heartboy.heartboysfirstdraft.main.FirstDraft;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FirstDraft.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.registerSimpleItem("bismuth",
            new Item.Properties());

    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.registerSimpleItem("raw_bismuth",
            new Item.Properties());

    public static final DeferredItem<Item> CHISEL = ITEMS.registerItem("chisel",
            ChiselItem::new,
            new Item.Properties().durability(32));

    public static final DeferredItem<Item> RADISH = ITEMS.registerItem("radish",
            SpecialTextItem::new,
            new Item.Properties().food(ModFoodProperties.RADISH, ModConsumableProperties.RADISH));

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.registerSimpleItem("frostfire_ice",
            new Item.Properties());

    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.registerSimpleItem("starlight_ashes",
            new Item.Properties());

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}