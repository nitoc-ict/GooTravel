package com.ict.mito.gootravel.csv

import android.content.res.AssetManager
import com.ict.mito.gootravel.spot.model.SpotData
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.util.StringTokenizer
import kotlin.collections.ArrayList

/**
 * Created by mitohato14 on 2019-09-09.
 */
class CSVReader(private val assets: AssetManager) {
    fun getSpotDataList(): List<SpotData> {
        val arrayList: ArrayList<SpotData> = arrayListOf()
        try {
            val inputStream = assets.open("spotdata.csv")

            val inputStreamReader = InputStreamReader(inputStream)
            val bufferReader = BufferedReader(inputStreamReader as Reader?)

            var id = 1L
            while (true) {
                val line = bufferReader.readLine() ?: break
                val stringTokenizer = StringTokenizer(
                    line,
                    ","
                )

                if (stringTokenizer.countTokens() == 0) break

                val name = stringTokenizer.nextToken()
                val address = stringTokenizer.nextToken()
                val latitude = stringTokenizer.nextToken()
                val longitude = stringTokenizer.nextToken()

                if (
                    name != null &&
                    address != null &&
                    latitude.isNotEmpty() &&
                    longitude.isNotEmpty()
                ) {
                    val spotData = SpotData(
                        name = name,
                        address = address,
                        latitude = latitude.toDouble(),
                        longitude = longitude.toDouble(),
                        spotType = 0,
                        spotTypeDetail = ""
                    )
                    spotData.id = id
                    id++
                    arrayList.add(spotData)
                }
            }
            bufferReader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return arrayList.toList()
    }
}
