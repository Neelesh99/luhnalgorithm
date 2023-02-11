package com.neelesh.luhn.calculation

interface LuhnSumCalculator {
    fun isValidAccountNumberString(inputAccountNumberString: String) : Boolean

    fun calculatorLuhnSumFromIntegerList(inputIntegerList: List<Int>) : Long

}

