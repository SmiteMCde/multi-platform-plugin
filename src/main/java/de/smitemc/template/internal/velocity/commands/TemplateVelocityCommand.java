package de.smitemc.template.internal.velocity.commands;

import com.velocitypowered.api.command.SimpleCommand;
import de.smitemc.template.TemplatePlugin;

public class TemplateVelocityCommand implements SimpleCommand {

    @Override
    public void execute(Invocation invocation) {
        invocation.source().sendMessage(TemplatePlugin.getInstance().getMiniMessage().deserialize("<yellow>This is a multi-platform plugin template! <gray>(Velocity)"));
    }

}
