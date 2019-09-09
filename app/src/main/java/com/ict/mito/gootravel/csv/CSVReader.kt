package com.ict.mito.gootravel.csv

import com.ict.mito.gootravel.spot.model.SpotData
import io.reactivex.Single
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.util.*

/**
 * Created by mitohato14 on 2019-09-09.
 */
class CSVReader {
    fun getSpotDataList(): Single<List<SpotData>> = Single.create {
        var arrayList: ArrayList<SpotData> = arrayListOf()
        val inputStream =

        val inputStreamReader = InputStreamReader(inputStream)
        val bufferReader = BufferedReader(inputStreamReader as Reader?)

        while (true) {
            val line = bufferReader.readLine()
            val stringTokenizer = StringTokenizer(
                line,
                ","
            )

            if (line == "") break

            val id = stringTokenizer.nextToken().toLong()
            val spotData = SpotData(
                latitude = stringTokenizer.nextToken().toDouble(),
                longitude = stringTokenizer.nextToken().toDouble(),
                name = stringTokenizer.nextToken(),
                spotType = stringTokenizer.nextToken().toInt(),
                spotTypeDetail = stringTokenizer.nextToken()
            )
            spotData.id = id
            arrayList.add(spotData)
        }
        arrayList.toList()
    }
}