package de.smitemc.template.internal.minestom.listeners;

import de.smitemc.template.TemplatePlugin;
import net.minestom.server.entity.Player;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.player.PlayerSpawnEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerSpawnListener implements EventListener<PlayerSpawnEvent> {

    @Override
    public @NotNull Class<PlayerSpawnEvent> eventType() {
        return PlayerSpawnEvent.class;
    }

    @Override
    public @NotNull Result run(@NotNull PlayerSpawnEvent event) {
        final Player player = event.getPlayer();
        player.sendMessage(TemplatePlugin.getInstance().getMiniMessage().deserialize("<yellow>This is a multi-platform plugin template! <gray>(Minestom)"));

        return Result.SUCCESS;
    }

}
