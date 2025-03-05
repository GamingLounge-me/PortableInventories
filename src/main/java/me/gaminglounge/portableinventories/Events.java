package me.gaminglounge.portableinventories;

import org.bukkit.block.ShulkerBox;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MenuType;
import org.bukkit.inventory.meta.BlockStateMeta;

import me.gaminglounge.itembuilder.ItemBuilderManager;
import net.kyori.adventure.text.Component;

public class Events {

    public Events() {

        ItemBuilderManager.addRightInteractionEvent("portableinvs:open_workbench", (e) -> {
            e.setCancelled(true);
            e.getPlayer().openInventory(
                    MenuType.CRAFTING.create(e.getPlayer(), Component.empty()));
        });

        ItemBuilderManager.addRightInteractionEvent("portableinvs:open_enderchest", (e) -> {
            e.setCancelled(true);
            e.getPlayer().openInventory(e.getPlayer().getEnderChest());
        });

        ItemBuilderManager.addRightInteractionEvent("portableinvs:open_stonecutter", (e) -> {
            e.setCancelled(true);
            e.getPlayer().openInventory(
                    MenuType.STONECUTTER.create(e.getPlayer(), Component.empty()));
        });

        ItemBuilderManager.addRightInteractionEvent("portableinvs:open_smithing", (e) -> {
            e.setCancelled(true);
            e.getPlayer().openInventory(
                    MenuType.SMITHING.create(e.getPlayer(), Component.empty()));
        });

        ItemBuilderManager.addRightInteractionEvent("portableinvs:open_grindstone", (e) -> {
            e.setCancelled(true);
            e.getPlayer().openInventory(
                    MenuType.GRINDSTONE.create(e.getPlayer(), Component.empty()));
        });

        ItemBuilderManager.addLeftInteractionEvent("portableinvs:open_shulker", (e) -> {
            e.setCancelled(true);
            ItemStack item = e.getItem();
            BlockStateMeta bsm = (BlockStateMeta) item.getItemMeta();
            ShulkerBox box = (ShulkerBox) bsm.getBlockState();
            e.getPlayer().openInventory(box.getInventory());
        });

    }

}
