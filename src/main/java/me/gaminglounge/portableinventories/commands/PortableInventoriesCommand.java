package me.gaminglounge.portableinventories.commands;

import org.bukkit.inventory.MenuType;

import dev.jorel.commandapi.CommandAPICommand;
import me.gaminglounge.portableinventories.PortableInventories;
import net.kyori.adventure.text.Component;

public class PortableInventoriesCommand {

    public PortableInventoriesCommand() {

        new CommandAPICommand("portableinventories:workbench")
                .withPermission("portableinventories.command.workbench")
                .withAliases(PortableInventories.INSTANCE.getConfig()
                        .getStringList("commands.workbench.aliases")
                        .toArray(num -> new String[num]))
                .executesPlayer((player, args) -> {
                    player.openInventory(
                            MenuType.CRAFTING.create(player, Component.empty()));
                })
                .register();

        new CommandAPICommand("portableinventories:enderchest")
                .withPermission("portableinventories.command.enderchest")
                .withAliases(PortableInventories.INSTANCE.getConfig()
                        .getStringList("commands.enderchest.aliases")
                        .toArray(num -> new String[num]))
                .executesPlayer((player, args) -> {
                    player.openInventory(player.getEnderChest());
                })
                .register();

        new CommandAPICommand("portableinventories:stonecutter")
                .withPermission("portableinventories.command.stonecutter")
                .withAliases(PortableInventories.INSTANCE.getConfig()
                        .getStringList("commands.stonecutter.aliases")
                        .toArray(num -> new String[num]))
                .executesPlayer((player, args) -> {
                    player.openInventory(
                            MenuType.STONECUTTER.create(player, Component.empty()));
                })
                .register();

        new CommandAPICommand("portableinventories:smithing")
                .withPermission("portableinventories.command.smithing")
                .withAliases(PortableInventories.INSTANCE.getConfig()
                        .getStringList("commands.smithing.aliases")
                        .toArray(num -> new String[num]))
                .executesPlayer((player, args) -> {
                    player.openInventory(
                            MenuType.SMITHING.create(player, Component.empty()));
                })
                .register();

        new CommandAPICommand("portableinventories:grindstone")
                .withPermission("portableinventories.command.grindstone")
                .withAliases(PortableInventories.INSTANCE.getConfig()
                        .getStringList("commands.grindstone.aliases")
                        .toArray(num -> new String[num]))
                .executesPlayer((player, args) -> {
                    player.openInventory(
                            MenuType.GRINDSTONE.create(player, Component.empty()));
                })
                .register();

    }

}
