package de.smitemc.template.internal.minestom.commands;

import de.smitemc.template.TemplatePlugin;
import net.minestom.server.command.CommandSender;
import net.minestom.server.command.builder.Command;
import net.minestom.server.command.builder.CommandContext;
import org.jetbrains.annotations.NotNull;

public class TemplateMinestomCommand extends Command {

    public TemplateMinestomCommand() {
        super("templateminestom");
        this.setDefaultExecutor(this::onDefaultExecute);
    }

    private void onDefaultExecute(@NotNull CommandSender sender, CommandContext commandContext) {
        sender.sendMessage(TemplatePlugin.getInstance().getMiniMessage().deserialize("<yellow>This is a multi-platform plugin template! <gray>(Minestom)"));
    }

}
