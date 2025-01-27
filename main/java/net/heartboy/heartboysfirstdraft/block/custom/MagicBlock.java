package net.heartboy.heartboysfirstdraft.block.custom;

import net.heartboy.heartboysfirstdraft.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nonnull;
import java.util.List;

public class MagicBlock extends Block {

    public MagicBlock(Properties properties) {super(properties);}

    @Override
    protected @Nonnull InteractionResult useWithoutItem(@Nonnull BlockState state, Level level, @Nonnull BlockPos pos,
                                                        @Nonnull Player player, @Nonnull BlockHitResult hitResult) {
level.playSound(player,pos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(@Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull Entity entity) {
        if(entity instanceof ItemEntity itemEntity){
            if(isValidItem(itemEntity.getItem())){
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
            }
        }
        if(entity instanceof ItemEntity itemEntity){
            if(itemEntity.getItem().getItem() == Items.DANDELION){
                itemEntity.setItem(new ItemStack(Items.WITHER_ROSE, itemEntity.getItem().getCount()));
            }
        }
        super.stepOn(level, pos, state, entity);
    }

    private boolean isValidItem(ItemStack item) {
        return item.is(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nonnull Item.TooltipContext context, @Nonnull List<Component> tooltipComponents, @Nonnull TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.heartboysfirstdraft.magic_block"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
