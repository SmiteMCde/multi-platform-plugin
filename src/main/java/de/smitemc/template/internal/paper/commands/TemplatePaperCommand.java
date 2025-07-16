package de.smitemc.template.internal.paper.commands;

import de.smitemc.template.TemplatePlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TemplatePaperCommand extends Command {

    public TemplatePaperCommand() {
        super("templatepaper");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String @NotNull [] strings) {
        commandSender.sendMessage(TemplatePlugin.getInstance().getMiniMessage().deserialize("<yellow>This is a multi-platform plugin template! <gray>(Paper)"));
        return true;
    }

}
