package com.neelesh.luhn.calculation

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import java.util.*

class StandardLuhnAccountValidator(
    val accountNumberValidator: AccountNumberValidator,
    val luhnSumCalculator: LuhnSumCalculator
    ) : LuhnAccountValidator {
    override fun getAccountNumberArray(accountNumberString: String): Either<Exception, List<Int>> {
        if(accountNumberValidator.isValidAccountNumberString(accountNumberString)){
            return accountNumberString.map { char -> char.digitToInt() }.right()
        } else {
            return InputMismatchException("Input string: $accountNumberString is not a valid account number").left()
        }
    }
}