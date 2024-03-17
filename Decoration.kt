package example.myapp.decor

data class Decoration(val rocks: String) {
}

fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    println (decoration1.equals(decoration2))
    println (decoration3.equals(decoration2))

    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

// Assign all properties to variables.
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)

}

// Here is a data class with 3 properties.
data class Decoration2(val rocks: String, val wood: String, val diver: String){
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}

enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

class Choice {
    companion object {
        var name: String = "lyric"
        fun showDescription(name:String) = println("My favorite $name")
    }
}


fun main(){
    makeDecorations()
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)

    println(Choice.name)
    Choice.showDescription("pick")
    Choice.showDescription("selection")

    val equipment = "fish net" to "catching fish"
    println("${equipment.first} used for ${equipment.second}")

    val numbers = Triple(6, 9, 42)
    println(numbers.toString())
    println(numbers.toList())

    val equipment2 = ("fish net" to "catching fish") to "equipment"
    println("${equipment2.first} is ${equipment2.second}\n")
    println("${equipment2.first.second}")

    val equipment1 = "fish net" to "catching fish"
    val (tool, use) = equipment1
    println("$tool is used for $use")

    val numbers2 = Triple(6, 9, 42)
    val (n1, n2, n3) = numbers2
    println("$n1 $n2 $n3")

    val list = listOf(1, 5, 3, 4)
    println(list.sum())

    /*
    val list2 = listOf("a", "bbb", "cc")
    println(list2.sum())
     */

    val list2 = listOf("a", "bbb", "cc")
    println(list2.sumBy { it.length })

    val list3 = listOf("a", "bbb", "cc")
    for (s in list3.listIterator()) {
        println("$s ")
    }

    val scientific = hashMapOf("guppy" to "poecilia reticulata", "catfish" to "corydoras", "zebra fish" to "danio rerio" )

    println (scientific.get("guppy"))
    println(scientific.get("zebra fish"))
    println(scientific.get("swordtail"))
    println(scientific.getOrDefault("swordtail", "sorry, I don't know"))
    println(scientific.getOrElse("swordtail") {"sorry, I don't know"})

    /*const val rocks = 3

    val value1 = complexFunctionCall() // OK
    const val CONSTANT1 = complexFunctionCall() // NOT ok
    */

    val plant = GreenLeafyPlant(size = 10)
    plant.print()
    println("\n")
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()  // what will it print?

    println(aquariumPlant.isGreen)
    plant.pull()

}


object Constants {
    const val CONSTANT2 = "object constant"
}

/*
fun String.hasSpaces(): Boolean {
    val found = this.indexOf(' ')
    // also valid: this.indexOf(" ")
    // returns positive number index in String or -1 if not found
    return found != -1
}
*/
fun String.hasSpaces() = indexOf(" ") != -1

/*
class AquariumPlant(val color: String, private val size: Int)

fun AquariumPlant.isRed() = color == "red"    // OK
//fun AquariumPlant.isBig() = size > 50         // gives error
*/

open class AquariumPlant(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")


fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

val AquariumPlant.isGreen: Boolean
    get() = color == "green"

val plant: AquariumPlant? = null
