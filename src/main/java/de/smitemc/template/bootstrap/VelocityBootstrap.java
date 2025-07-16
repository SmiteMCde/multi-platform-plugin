package de.smitemc.template.bootstrap;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import de.smitemc.template.VelocityTemplatePlugin;
import lombok.Getter;
import org.slf4j.Logger;

import java.nio.file.Path;

@Getter
@Plugin(id = "template",
        name = "TemplatePlugin",
        version = "1.0-RELEASE")
public final class VelocityBootstrap {

    private final ProxyServer proxyServer;
    private final Logger logger;
    private final Path dataDirectory;

    private VelocityTemplatePlugin velocityPlugin;

    @Inject
    public VelocityBootstrap(ProxyServer proxyServer, Logger logger, @DataDirectory Path dataDirectory) {
        this.proxyServer = proxyServer;
        this.logger = logger;
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    private void onProxyInitialize(ProxyInitializeEvent event) {
        this.velocityPlugin = new VelocityTemplatePlugin(this);
        this.velocityPlugin.register();
    }

    @Subscribe
    private void onProxyShutdown(ProxyShutdownEvent event) {
        if (velocityPlugin == null) throw new NullPointerException("VelocityPlugin is null!");
        this.velocityPlugin.shutdown();
    }

}
