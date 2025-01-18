package net.heartboy.heartboysfirstdraft.items;

import net.heartboy.heartboysfirstdraft.main.FirstDraft;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FirstDraft.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.registerSimpleItem("bismuth",
            new Item.Properties());

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}