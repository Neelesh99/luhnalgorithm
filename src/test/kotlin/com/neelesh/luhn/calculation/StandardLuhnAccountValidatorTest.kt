package com.neelesh.luhn.calculation

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class StandardLuhnAccountValidatorTest {

    val accountNumberValidator = mockk<AccountNumberValidator>()
    val luhnSumCalculator = mockk<LuhnSumCalculator>()
    val accountValidator = StandardLuhnAccountValidator(accountNumberValidator, luhnSumCalculator, StandardLuhnSumValidationFunction::validate)

    @Test
    fun `when given an account number string getAccountNumberArray will return an Integer list when given a valid string`(){
        val inputString = "49927398716"

        every {accountNumberValidator.isValidAccountNumberString(inputString)} returns true

        val expectedIntList = listOf(4,9,9,2,7,3,9,8,7,1,6)

        accountValidator.getAccountNumberArray(inputString).map{Assertions.assertEquals(expectedIntList, it)}
    }

    @Test
    fun `when given an account number string getAccountNumberArray will return an Integer list when given an invalid string`(){
        val inputString = "4992fc98716"

        every {accountNumberValidator.isValidAccountNumberString(inputString)} returns false

        val expectedException = InputMismatchException("Input string: $inputString is not a valid account number")

        accountValidator.getAccountNumberArray(inputString).mapLeft{Assertions.assertEquals(expectedException.message, it.message)}
    }

    @Test
    fun `when given an account number string getAccountNumberArray will return an Integer list when given an empty string`(){
        val inputString = ""

        every {accountNumberValidator.isValidAccountNumberString(inputString)} returns false

        val expectedException = InputMismatchException("Input string: $inputString is not a valid account number")

        accountValidator.getAccountNumberArray(inputString).mapLeft{Assertions.assertEquals(expectedException.message, it.message)}
    }

    @Test
    fun `when given an integer list will validateIntegerList calculate whether sum represents a valid account number`(){
        val inputIntegerList = listOf(0, 2, 3, 4, 5)

        every { luhnSumCalculator.calculatorLuhnSumFromIntegerList(inputIntegerList) } returns 20

        Assertions.assertTrue(accountValidator.validateIntegerList(inputIntegerList))
    }

    @Test
    fun `when given an integer list will validateIntegerList calculate whether sum represents an invalid account number`(){
        val inputIntegerList = listOf(1, 2, 3, 4, 5)

        every { luhnSumCalculator.calculatorLuhnSumFromIntegerList(inputIntegerList) } returns 21

        Assertions.assertFalse(accountValidator.validateIntegerList(inputIntegerList))
    }

    @Test
    fun `when given valid account number as string validate will return true when injected dependencies evaluate correctly`(){
        val inputAccountNumber = "49927398716"

        every { accountNumberValidator.isValidAccountNumberString(inputAccountNumber) } returns true
        every { luhnSumCalculator.calculatorLuhnSumFromIntegerList(any()) } returns 70

        accountValidator.validate(inputAccountNumber).map { Assertions.assertTrue(it) }
    }

    @Test
    fun `when given invalid account number as string validate will return false when injected dependencies evaluate correctly`(){
        val inputAccountNumber = "59927398716"

        every { accountNumberValidator.isValidAccountNumberString(inputAccountNumber) } returns true
        every { luhnSumCalculator.calculatorLuhnSumFromIntegerList(any()) } returns 71

        accountValidator.validate(inputAccountNumber).map { Assertions.assertFalse(it) }
    }

    @Test
    fun `when given invalid account number string validate will return exception when injected dependencies evaluate correctly`(){
        val inputAccountNumber = "5992fg98716"

        every { accountNumberValidator.isValidAccountNumberString(inputAccountNumber) } returns false

        val expectedException = InputMismatchException("Input string: $inputAccountNumber is not a valid account number")

        accountValidator.validate(inputAccountNumber).mapLeft { Assertions.assertEquals(expectedException.message, it.message) }
    }
}