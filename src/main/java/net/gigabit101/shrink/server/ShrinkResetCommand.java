package net.gigabit101.shrink.server;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.gigabit101.shrink.api.ShrinkAPI;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class ShrinkResetCommand
{
    public static LiteralArgumentBuilder<CommandSourceStack> register()
    {
        return Commands.literal("unshrink").requires((cs) -> cs.hasPermission(4))
                .then(Commands.argument("player", EntityArgument.player())
                .executes((ctx) -> execute((CommandSource) ctx.getSource(), EntityArgument.getPlayer(ctx, "player"))));
    }

    public static int execute(CommandSource source, Player playerEntity)
    {
        playerEntity.getCapability(ShrinkAPI.SHRINK_CAPABILITY).ifPresent(iShrinkProvider ->
        {
            iShrinkProvider.deShrink(playerEntity);
            source.m_213846_(Component.m_237115_("reset " + playerEntity.getName().getString() + " to default"));
        });
        return 0;
    }
}
