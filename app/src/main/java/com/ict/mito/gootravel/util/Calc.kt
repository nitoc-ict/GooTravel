package com.ict.mito.gootravel.util

import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Created by mitohato14 on 2019-07-28.
 */
class Calc {

    fun directDistance(
        ax: Double,
        ay: Double,
        bx: Double,
        by: Double
    ): Double {
        val P: Double = (ax + ay) / 2.0
        val W: Double = sqrt(1 - (E * E) * (sin(P) * sin(P)))
        val M: Double = (Rx * (1 - (E * E))) / (W * W * W)
        val N: Double = Rx / M
        val dx = abs(ax - bx)
        val dy = abs(ay - by)
        val D = sqrt((dy * M) * (dy * M) + (dx * N * cos(P)) * (dx * N * cos(P)))

        return D
    }
    companion object {
        private const val Rx: Double = 6_378_137.000
        private const val Ry: Double = 6_356_752.314_245
        private val E: Double = sqrt(((Rx * Rx) - (Ry * Ry)) / (Rx * Rx))
    }
}