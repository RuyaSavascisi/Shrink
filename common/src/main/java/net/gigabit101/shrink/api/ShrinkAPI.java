package net.gigabit101.shrink.api;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;

public class ShrinkAPI
{
    public static final Attribute SCALE_ATTRIBUTE = new RangedAttribute("shrink_scale", 1.0D, 0.25D, 10).setSyncable(true);

    public static boolean canEntityShrink(LivingEntity livingEntity)
    {
        if(livingEntity == null) return false;
        if(livingEntity.getAttributes() == null) return false;
        if(livingEntity.getAttribute(SCALE_ATTRIBUTE) == null) return false;

        return livingEntity.getAttribute(ShrinkAPI.SCALE_ATTRIBUTE).getValue() != 1.0D;
    }

    public static boolean isEntityShrunk(LivingEntity livingEntity)
    {
        if(livingEntity == null) return false;
        if(livingEntity.getAttributes() == null) return false;
        if(livingEntity.getAttribute(SCALE_ATTRIBUTE) == null) return false;

        return !livingEntity.getAttribute(ShrinkAPI.SCALE_ATTRIBUTE).getModifiers().isEmpty();
    }
}