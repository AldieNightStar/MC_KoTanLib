package haxidenti.kotan

import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.Chest
import org.bukkit.block.Furnace
import org.bukkit.block.ShulkerBox
import org.bukkit.inventory.Inventory

val Block.inventory: Inventory?
    get() {
        return when (type) {
            Material.FURNACE -> {
                val furnace = state as Furnace
                furnace.inventory
            }
            Material.CHEST -> {
                val chest = state as Chest
                chest.inventory
            }
            Material.SHULKER_BOX -> {
                val box = state as ShulkerBox
                box.inventory
            }
            else -> {
                null
            }
        }
    }
