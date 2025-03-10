package me.gaminglounge.portableinventories;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import me.gaminglounge.portableinventories.commands.PortableInventoriesCommand;
import me.gaminglounge.portableinventories.listener.AddRecepie;

public final class PortableInventories extends JavaPlugin {

    public static PortableInventories INSTANCE;

    @Override
    public void onLoad() {
        INSTANCE = this;
        new Events();

        if (!CommandAPI.isLoaded())
            CommandAPI.onLoad(new CommandAPIBukkitConfig(this));

        new PortableInventoriesCommand();
    }

    @Override
    public void onEnable() {
        this.listener();

        new CraftingRecipe();
    }

    @Override
    public void onDisable() {

    }

    public void listener() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new AddRecepie(), this);
    }

}
