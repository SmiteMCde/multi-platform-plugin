package de.smitemc.template;

import de.smitemc.template.internal.minestom.commands.TemplateMinestomCommand;
import de.smitemc.template.internal.minestom.listeners.PlayerSpawnListener;
import lombok.Getter;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.event.GlobalEventHandler;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

@Getter
public class MinestomTemplatePlugin extends TemplatePlugin {

    public MinestomTemplatePlugin(@NotNull Path dataDirectory) {
        super(dataDirectory);
    }

    @Override
    public void register() {
        final CommandManager commandManager = MinecraftServer.getCommandManager();
        commandManager.register(new TemplateMinestomCommand());

        final GlobalEventHandler eventHandler = MinecraftServer.getGlobalEventHandler();
        eventHandler.addListener(new PlayerSpawnListener());

        this.getLogger().info("Registering minestom template plugin");
    }

    @Override
    public void shutdown() {
        this.getLogger().info("Shutting down minestom template plugin");
    }

}
