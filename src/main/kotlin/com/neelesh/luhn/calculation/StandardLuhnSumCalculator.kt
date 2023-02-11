package com.neelesh.luhn.calculation

object StandardLuhnSumCalculator : LuhnSumCalculator {
    override fun isValidAccountNumberString(inputAccountNumberString: String): Boolean {
        return inputAccountNumberString.isNotEmpty() && inputAccountNumberString.fold(true){acc, char -> acc && char.isDigit()}
    }

    override fun calculatorLuhnSumFromIntegerList(inputIntegerList: List<Int>): Long {
        val reversedInputList = inputIntegerList.asReversed()
        return reversedInputList.foldIndexed(0){index, acc, currentInt -> acc + calculateValueForElement(currentInt, index)
        }
    }

    override fun calculateValueForElement(digit: Int, index: Int): Long {
        if(index % 2 == 0){
            return digit.toLong()
        } else {
            val doubledDigit = digit * 2
            val luhnSumVal = if(doubledDigit > 9) 1 + doubledDigit % 10 else doubledDigit
            return luhnSumVal.toLong()
        }
    }


}