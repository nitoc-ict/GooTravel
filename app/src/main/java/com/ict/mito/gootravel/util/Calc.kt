package com.ict.mito.gootravel.util

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.location.Location
import com.ict.mito.gootravel.R

/**
 * Created by mitohato14 on 2019-07-28.
 */

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

fun rotateImage(
    resources: Resources,
    angle: Double
): Bitmap {
    val image = BitmapFactory.decodeResource(
        resources,
        R.drawable.arrow
    )
    val matrix = Matrix()
    matrix.setRotate(
        angle.toFloat(),
        image.width / 2f,
        image.height / 4f
    )
    return Bitmap.createBitmap(
        image,
        0,
        0,
        image.width,
        image.height,
        matrix,
        true
    )
}

fun rad2deg(rad: Float): Float {
    return (rad * 180.0f / Math.PI).toFloat()
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
