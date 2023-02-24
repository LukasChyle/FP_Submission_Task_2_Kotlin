fun main() {
    val tomteland = Tomteland()
    while (true) {
        println("\nVems undersåtar vill du få listade?")
        val input = readln()
        if (input.isBlank()) break
        println(tomteland.getUnderling2(input))
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

    /*  ---------------- Version 1 ----------------  */
    // Solution that don't require any change of the pre-made test-code from the teacher.
    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        val underlings = hierarchy[currentName]
        if (underlings != null) {
            res.addAll(underlings)
            underlings.forEach { getUnderlings(it, res) }
        }
        return res
    }

    /*  ---------------- Version 2 ----------------  */
    fun getUnderling2(name: String): List<String> {
        val res: MutableList<String> = mutableListOf()

        fun processHierarchy(currentName: String) {
            hierarchy[currentName]?.forEach {
                res.add(it)
                processHierarchy (it) }
        }

        processHierarchy(name)
        return res
    }
}