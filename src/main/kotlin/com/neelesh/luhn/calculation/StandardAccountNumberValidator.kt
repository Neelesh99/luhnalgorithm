package com.neelesh.luhn.calculation

object StandardAccountNumberValidator : AccountNumberValidator {

    override fun isValidAccountNumberString(inputAccountNumberString: String): Boolean {
        return inputAccountNumberString.isNotEmpty() && inputAccountNumberString.fold(true){acc, char -> acc && char.isDigit()}
    }
}