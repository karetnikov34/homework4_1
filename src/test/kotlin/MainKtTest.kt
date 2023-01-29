import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun vkPaylimitsFalse() {
        val card = "VK Pay"
        val amount = 15_001
        val month = 0
        val day = 0

        val result = commission(card, amount, month, day)

        assertEquals(-1, result)
    }

    @Test
    fun vkPaylimitsFalseV2() {
        val card = "VK Pay"
        val amount = 500
        val month = 39_900
        val day = 0

        val result = commission(card, amount, month, day)

        assertEquals(-1, result)
    }

    @Test
    fun vkPayLimitsTrue() {
        val card = "VK Pay"
        val amount = 14_000
        val month = 0
        val day = 0

        val result = commission(card, amount, month, day)

        assertEquals(0, result)
    }

    @Test
    fun mastercardLimitsTrue() {
        val card = "MasterCard"
        val amount = 50_000
        val month = 0
        val day = 0

        val result = commission(card, amount, month, day)

        assertEquals(0, result)
    }

    @Test
    fun mastercardLimitsTrueV2() {
        val card = "MasterCard"
        val amount = 80_000
        val month = 20_000
        val day = 10_000

        val result = commission(card, amount, month, day)

        assertEquals(170, result)
    }

    @Test
    fun mastercardLimitsTrueV3() {
        val card = "MasterCard"
        val amount = 200
        val month = 0
        val day = 0

        val result = commission(card, amount, month, day)

        assertEquals(21, result)
    }

    @Test
    fun maestroLimitsFalse() {
        val card = "Maestro"
        val amount = 80_000
        val month = 100_000
        val day = 90_000

        val result = commission(card, amount, month, day)

        assertEquals(-1, result)
    }

    @Test
    fun maestroLimitsFalseV2() {
        val card = "Maestro"
        val amount = 80_000
        val month = 550_000
        val day = 90_000

        val result = commission(card, amount, month, day)

        assertEquals(-1, result)
    }

    @Test
    fun visaLimitsTrue() {
        val card = "Visa"
        val amount = 80_000
        val month = 100_000
        val day = 30_000

        val result = commission(card, amount, month, day)

        assertEquals(600, result)
    }

    @Test
    fun visaLimitsFalse() {
        val card = "Visa"
        val amount = 80_000
        val month = 550_000
        val day = 90_000

        val result = commission(card, amount, month, day)

        assertEquals(-1, result)
    }

    @Test
    fun visaLimitsFalseV2() {
        val card = "Visa"
        val amount = 80_000
        val month = 150_000
        val day = 90_000

        val result = commission(card, amount, month, day)

        assertEquals(-1, result)
    }

    @Test
    fun MirLimitsTrue() {
        val card = "Мир"
        val amount = 900
        val month = 100_000
        val day = 30_000

        val result = commission(card, amount, month, day)

        assertEquals(35, result)
    }

    @Test
    fun falseCard() {
        val card = "VKPay"
        val amount = 15000
        val month = 0
        val day = 0

        val result = commission(card, amount, month, day)

        assertEquals(-2, result)
    }
}