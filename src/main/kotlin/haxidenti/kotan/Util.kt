package haxidenti.kotan

internal fun noDots(n: String): String {
    return n.replace(".", "_")
}