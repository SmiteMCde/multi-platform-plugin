package de.smitemc.template;

import de.smitemc.template.bootstrap.PaperBootstrap;
import de.smitemc.template.internal.paper.commands.TemplatePaperCommand;
import de.smitemc.template.internal.paper.listeners.PlayerJoinListener;
import lombok.Getter;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Getter
public class PaperTemplatePlugin extends TemplatePlugin {

    private final PaperBootstrap bootstrap;

    public PaperTemplatePlugin(@NotNull PaperBootstrap bootstrap) {
        super(bootstrap.getDataFolder().toPath());
        this.bootstrap = bootstrap;
    }

    @Override
    public void register() {
        final CommandMap commandMap = this.getBootstrap().getServer().getCommandMap();
        commandMap.registerAll(this.getBootstrap().getName(), List.of(
                new TemplatePaperCommand()
        ));

        final PluginManager pluginManager = this.getBootstrap().getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(), this.getBootstrap());

        this.getLogger().info("Registering paper template plugin");
    }

    @Override
    public void shutdown() {
        this.getLogger().info("Shutting down paper template plugin");
    }

}
