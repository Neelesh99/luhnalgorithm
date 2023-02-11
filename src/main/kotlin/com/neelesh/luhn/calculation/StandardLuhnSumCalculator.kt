package com.neelesh.luhn.calculation

object StandardLuhnSumCalculator : LuhnSumCalculator {
    override fun isValidAccountNumberString(inputAccountNumberString: String): Boolean {
        return inputAccountNumberString.isNotEmpty() && inputAccountNumberString.fold(true){acc, char -> acc && char.isDigit()}
    }
}