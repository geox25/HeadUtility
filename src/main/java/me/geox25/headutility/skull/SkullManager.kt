package me.geox25.headutility.skull

import com.destroystokyo.paper.profile.PlayerProfile
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.profile.PlayerTextures
import java.net.URL
import java.util.UUID

class SkullManager {

    companion object {

        // Function to acquire a custom textured skull from a minecraft player texture url
        fun fromURL(url: String) : ItemStack {
            val uuid: UUID = UUID.randomUUID()
            val profile: PlayerProfile = Bukkit.createProfile(uuid)
            val textures: PlayerTextures = profile.textures
            textures.skin = URL(url)
            profile.setTextures(textures)

            val skull: ItemStack = ItemStack(Material.PLAYER_HEAD)
            val skullMeta: SkullMeta = skull.itemMeta as SkullMeta
            skullMeta.playerProfile = profile
            skull.setItemMeta(skullMeta)

            return skull
        }
    }
}