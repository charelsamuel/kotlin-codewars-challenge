/*
    codewars challenge:
    https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/kotlin

    Count the number of Duplicates
    Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string.
    The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.

    Example
        "abcde" -> 0 # no characters repeats more than once
        "aabbcde" -> 2 # 'a' and 'b'
        "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
        "indivisibility" -> 1 # 'i' occurs six times
        "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
        "aA11" -> 2 # 'a' and '1'
        "ABBA" -> 2 # 'A' and 'B' each occur twice
 */
class CountingDuplicate {
    companion object {
        fun mySolution(text: String): Int {
            val textLowerCase = text.lowercase()

            var textMap = mutableMapOf<Char, Int>()
            for (t in textLowerCase) {
                textMap[t] = 0
            }

            for (t in textLowerCase) {
                val counter = textMap[t]!! + 1
                textMap.put(t, counter)
            }

            val filteredText = textMap.filter {it.value > 1}

            return filteredText.size
        }

        fun bestSolution(text: String): Int {
            return text.groupBy(Char::lowercase).count { it.value.count() > 1 }
        }

        fun otherSolution(text: String): Int {
            return text
                .lowercase()
                .split("")
                .filter { s -> s != "" }
                .groupingBy { s -> s }
                .eachCount()
                .filter { entry -> entry.value > 1 }
                .size
        }
    }

}
fun main() {
    val text = "AbbnsdfubUa19272"
    println("Text: $text")

    val myResult = CountingDuplicate.mySolution(text)
    println("My solution counting duplicate: $myResult")

    val bestResult = CountingDuplicate.bestSolution(text)
    println("Best solution counting duplicate: $bestResult")

    val otherResult = CountingDuplicate.otherSolution(text)
    println("Other solution counting duplicate: $otherResult")
}
