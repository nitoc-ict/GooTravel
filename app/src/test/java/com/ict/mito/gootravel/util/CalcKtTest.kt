package com.ict.mito.gootravel.util

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by mitohato14 on 2019-09-16.
 */
class CalcKtTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun calcDirectDistance() {
    }

    @Test
    fun calcDirection() {
    }

    @Test
    fun rad2deg() {
        val actual1 = rad2deg(1f)
        assertEquals(
            57.29578f,
            actual1
        )
        val actual2 = rad2deg(0f)
        assertEquals(
            0f,
            actual2
        )
        val actual3 = rad2deg(2f)
        assertEquals(
            114.59156f,
            actual3
        )
        val actual4 = rad2deg(-1f)
        assertEquals(
            -57.29578f,
            actual4
        )
    }

    @Test
    fun normalizeRange() {
    }
}