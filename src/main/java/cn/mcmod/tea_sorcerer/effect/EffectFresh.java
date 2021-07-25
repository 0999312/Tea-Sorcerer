package cn.mcmod.tea_sorcerer.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;

public class EffectFresh extends Effect {

    protected EffectFresh() {
        super(EffectType.BENEFICIAL, 0xD7FFCC);
    }

    @Override
    public void applyEffectTick(LivingEntity entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.removeEffect(Effects.POISON);
        entityLivingBaseIn.removeEffect(Effects.WITHER);
        entityLivingBaseIn.removeEffect(Effects.CONFUSION);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return (duration & 1) == 0;
    }
}
