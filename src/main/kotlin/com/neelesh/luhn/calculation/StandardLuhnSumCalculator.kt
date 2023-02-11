package com.neelesh.luhn.calculation

object StandardLuhnSumCalculator : LuhnSumCalculator {
    override fun isValidAccountNumberString(inputAccountNumberString: String): Boolean {
        return inputAccountNumberString.isNotEmpty() && inputAccountNumberString.fold(true){acc, char -> acc && char.isDigit()}
    }

    override fun calculatorLuhnSumFromIntegerList(inputIntegerList: List<Int>): Long {
        val reversedInputList = inputIntegerList.asReversed()
        return reversedInputList.foldIndexed(0){index, acc, currentInt ->
            if(index % 2 == 0){
                acc + currentInt
            } else {
                acc + currentInt*2
            }
        }
    }
}