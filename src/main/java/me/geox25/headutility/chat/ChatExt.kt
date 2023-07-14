package me.geox25.headutility.chat

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor.*
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.entity.Player

val helpLines = listOf(
    Component.text("Head Utility »")
        .color(DARK_GRAY)
        .decorate(TextDecoration.BOLD),
    Component.text("/hu url <textureUrl>")
        .color(GRAY),
    Component.text("/hu name <username>")
        .color(GRAY)
)

// Sends the formatted help lines to player in chat
fun messageHelpInfo(player: Player) {
    for (line in helpLines) {
        player.sendMessage(line)
    }
}