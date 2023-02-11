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
    fun `when given integer and index calculateValueForElement will return correct individual value for non double element`(){
        val inputInteger = 1
        val index = 0

        Assertions.assertEquals(1, calculator.calculateValueForElement(inputInteger, index))
    }

    @Test
    fun `when given integer and index calculateValueForElement will return correct individual value for double element`(){
        val inputInteger = 8
        val index = 1

        Assertions.assertEquals(7, calculator.calculateValueForElement(inputInteger, index))
    }

    @Test
    fun `when given an input integer list calculateLuhnSumFromIntegerList will calculate the luhn sum`(){
        val inputIntegerArray = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

        val expectedSum: Long = 47

        Assertions.assertEquals(expectedSum, calculator.calculatorLuhnSumFromIntegerList(inputIntegerArray))
    }

    @Test
    fun `when given an input integer list calculateLuhnSumFromIntegerList will calculate the luhn sum with multi digit sums`(){
        val inputIntegerArray = listOf(4,9,9,2,7,3,9,8,7,1,6)

        val expectedSum: Long = 70

        Assertions.assertEquals(expectedSum, calculator.calculatorLuhnSumFromIntegerList(inputIntegerArray))
    }

}