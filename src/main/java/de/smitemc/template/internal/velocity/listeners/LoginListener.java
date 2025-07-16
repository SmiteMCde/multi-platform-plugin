package de.smitemc.template.internal.velocity.listeners;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.LoginEvent;
import com.velocitypowered.api.proxy.Player;
import de.smitemc.template.TemplatePlugin;

public class LoginListener {

    @Subscribe
    public void onLogin(LoginEvent event) {
        final Player player = event.getPlayer();
        player.sendMessage(TemplatePlugin.getInstance().getMiniMessage().deserialize("<yellow>This is a multi-platform plugin template! <gray>(Velocity)"));
    }

}
