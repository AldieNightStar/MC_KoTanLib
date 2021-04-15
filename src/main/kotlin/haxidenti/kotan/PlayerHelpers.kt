package haxidenti.kotan

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.io.File

val Player.itemInMainHand: ItemStack
    get() = this.inventory.itemInMainHand

val Player.itemInOffHand: ItemStack
    get() = this.inventory.itemInOffHand

fun Player.giveItem(item: ItemStack, cb: ItemStack.() -> Unit) {
    val notAdded = inventory.addItem(item.apply(cb))
    if (notAdded.size > 0) {
        notAdded.forEach { this.world.dropItem(location, it.value) }
    }
    updateInventory()
}

fun Player.giveItem(item: ItemStack) {
    giveItem(item) {}
}

val CommandSender.isPlayer
    get() = this is Player