/*
    codewars challenge:
    https://www.codewars.com/kata/514b92a657cdc65150000006/train/kotlin

    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
    Additionally, if the number is negative, return 0 (for languages that do have them).

    Note: If the number is a multiple of both 3 and 5, only count it once.
 */
class MultipleThreeOrFive {

    companion object {
        fun mySolution(number: Int): Int {
            return if (number < 0) {
                0
            } else {
                var numberRange = 1 until number
                val numberMap = mutableSetOf<Int>()

                for (n in numberRange) {
                    numberMap.add(n)
                }

                return numberMap.filter{ (it % 3 == 0 || it % 5 == 0)}.sum()
            }
        }

        fun bestSolution(number: Int): Int {
            return (1 until number).filter { it % 3 == 0 || it % 5 == 0 }.sum()
        }

        fun otherSolution(number: Int): Int {
            return (3 until number step 3).union((5 until number step 5)).sum()
        }
    }
}

fun main() {
    val number = 10

    println("Sum of Multiple of 3 and 5. My Solution: ${MultipleThreeOrFive.mySolution(number)}")
    println("Sum of Multiple of 3 and 5. Best Solution: ${MultipleThreeOrFive.bestSolution(number)}")
    println("Sum of Multiple of 3 and 5. Other Solution: ${MultipleThreeOrFive.otherSolution(number)}")
}