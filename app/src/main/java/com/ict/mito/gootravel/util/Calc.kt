package com.ict.mito.gootravel.util

import kotlin.math.*

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
        val P: Double = (ax + bx) / 2.0
        val W: Double = sqrt(1 - ((E * E) * (sin(P) * sin(P))))
        val M: Double = (Rx * (1 - (E * E))) / (W * W * W)
        val N: Double = Rx / W
        val dx = abs(max(ax, bx) - min(ax, bx))
        val dy = abs(max(ay, by) - min(ay, by))
        val D = sqrt((dy * M) * (dy * M) + (dx * N * cos(P)) * (dx * N * cos(P)))
//
        return D
//        return (sqrt(dx * dx + dy * dy) * 100)
    }
    companion object {
        private const val Rx: Double = 6_378_137.000
        private const val Ry: Double = 6_356_752.314_245
        private val E: Double = sqrt(((Rx * Rx) - (Ry * Ry)) / (Rx * Rx))
    }
}