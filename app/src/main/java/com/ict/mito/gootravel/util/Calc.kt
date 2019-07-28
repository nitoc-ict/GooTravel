package com.ict.mito.gootravel.util

import android.location.Location

/**
 * Created by mitohato14 on 2019-07-28.
 */

fun calcDirection(
    ax: Double,
    ay: Double,
    bx: Double,
    by: Double
): Double {
    val results = FloatArray(3)
    Location.distanceBetween(
        ax,
        ay,
        bx,
        by,
        results
    )
    return results[2].toDouble()
}

