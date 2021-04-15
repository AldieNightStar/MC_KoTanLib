package haxidenti.kotan

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener

class Main : JavaPlugin(), Listener {
    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }
}