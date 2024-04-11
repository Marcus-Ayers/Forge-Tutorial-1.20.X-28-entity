package net.kaupenjoe.tutorialmod.entity.client;

import net.kaupenjoe.tutorialmod.entity.custom.ChickenEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

//is chicken
@OnlyIn(Dist.CLIENT)
public class ChickenRenderer extends MobRenderer<ChickenEntity, ChickenModel<ChickenEntity>> {
    private static final ResourceLocation CHICKEN_LOCATION = new ResourceLocation("textures/entity/chicken.png");

    public ChickenRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ChickenModel<>(pContext.bakeLayer(ModModelLayers.CHICKEN_LAYER)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(ChickenEntity pEntity) {
        return CHICKEN_LOCATION;
    }


    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float getBob(Chicken pLivingBase, float pPartialTicks) {
        float f = Mth.lerp(pPartialTicks, pLivingBase.oFlap, pLivingBase.flap);
        float f1 = Mth.lerp(pPartialTicks, pLivingBase.oFlapSpeed, pLivingBase.flapSpeed);
        return (Mth.sin(f) + 1.0F) * f1;
    }

}
