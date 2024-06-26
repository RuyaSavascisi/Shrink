package net.gigabit101.shrink;

import net.gigabit101.shrink.init.ModScreens;

public class ShrinkClient
{
    public static void init()
    {
        ModScreens.init();
//        LivingEntityRenderEvents.PRE.register((livingEntity, partialTick, poseStack, multiBufferSource, packedLight) -> ShrinkRender.onEntityRenderPre(livingEntity, poseStack));

//        LivingEntityRenderEvents.POST.register((livingEntity, partialTick, poseStack, multiBufferSource, packedLight) -> ShrinkRender.onEntityRenderPost(livingEntity, poseStack));
    }
}
