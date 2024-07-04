package net.gigabit101.shrink.init;

import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.gigabit101.shrink.Shrink;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;

public class ShrinkComponentTypes
{
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.create(Shrink.MOD_ID, Registries.DATA_COMPONENT_TYPE);

    public static final RegistrySupplier<DataComponentType<Double>> SHRINKING_DEVICE = COMPONENTS.register("scale", () -> DataComponentType.<Double>builder().
            persistent(Codec.DOUBLE.orElse(0D)).networkSynchronized(ByteBufCodecs.DOUBLE).build());

    public static final RegistrySupplier<DataComponentType<String>> ENTITY = COMPONENTS.register("entity", () -> DataComponentType.<String>builder().
            persistent(Codec.STRING.orElse("")).networkSynchronized(ByteBufCodecs.STRING_UTF8).build());

}
