package com.example.lotterytdd

import org.junit.Assert.assertEquals
import org.junit.Test

class MainViewModelTest {

    @Test
    fun `test success`() {
        val lotteryValidation = LotteryValidation.Base()
        val list = listOf(11, 1111, 5656, 8686, 101101, 908188)
        val expected = true

        list.forEach { number ->
            val actual = lotteryValidation.isBingo(number = number)
            assertEquals(expected, actual)
        }
    }

    @Test
    fun `test failure`() {
        val lotteryValidation = LotteryValidation.Base()
        val list = listOf(12, 34, 56, 5678, 9101, 101102)
        val expected = false

        list.forEach { number ->
            val actual = lotteryValidation.isBingo(number = number)
            assertEquals(expected, actual)
        }
    }

    @Test
    fun `test invalid`() {
        val lotteryValidation = LotteryValidation.Base()
        val list = listOf(
            0,
            1,
            2,
            -1,
            -2,
            -3,
            1241251522,
            131,
            11141,
            1114191,
            Int.MIN_VALUE,
            Int.MAX_VALUE
        )
        var count = 0
        list.forEach { number ->
            try {
                lotteryValidation.isBingo(number = number)
            } catch (e: java.lang.Exception) {
                count++
            }
        }
        assertEquals(list.size, count)
    }
}