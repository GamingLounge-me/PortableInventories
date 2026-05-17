package me.gaminglounge.portableinventories;

import org.bukkit.configuration.file.FileConfiguration;

public class Update_Config {

    PortableInventories pi = PortableInventories.INSTANCE;
    FileConfiguration config = pi.getConfig();

    public Update_Config() {
        switch (config.getString("config")) {
            case "1":
                // pi.saveConfig();
                break;
        
            default:
                break;
        }
    }

}
