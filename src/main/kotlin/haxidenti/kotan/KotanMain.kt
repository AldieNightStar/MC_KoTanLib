package haxidenti.kotan

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class KotanMain : JavaPlugin(), Listener {
    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

}