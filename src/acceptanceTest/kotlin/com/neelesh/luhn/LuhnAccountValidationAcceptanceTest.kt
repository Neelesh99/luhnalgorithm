package com.neelesh.luhn

import com.neelesh.luhn.calculation.StandardAccountNumberValidator
import com.neelesh.luhn.calculation.StandardLuhnAccountValidator
import com.neelesh.luhn.calculation.StandardLuhnSumCalculator
import com.neelesh.luhn.calculation.StandardLuhnSumValidationFunction
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail

class LuhnAccountValidationAcceptanceTest {

    val validator = StandardLuhnAccountValidator(StandardAccountNumberValidator, StandardLuhnSumCalculator, StandardLuhnSumValidationFunction::validate)

    @Test
    fun `when given valid account number as a string validate will return true in an either`(){
        val validAccountNumberAsString = "49927398716"

        validator.validate(validAccountNumberAsString).fold(
            {
                fail("Expected no exception: ${it.message}")
            },
            {
                Assertions.assertTrue(it)
            }
        )
    }

    @Test
    fun `when given invalid account number as a string validate will return false in an either`(){
        val invalidAccountNumberAsString = "59927398716"

        validator.validate(invalidAccountNumberAsString).fold(
            {
                fail("Expected no exception: ${it.message}")
            },
            {
                Assertions.assertFalse(it)
            }
        )
    }

    @Test
    fun `when given an invalid account number string validate will return Exception`(){
        val invalidAccountNumberString = "5fgh27398716"

        validator.validate(invalidAccountNumberString).fold(
            {
                Assertions.assertEquals("Input string: $invalidAccountNumberString is not a valid account number", it.message)
            },
            {
                fail("Expected an exception")
            }
        )
    }

    @Test
    fun `when given an empty account number string validate will return Exception`(){
        val invalidAccountNumberString = ""

        validator.validate(invalidAccountNumberString).fold(
            {
                Assertions.assertEquals("Input string: $invalidAccountNumberString is not a valid account number", it.message)
            },
            {
                fail("Expected an exception")
            }
        )
    }

}