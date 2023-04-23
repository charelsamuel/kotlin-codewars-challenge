import java.awt.image.AreaAveragingScaleFilter

/*
    codewars challenge:
    https://www.codewars.com/kata/550554fd08b86f84fe000a58/train/kotlin

    Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.

    Example 1:
        a1 = ["arp", "live", "strong"]

        a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

        returns ["arp", "live", "strong"]

    Example 2:
        a1 = ["tarp", "mice", "bull"]

        a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

        returns []

    Notes:
    Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
    In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
    Beware: In some languages r must be without duplicates.
 */
class WhichAreIn {

    companion object {

        fun mySolution(array1: Array<String>, array2: Array<String>): Array<String> {
            var arrayResult = arrayOf<String>()
            for (text2 in array2) {
                arrayResult += array1.filter { text -> text2.contains(text)}
            }

            return arrayResult.sorted().distinct().toTypedArray()
        }

        fun bestSolution(array1: Array<String>, array2: Array<String>): Array<String> {
            return array1.toSet()
                .filter { substring -> array2.any { substring in it} }
                .sorted()
                .toTypedArray()
        }

        fun otherSolution(array1: Array<String>, array2: Array<String>): Array<String> {
            return array1.filter{e->array2.any{it.contains(e)}}.distinct().sorted().toTypedArray()
        }
    }
}

fun main() {
    val a1 = arrayOf("arp", "live", "strong")
    val a2 = arrayOf("lively", "alive", "harp", "sharp", "armstrong")

    val mySolution = WhichAreIn.mySolution(a1, a2)
    for (text in mySolution) {
        println("My Solution: Value of array1 which is present in array2 is: $text")
    }

    val bestSolution = WhichAreIn.bestSolution(a1, a2)
    for (text in bestSolution) {
        println("Best Solution: Value of array1 which is present in array2 is: $text")
    }

    val otherSolution = WhichAreIn.otherSolution(a1, a2)
    for (text in otherSolution) {
        println("Other Solution: Value of array1 which is present in array2 is: $text")
    }
}