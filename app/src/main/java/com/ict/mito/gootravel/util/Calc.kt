package com.ict.mito.gootravel.util

import android.location.Location
import com.ict.mito.gootravel.spot.model.SpotData

/**
 * Created by mitohato14 on 2019-07-28.
 */

fun calcDirection(
    destinationSpot: SpotData,
    location: Location
) {
    calcDirection(
        destinationSpot.longitude,
        destinationSpot.latitude,
        location.longitude,
        location.latitude
    )
}

fun calcDirectDistance(
    destinationSpot: SpotData,
    location: Location
) {
    calcDirectDistance(
        destinationSpot.longitude,
        destinationSpot.latitude,
        location.longitude,
        location.latitude
    )
}

fun calcDirectDistance(
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
    return results[0].toDouble()
}

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

    return results[1].toDouble()
}

fun rad2deg(rad: Float): Float {
    return (rad * 180.0f / Math.PI).toFloat()
}

fun deg2rad(deg: Float): Float {
    return deg * (Math.PI / 180f).toFloat()
}

fun normalizeRange(angle: Float): Float {
    val f = angle / 360f
    val i = if (f >= 0.0f) {
        f.toInt()
    } else {
        f.toInt() - 1
    }

    return (f - i.toFloat()) * 360f
}
