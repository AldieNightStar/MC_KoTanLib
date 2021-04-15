package haxidenti.kotan

import org.bukkit.Chunk
import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.entity.Player
import java.io.File

fun Block.getData(dataFolder: File): Data = Data(dataFolder, "BlockData", "${noDots(world.name)}.${x}_${y}_${z}")
fun getAllBlockData(dataFolder: File): Data = Data(dataFolder, "BlockData", null)

fun Chunk.getData(dataFolder: File): Data = Data(dataFolder, "ChunkData", "${noDots(world.name)}.${x}_${z}")
fun getAllChunkData(dataFolder: File): Data = Data(dataFolder, "ChunkData", null)

fun World.getData(dataFolder: File): Data = Data(dataFolder, "WorldData", noDots(name))
fun getAllWorldData(dataFolder: File): Data = Data(dataFolder, "WorldData", null)

fun Player.getData(dataFolder: File) = Data(dataFolder, "PlayerData", noDots(this.name))
fun getAllPlayerData(dataFolder: File) = Data(dataFolder, "PlayerData", null)