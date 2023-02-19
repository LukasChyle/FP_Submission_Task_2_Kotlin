fun main() {
    val tomteland = Tomteland()
    while (true) {
        println("\nVems undersåtar vill du få listade?")
        val input = readln()
        if (input.isBlank()) break
        println(tomteland.getUnderlings(input, mutableListOf()))
    }
}

class Tomteland {
    private val hierarchy = mapOf(
        "Tomten" to listOf("Glader", "Butter"),
        "Glader" to listOf("Tröger", "Trötter", "Blyger"),
        "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to listOf("Skumtomten"),
        "Skumtomten" to listOf("Dammråttan"),
        "Räven" to listOf("Gråsuggan", "Myran"),
        "Myran" to listOf("Bladlusen")
    )

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        val underlings = hierarchy[currentName]
        if (underlings != null) {
            res.addAll(underlings)
            underlings.forEach { getUnderlings(it, res) }
        }
        return res.toList()
    }
}