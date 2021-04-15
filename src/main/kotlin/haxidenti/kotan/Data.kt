package haxidenti.kotan

import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File

class Data(private val dataFolder: File, private val fileName: String, private val sectionPath: String?) {
    val config: ConfigurationSection
    private val saveConfig: () -> Unit

    init {
        val yml = YamlConfiguration.loadConfiguration(File(dataFolder, "$fileName.yml"))
        saveConfig = { yml.save(File(dataFolder, "$fileName.yml")) }

        if (sectionPath == null) {
            config = yml.defaultSection!!
        } else {
            var section = yml.getConfigurationSection(sectionPath)
            if (section == null) {
                section = yml.createSection(sectionPath)
            }
            config = section
        }
    }

    fun save() = saveConfig()

    operator fun <T> set(k: String, v: T) {
        config.set(k, v)
    }

    operator fun <T> get(k: String): T? {
        return config.get(k) as T
    }

    fun getKeys(k: String): List<String> {
        return config.getConfigurationSection(k)?.getKeys(false)?.toList() ?: listOf()
    }

    fun getKeys(): List<String> {
        return config.defaultSection?.getKeys(false)?.toList() ?: listOf()
    }

    fun remove(k: String) {
        this[k] = null
    }
}