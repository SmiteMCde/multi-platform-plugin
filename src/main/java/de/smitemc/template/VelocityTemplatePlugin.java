package de.smitemc.template;

import com.velocitypowered.api.command.CommandManager;
import com.velocitypowered.api.event.EventManager;
import de.smitemc.template.bootstrap.VelocityBootstrap;
import de.smitemc.template.internal.velocity.commands.TemplateVelocityCommand;
import de.smitemc.template.internal.velocity.listeners.LoginListener;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class VelocityTemplatePlugin extends TemplatePlugin {

    private final VelocityBootstrap bootstrap;

    public VelocityTemplatePlugin(@NotNull VelocityBootstrap bootstrap) {
        super(bootstrap.getDataDirectory());
        this.bootstrap = bootstrap;
    }

    @Override
    public void register() {
        final CommandManager commandManager = this.getBootstrap().getProxyServer().getCommandManager();
        commandManager.register(commandManager.metaBuilder("templatevelocity").build(), new TemplateVelocityCommand());

        final EventManager eventManager = this.getBootstrap().getProxyServer().getEventManager();
        eventManager.register(this.getBootstrap(), new LoginListener());

        this.getLogger().info("Registering velocity template plugin");
    }

    @Override
    public void shutdown() {
        this.getLogger().info("Shutting down velocity template plugin");
    }

}
