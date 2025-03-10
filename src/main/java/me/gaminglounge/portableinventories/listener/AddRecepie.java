package me.gaminglounge.portableinventories.listener;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.gaminglounge.portableinventories.items.PortableInventoriItems;

public class AddRecepie implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        for (var mat : PortableInventoriItems.values()) {
            p.discoverRecipe(
                    NamespacedKey.fromString("portableinventories:" + mat.item.getType().toString().toLowerCase()));
        }
    }

}
