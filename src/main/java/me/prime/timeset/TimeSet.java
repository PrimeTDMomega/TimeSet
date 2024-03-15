package me.prime.timeset;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TimeSet extends JavaPlugin {

    private boolean enabled = false;

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("ts")).setExecutor(this);
        getServer().getScheduler().runTaskTimer(this, () -> {
            if (enabled) {
                for (World world : Bukkit.getWorlds()) {
                    world.setTime(1000);
                }
            }
        }, 20, 20);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ts")) {
            enabled = !enabled;
            if (enabled) {
                sender.sendMessage("§aTimeSet Enabled");
            } else {
                sender.sendMessage("§cTimeSet Disabled");
            }
            return true;
        }
        return false;
    }
}