package cn.mcmod.tea_sorcerer.client.particle;

import cn.mcmod_mmf.mmlib.client.particle.TrailParticle;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TrailParticleLeaf extends TrailParticle {

    public TrailParticleLeaf(ClientWorld p_i232351_1_, double p_i232351_2_, double p_i232351_4_, double p_i232351_6_,
            double p_i232351_8_, double p_i232351_10_, double p_i232351_12_) {
        super(p_i232351_1_, p_i232351_2_, p_i232351_4_, p_i232351_6_, p_i232351_8_, p_i232351_10_, p_i232351_12_);

    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite sprite;

        public Factory(IAnimatedSprite p_i50227_1_) {
            this.sprite = p_i50227_1_;
        }

        public Particle createParticle(BasicParticleType p_199234_1_, ClientWorld p_199234_2_, double p_199234_3_,
                double p_199234_5_, double p_199234_7_, double p_199234_9_, double p_199234_11_, double p_199234_13_) {
            TrailParticleLeaf particle = new TrailParticleLeaf(p_199234_2_, p_199234_3_, p_199234_5_, p_199234_7_,
                    p_199234_9_, p_199234_11_, p_199234_13_);
            particle.pickSprite(this.sprite);
            return particle;
        }
    }
}
