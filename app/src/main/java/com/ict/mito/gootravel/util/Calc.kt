package com.ict.mito.gootravel.util

import android.location.Location
import com.ict.mito.gootravel.spot.model.SpotData
import kotlin.math.abs
import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

/**
 * Created by mitohato14 on 2019-07-28.
 */

fun calcDirection(
    destinationSpot: SpotData?,
    location: Location?
): Double = calcDirection(
    destinationSpot?.longitude ?: 0.0,
    destinationSpot?.latitude ?: 0.0,
    location?.longitude ?: 0.0,
    location?.latitude ?: 0.0
)

fun calcDirectDistance(
    destinationSpot: SpotData?,
    location: Location?
): Double = calcDirectDistance(
    destinationSpot?.longitude ?: 0.0,
    destinationSpot?.latitude ?: 0.0,
    location?.longitude ?: 0.0,
    location?.latitude ?: 0.0
)

fun calcDirectDistance(
    ax: Double,
    ay: Double,
    bx: Double,
    by: Double
): Double {
    val x1 = deg2rad(ax)
    val x2 = deg2rad(bx)
    val y1 = deg2rad(ay)
    val y2 = deg2rad(by)

    val dx = abs(x1 - x2)
    val dy = abs(y1 - y2)

    val p = (y1 + y2) / 2.0
    val rx = SEMIMAJOR_AXIS
    val ry = SEMIMINOR_AXIS
    val e = sqrt((rx * rx - ry * ry) / (rx * rx))
    val w = sqrt(1 - e * e * (sin(p) * sin(p)))
    val m = (rx * (1 - e * e)) / (w * w * w)
    val n = rx / w

    return sqrt((dy * m) * (dy * m) + (dx * n * cos(p)) * (dx * n * cos(p)))
}

fun calcDirection(
    ax: Double,
    ay: Double,
    bx: Double,
    by: Double
): Double {
    return (90 - atan(2 * ((sin(ax - bx)) / (cos(by) * tan(ay) - sin(by) * cos(ax - bx)))))
}

fun rad2deg(rad: Double): Double {
    return (rad * 180.0f / Math.PI)
}

fun deg2rad(deg: Double): Double {
    return deg * (Math.PI / 180f)
}

fun normalizeRange(angle: Double): Double {
    return angle % 360.0
}
