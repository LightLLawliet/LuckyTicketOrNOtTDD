package com.example.lotterytdd

interface LotteryValidation {

    fun isBingo(number: Int): Boolean

    class Base : LotteryValidation {
        override fun isBingo(number: Int): Boolean {
            if (number < 10 || number >= 9999_9999) {
                throw IllegalStateException()
            }
            val digits = mutableListOf<Int>()

            var temp = number

            while (temp > 0) {
                val rest = temp % 10
                digits.add(rest)
                temp /= 10
            }
            if (digits.size % 2 == 1) {
                throw IllegalStateException()
            }

            var sum = 0
            digits.forEachIndexed { index, digit ->
                if (index < digits.size / 2)
                    sum += digit
                else {
                    sum -= digit
                    if (sum < 0) return false
                }
            }
            return sum == 0
        }
    }
}

//            var sumLeft = 0
//            var sumRight = 0
//
//            left.forEach {
//                sumLeft += it.toString().toInt()
//            }
//            right.forEach {
//                sumRight += it.toString().toInt()
//            }
//
//            return sumLeft == sumRight
//        }
//    }
//}