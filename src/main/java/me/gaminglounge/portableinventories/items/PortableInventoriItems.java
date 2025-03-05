package me.gaminglounge.portableinventories.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.gaminglounge.itembuilder.ItemBuilder;

public enum PortableInventoriItems {
    ENDERCHEST(new ItemBuilder(Material.ENDER_CHEST).setGlint(true)
            .addRightInteractionEvent("portableinvs:open_enderchest").build()),
    SMITHING(new ItemBuilder(Material.SMITHING_TABLE).setGlint(true)
            .addRightInteractionEvent("portableinvs:open_smithing").build()),
    WORKBENCH(new ItemBuilder(Material.CRAFTING_TABLE).setGlint(true)
            .addRightInteractionEvent("portableinvs:open_workbench").build()),
    GRINDSTONE(new ItemBuilder(Material.GRINDSTONE).setGlint(true)
            .addRightInteractionEvent("portableinvs:open_grindstone").build()),
    STONECUTTER(new ItemBuilder(Material.STONECUTTER).setGlint(true)
            .addRightInteractionEvent("portableinvs:open_stonecutter").build());

    public ItemStack item;

    PortableInventoriItems(ItemStack item) {
        this.item = item;
    }
}
