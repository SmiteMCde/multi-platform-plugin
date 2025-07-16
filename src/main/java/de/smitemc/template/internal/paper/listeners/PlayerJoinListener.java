package de.smitemc.template.internal.paper.listeners;

import de.smitemc.template.TemplatePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        player.sendMessage(TemplatePlugin.getInstance().getMiniMessage().deserialize("<yellow>This is a multi-platform plugin template! <gray>(Paper)"));
    }

}
