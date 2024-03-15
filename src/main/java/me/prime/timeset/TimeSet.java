package me.prime.timeset;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class TimeSet extends JavaPlugin {

    @Override
    public void onEnable() {
        // Set the time to day (1000) for all worlds
        for (World world : Bukkit.getWorlds()) {
            world.setTime(1000);
        }

        // Prevent the time from changing
        getServer().getScheduler().runTaskTimer(this, () -> {
            for (World world : Bukkit.getWorlds()) {
                world.setTime(1000);
            }
        }, 20, 20);
    }
}