fun main() {
    println(commission("VK Pay", 15_001, 0, 0))
}

fun commission(card: String, amount: Int, month: Int, day: Int) =
    when (card) {
        "VK Pay" -> if (month + amount > 40_000 || amount > 15_000) -1 else 0
        "MasterCard", "Maestro" -> when {
            month + amount > 600_000 || day + amount > 150_000 -> -1
            amount + month <= 75000 && amount >= 300 -> 0
            amount < 300 -> (amount * 0.006 + 20).toInt()
            else -> ((amount - (75000 - month)) * 0.006 + 20).toInt()
        }
        "Visa", "Мир" -> when {
            month + amount > 600_000 || day + amount > 150_000 -> -1
            amount * 0.0075 < 35 -> 35
            else -> (amount * 0.0075).toInt()
        }
        else -> -2
    }