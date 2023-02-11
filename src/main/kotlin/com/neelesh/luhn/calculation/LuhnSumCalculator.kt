package com.neelesh.luhn.calculation

interface AccountNumberValidator {
    fun isValidAccountNumberString(inputAccountNumberString: String) : Boolean
}

interface LuhnSumCalculator {

    fun calculatorLuhnSumFromIntegerList(inputIntegerList: List<Int>) : Long

    fun calculateValueForElement(digit: Int, index: Int) : Long
}

