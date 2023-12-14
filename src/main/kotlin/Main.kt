import kotlin.random.Random

fun main() {
    return startNewGame()
}

fun startNewGame(){
    val secretNumber = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).shuffled(Random).subList(0, 4).joinToString("")
    //println(secretNumber)

    var attempt = 1
    while (true) {
        print("Введите 4-значное число: ")
        val guessNumber = readln()

        if (guessNumber.length != 4){
            println("Ошибка. Введено неверное число")
            continue
        }

        val (bulls, cows) = compareNumber(guessNumber, secretNumber)
        println("Результат попытки $attempt: \n\tКоличество быков: $bulls \n\tКоличество коров: $cows\n")

        if (bulls == 4) {
            println("Победа! \nВы отгадали число $secretNumber \nКоличество попыток: $attempt")
            return
        }
        attempt++
    }
}

fun compareNumber(suggestedNumber: String, secretNumber: String): Pair<Int, Int> {
    var bulls = 0
    var cows = 0

    for (i in suggestedNumber.indices) {
        if (suggestedNumber[i] == secretNumber[i]) {
            bulls++
        } else if (secretNumber.contains(suggestedNumber[i])) {
            cows++
        }
    }

    return Pair(bulls, cows)
}