package net.heartboy.heartboysfirstdraft.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SpecialTextItem extends Item {

    public SpecialTextItem(Properties properties) {super(properties);}

    private final String name= String.valueOf(this.getName()).substring(22, String.valueOf(this.getName()).length()-11);

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull Item.TooltipContext context, List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {

        tooltipComponents.add(Component.translatable("tooltip." + name));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
