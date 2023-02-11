package com.neelesh.luhn.calculation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LuhnSumCalculatorTest {

    val calculator: LuhnSumCalculator = StandardLuhnSumCalculator

    @Test
    fun `when given an account number as string isValidAccountNumberString will return true for valid account number string`(){
        val inputAccountNumber = "49927398716"

        Assertions.assertEquals(true, calculator.isValidAccountNumberString(inputAccountNumber))
    }

    @Test
    fun `when given an account number as string isValidAccountNumberString will return false for invalid account number string`(){
        val inputAccountNumber = "499asf73987-6"

        Assertions.assertEquals(false, calculator.isValidAccountNumberString(inputAccountNumber))
    }

    @Test
    fun `when given an account number as string isValidAccountNumberString will return false for empty account number string`(){
        val inputAccountNumber = ""

        Assertions.assertEquals(false, calculator.isValidAccountNumberString(inputAccountNumber))
    }
}