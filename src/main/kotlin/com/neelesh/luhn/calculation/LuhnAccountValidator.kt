package com.neelesh.luhn.calculation

import arrow.core.Either

interface LuhnAccountValidator {
    fun getAccountNumberArray(accountNumberString: String) : Either<Exception, List<Int>>
}

interface AccountNumberValidator {
    fun isValidAccountNumberString(inputAccountNumberString: String) : Boolean
}

interface LuhnSumCalculator {

    fun calculatorLuhnSumFromIntegerList(inputIntegerList: List<Int>) : Long

    fun calculateValueForElement(digit: Int, index: Int) : Long
}

