package com.example.lotterytdd

interface LotteryValidation {

    fun isBingo(number: Int): Boolean

    class Base : LotteryValidation {
        override fun isBingo(number: Int): Boolean {
            if (number < 10)
                throw IllegalStateException()
            if (number >= 9999_9999) {
                throw IllegalStateException()
            }
            val text = number.toString()
            if (text.length % 2 == 1) {
                throw IllegalStateException()
            }
            val left = text.substring(0, text.length / 2)
            val right = text.substring(text.length / 2)

            var sumLeft = 0
            var sumRight = 0

            left.forEach {
                sumLeft += it.toString().toInt()
            }
            right.forEach {
                sumRight += it.toString().toInt()
            }

            return sumLeft == sumRight
        }
    }
}