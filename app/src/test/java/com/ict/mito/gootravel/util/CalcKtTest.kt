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
        assertEquals(
            180f,
            normalizeRange(180.0).toFloat()
        )
        assertEquals(
            0f,
            normalizeRange(0.0).toFloat()
        )
        assertEquals(
            0f,
            normalizeRange(360.0).toFloat()
        )
        assertEquals(
            60f,
            normalizeRange(420.0).toFloat()
        )
        assertEquals(
            0f,
            normalizeRange(720.0).toFloat()
        )
        assertEquals(
            -60f,
            normalizeRange(-60.0).toFloat()
        )
        assertEquals(
            -60f,
            normalizeRange(-420.0).toFloat()
        )
        assertEquals(
            -0f,
            normalizeRange(-720.0).toFloat()
        )
        assertEquals(
            60.462f,
            normalizeRange(420.462).toFloat()
        )
        assertEquals(
            -80.234f,
            normalizeRange(-440.234).toFloat()
        )
    }
}