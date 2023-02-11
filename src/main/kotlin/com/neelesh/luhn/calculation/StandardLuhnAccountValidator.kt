package com.neelesh.luhn.calculation

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import java.util.*

object StandardLuhnSumValidationFunction {
    fun validate(a: Long): Boolean {
        return a % 10 == 0.toLong()
    }
}

class StandardLuhnAccountValidator(
    val accountNumberValidator: AccountNumberValidator,
    val luhnSumCalculator: LuhnSumCalculator,
    val validationFunction: (a: Long) -> Boolean
    ) : LuhnAccountValidator {
    override fun getAccountNumberArray(accountNumberString: String): Either<Exception, List<Int>> {
        if(accountNumberValidator.isValidAccountNumberString(accountNumberString)){
            return accountNumberString.map { char -> char.digitToInt() }.right()
        } else {
            return InputMismatchException("Input string: $accountNumberString is not a valid account number").left()
        }
    }

    override fun validateIntegerList(accountNumberAsIntList: List<Int>): Boolean {
        return validationFunction(luhnSumCalculator.calculatorLuhnSumFromIntegerList(accountNumberAsIntList))
    }

    override fun validate(accountNumberString: String): Either<Exception, Boolean> {
        return getAccountNumberArray(accountNumberString).map { validIntList -> validateIntegerList(validIntList) }
    }
}