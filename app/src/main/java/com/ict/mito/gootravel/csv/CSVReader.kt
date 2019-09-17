package com.ict.mito.gootravel.csv

import android.content.Context
import com.ict.mito.gootravel.spot.model.SpotData
import io.reactivex.Single
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.util.*

/**
 * Created by mitohato14 on 2019-09-09.
 */
class CSVReader(private val context: Context) {
    fun getSpotDataList(): Single<List<SpotData>> = Single.create {
        val arrayList: ArrayList<SpotData> = arrayListOf()
        try {
            val inputStream = context.resources.assets.open("test.csv")

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

                val spotData = SpotData(
                    name = stringTokenizer.nextToken(),
                    address = stringTokenizer.nextToken(),
                    latitude = stringTokenizer.nextToken().toDouble(),
                    longitude = stringTokenizer.nextToken().toDouble(),
                    spotType = 0,
                    spotTypeDetail = ""
                )
                spotData.id = id
                id++
                arrayList.add(spotData)
            }
            bufferReader.close()
            it.onSuccess(arrayList.toList())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
