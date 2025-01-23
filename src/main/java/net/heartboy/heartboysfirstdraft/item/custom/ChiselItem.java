package net.heartboy.heartboysfirstdraft.item.custom;

import net.heartboy.heartboysfirstdraft.block.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ChiselItem extends Item{
    public ChiselItem(Properties properties){
        super (properties);
    }

    private static final Map<Block,Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.STONE_STAIRS, Blocks.STONE_BRICK_STAIRS,
                    Blocks.STONE_SLAB, Blocks.STONE_BRICK_SLAB,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.DEEPSLATE_BRICKS, Blocks.DEEPSLATE_TILES,
                    Blocks.DEEPSLATE_BRICK_STAIRS, Blocks.DEEPSLATE_TILE_STAIRS,
                    Blocks.DEEPSLATE_BRICK_SLAB, Blocks.DEEPSLATE_TILE_SLAB,
                    Blocks.DEEPSLATE_EMERALD_ORE, ModBlocks.BISMUTH_BLOCK.get()
            );

    public @NotNull InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).withPropertiesOf(level.getBlockState(context.getClickedPos())));

                context.getItemInHand().hurtAndBreak(1,((ServerLevel) level),context.getPlayer(),
                        item -> Objects.requireNonNull(context.getPlayer()).onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nonnull Item.TooltipContext context, @Nonnull List<Component> tooltipComponents, @Nonnull TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.heartboysfirstdraft.chisel.shift"));
        }else{
            tooltipComponents.add(Component.translatable("tooltip.heartboysfirstdraft.chisel"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
