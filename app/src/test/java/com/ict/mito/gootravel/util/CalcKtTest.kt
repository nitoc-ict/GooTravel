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
        assertEquals(
            57.29578f,
            rad2deg(1f)
        )
        assertEquals(
            0f,
            rad2deg(0f)
        )
        assertEquals(
            114.59156f,
            rad2deg(2f)
        )
        assertEquals(
            -57.29578f,
            rad2deg(-1f)
        )
        assertEquals(
            85.94367f,
            rad2deg(1.5f)
        )
        assertEquals(
            -85.94367f,
            rad2deg(-1.5f)
        )
        assertEquals(
            13178.029f,
            rad2deg(230f)
        )
    }

    @Test
    fun normalizeRange() {
    }
}