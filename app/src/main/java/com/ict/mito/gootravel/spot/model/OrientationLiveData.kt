package com.ict.mito.gootravel.spot.model

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.LiveData

/**
 * Created by mitohato14 on 2019-07-31.
 */
class OrientationLiveData(
    context: Context
) : LiveData<OrientationData>() {
    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
    private val magnetometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),

    private var accelerometerReadingArray = FloatArray(3)
    private var magnetometerReadingArray = FloatArray(3)

    private val orientationAngles = FloatArray(3)

    private val sensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(
            sensor: Sensor?,
            accuracy: Int
        ) {
        }

        override fun onSensorChanged(event: SensorEvent?) {
            when (event?.sensor?.type) {
                Sensor.TYPE_ACCELEROMETER -> accelerometerReadingArray = event.values.clone()
                Sensor.TYPE_MAGNETIC_FIELD -> magnetometerReadingArray = event.values.clone()
            }

            updateOrientationAngles()
            value = OrientationData(
                orientationAngles[0],
                orientationAngles[1],
                orientationAngles[2]
            )
        }
    }

    override fun onActive() {
        super.onActive()

        sensorManager.registerListener(
            sensorEventListener,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL,
            SensorManager.SENSOR_DELAY_UI
        )
        sensorManager.registerListener(
            sensorEventListener,
            sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
            SensorManager.SENSOR_DELAY_NORMAL,
            SensorManager.SENSOR_DELAY_UI
        )
    }

    override fun onInactive() {
        super.onInactive()
        sensorManager.unregisterListener(sensorEventListener)
    }

    private fun updateOrientationAngles() {
        val rotationMatrix = FloatArray(9)
        SensorManager.getRotationMatrix(
            rotationMatrix,
            null,
            accelerometerReadingArray,
            magnetometerReadingArray
        )
        val remapCoordinateArray = FloatArray(9)
        SensorManager.remapCoordinateSystem(
            rotationMatrix,
            SensorManager.AXIS_X,
            SensorManager.AXIS_Y,
            remapCoordinateArray
        )
        SensorManager.getOrientation(
            remapCoordinateArray,
            orientationAngles
        )
    }
}
