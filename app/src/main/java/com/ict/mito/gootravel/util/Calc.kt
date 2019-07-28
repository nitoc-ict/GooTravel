package com.ict.mito.gootravel.util

import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

/**
 * Created by mitohato14 on 2019-07-28.
 */
class Calc {

    fun direction(
        ax: Double,
        ay: Double,
        bx: Double,
        by: Double
    ): Double {
        return (90 - atan(2 * ((sin((bx - ax))) / (cos(ay) * tan(by) - sin((ay) * cos(bx - ax))))))
    }

}