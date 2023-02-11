package com.neelesh.luhn.calculation

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class StandardLuhnAccountValidatorTest {

    val accountNumberValidator = mockk<AccountNumberValidator>()
    val luhnSumCalculator = mockk<LuhnSumCalculator>()
    val accountValidator = StandardLuhnAccountValidator(accountNumberValidator, luhnSumCalculator)

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
}