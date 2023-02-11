package com.neelesh.luhn

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream





class MainAcceptanceTest {

    var baos: ByteArrayOutputStream = ByteArrayOutputStream()
    var ps: PrintStream = PrintStream(baos)
    var old = System.out

    @BeforeEach
    fun setup(){
        System.setOut(ps)
    }

    @AfterEach
    fun tearDown(){
        System.out.flush()
        System.setOut(old)
        baos.reset()
    }

    @Test
    fun `when given no command line arguments luhn account validator will use default string to run`(){
        main(emptyArray())

        Assertions.assertEquals("Input string:  is not a valid account number", baos.toString())
    }

    @Test
    fun `when given valid account as command line arguments luhn account validator will use default string to run`(){
        main(arrayOf("49927398716"))

        Assertions.assertEquals("true", baos.toString())
    }

    @Test
    fun `when given invalid account as command line arguments luhn account validator will use default string to run`(){
        main(arrayOf("59927398716"))

        Assertions.assertEquals("false", baos.toString())
    }

    @Test
    fun `when given invalid account string luhn account validator will print exception message`(){
        val accountString = "78df8sdf"
        main(arrayOf(accountString))

        Assertions.assertEquals("Input string: $accountString is not a valid account number", baos.toString())
    }

    @Test
    fun `when given empty string luhn account validator will print exception message`(){
        val accountString = ""
        main(arrayOf(accountString))

        Assertions.assertEquals("Input string: $accountString is not a valid account number", baos.toString())
    }



}