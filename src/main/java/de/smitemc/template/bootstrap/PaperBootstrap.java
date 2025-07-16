package de.smitemc.template.bootstrap;

import de.smitemc.template.PaperTemplatePlugin;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class PaperBootstrap extends JavaPlugin {

    private PaperTemplatePlugin paperPlugin;

    @Override
    public void onEnable() {
        this.paperPlugin = new PaperTemplatePlugin(this);
        this.paperPlugin.register();
    }

    @Override
    public void onDisable() {
        if (paperPlugin == null) throw new NullPointerException("PaperPlugin is null!");
        this.paperPlugin.shutdown();
    }

}
