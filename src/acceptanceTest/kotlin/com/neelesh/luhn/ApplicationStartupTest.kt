package com.neelesh.luhn

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationStartupTest {

    @Test
    fun `application will not throw exception on startup with no parameters`(){
        Assertions.assertDoesNotThrow{ main(emptyArray()) }
    }
}