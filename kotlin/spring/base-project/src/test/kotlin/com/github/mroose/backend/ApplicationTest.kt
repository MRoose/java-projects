package com.github.mroose.backend

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class ApplicationTest {

    @Test
    fun testHelloWorld() {
        val actual = "Hello World"
        val expected = "Hello World"
        assertThat(actual).isEqualTo(expected)
    }
}