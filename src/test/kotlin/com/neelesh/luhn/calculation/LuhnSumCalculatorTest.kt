package com.neelesh.luhn.calculation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LuhnSumCalculatorTest {

    private val calculator: LuhnSumCalculator = StandardLuhnSumCalculator

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

    @Test
    fun `when given an input integer list calculateLuhnSumFromIntegerList will calculate the luhn sum`(){
        val inputIntegerArray = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

        val expectedSum: Long = 65

        Assertions.assertEquals(expectedSum, calculator.calculatorLuhnSumFromIntegerList(inputIntegerArray))
    }
}