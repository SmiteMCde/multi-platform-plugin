package de.smitemc.template;

import lombok.Getter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

@Getter
public abstract class TemplatePlugin {

    @Getter
    private static TemplatePlugin instance;

    private final MiniMessage miniMessage = MiniMessage.miniMessage();
    private final Logger logger = LoggerFactory.getLogger(TemplatePlugin.class);

    /**
     * Constructor for the TemplatePlugin.
     * This constructor is used to create an instance of the plugin.
     *
     * @param dataDirectory The directory where the plugin's configuration data will be stored.
     */
    public TemplatePlugin(@NotNull Path dataDirectory) {
        if (instance != null) throw new IllegalStateException("TemplatePlugin instance already exists!");
        instance = this;

        this.logger.info("Initializing TemplatePlugin with data directory: {}", dataDirectory);
    }

    public abstract void register();

    public abstract void shutdown();

    /**
     * Returns the {@link MinestomTemplatePlugin} instance.
     *
     * @return the MinestomTemplatePlugin instance
     * @apiNote Only call this method if the plugin runs on a Minestom server.
     */
    public MinestomTemplatePlugin minestom() {
        if (!(instance instanceof MinestomTemplatePlugin minestomTemplatePlugin)) {
            throw new IllegalStateException("This plugin is not a MinestomTemplatePlugin!");
        }
        return minestomTemplatePlugin;
    }

    /**
     * Returns the {@link PaperTemplatePlugin} instance.
     *
     * @return the PaperTemplatePlugin instance
     * @apiNote Only call this method if the plugin runs on a Paper server.
     */
    public PaperTemplatePlugin paper() {
        if (!(instance instanceof PaperTemplatePlugin paperTemplatePlugin)) {
            throw new IllegalStateException("This plugin is not a PaperTemplatePlugin!");
        }
        return paperTemplatePlugin;
    }

    /**
     * Returns the {@link VelocityTemplatePlugin} instance.
     *
     * @return the VelocityTemplatePlugin instance
     * @apiNote Only call this method if the plugin runs on a Velocity server.
     */
    public VelocityTemplatePlugin velocity() {
        if (!(instance instanceof VelocityTemplatePlugin velocityTemplatePlugin)) {
            throw new IllegalStateException("This plugin is not a VelocityTemplatePlugin!");
        }
        return velocityTemplatePlugin;
    }

}
