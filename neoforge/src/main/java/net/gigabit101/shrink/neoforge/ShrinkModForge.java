package net.gigabit101.shrink.neoforge;

import net.gigabit101.shrink.Shrink;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Shrink.MOD_ID)
public class ShrinkModForge
{
    public ShrinkModForge(IEventBus bus)
    {
        Shrink.init();
    }
}
