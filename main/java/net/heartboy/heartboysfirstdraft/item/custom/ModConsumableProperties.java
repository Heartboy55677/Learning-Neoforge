package net.heartboy.heartboysfirstdraft.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import static net.minecraft.world.item.component.Consumables.defaultFood;

public class ModConsumableProperties {
    public static final Consumable RADISH = defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(
            new MobEffectInstance(MobEffects.HEALTH_BOOST,400),.35f)).build();
}
