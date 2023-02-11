package com.neelesh.luhn

import com.neelesh.luhn.calculation.StandardAccountNumberValidator
import com.neelesh.luhn.calculation.StandardLuhnAccountValidator
import com.neelesh.luhn.calculation.StandardLuhnSumCalculator
import com.neelesh.luhn.calculation.StandardLuhnSumValidationFunction

val EMPTY_STRING = ""

fun main(args: Array<String>){

    val validator = StandardLuhnAccountValidator(StandardAccountNumberValidator, StandardLuhnSumCalculator, StandardLuhnSumValidationFunction::validate)
    val accountString = if(args.isEmpty()) EMPTY_STRING else args[0]

    validator.validate(accountString).fold(
        {
            print(it.message)
        },
        {
            print(it)
        }
    )

}