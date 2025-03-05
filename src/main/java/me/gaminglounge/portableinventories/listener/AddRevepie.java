package me.gaminglounge.portableinventories.listener;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.gaminglounge.portableinventories.items.PortableInventoriItems;

public class AddRevepie implements Listener {

    public void onJoin(PlayerJoinEvent e) {
        Collection<NamespacedKey> recepies = new ArrayList<>();
        for (var mat : PortableInventoriItems.values()) {
            recepies.add(
                    NamespacedKey.fromString("portableinventories:" + mat.item.getType().toString().toLowerCase()));
        }
        e.getPlayer().discoverRecipes(recepies);
    }

}
