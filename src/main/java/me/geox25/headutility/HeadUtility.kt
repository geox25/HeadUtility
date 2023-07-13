package me.geox25.headutility

import me.geox25.headutility.commands.CommandManager
import org.bukkit.plugin.java.JavaPlugin

class HeadUtility : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        getCommand("headutility")?.setExecutor(CommandManager())
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
