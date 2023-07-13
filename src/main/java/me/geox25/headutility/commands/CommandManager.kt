package me.geox25.headutility.commands

import me.geox25.headutility.skull.SkullManager
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor.RED
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

fun messageNotAPlayer(sender: CommandSender) : Unit {
    sender.sendMessage(Component.text("This command is only for players!", RED))
}

fun messageNoPermission(player: Player) : Unit {
    player.sendMessage(Component.text("You do not have permission!", RED))
}

fun messageInvalidArgs(player: Player) : Unit {
    player.sendMessage(Component.text("Invalid Arguments", RED))
}

class CommandManager : CommandExecutor {

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {
        // Return if sender is not a player
        if (sender !is Player) {
            messageNotAPlayer(sender)
            return false;
        }

        // Cast sender to player
        val player: Player = sender

        if (!player.hasPermission("headutility.use")) {
            messageNoPermission(player)
            return false;
        }

        if (args.count() < 2) {
            messageInvalidArgs(player)
            return false
        }

        // Manage subcommands
        when(args[0]) {
            "url" -> {
                try {
                    val item: ItemStack = SkullManager.fromURL(args[1])
                    player.inventory.addItem(item)
                } catch (e: Exception) {
                    e.printStackTrace()
                    messageInvalidArgs(player)
                }
            }
            else -> {
                messageInvalidArgs(player)
            }
        }

        // return true by default
        return true;
    }
}