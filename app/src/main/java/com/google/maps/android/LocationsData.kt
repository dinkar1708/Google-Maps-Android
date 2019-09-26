package com.google.maps.android

import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import java.util.*

/**
 * Created by dinakar.maurya on 23-01-2018.
 */

class LocationsData {
    lateinit var location: LatLng
    lateinit var bitmapDescriptor: BitmapDescriptor
    lateinit var title: String

    companion object {

        /**
         * getting hard coded data, data source can be anything ie. network, db etc.
         *
         * @return
         */
        //hard coded data, can be change dynamically
        val data: ArrayList<LocationsData>
            get() {
                val first = LatLng(35.011665, 135.768326)
                val second = LatLng(34.689999, 135.195557)
                val third = LatLng(33.583332, 130.399994)
                val fourth = LatLng(34.383331, 132.449997)


                val bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.marker)
                val bitmapDescriptor2 = BitmapDescriptorFactory.fromResource(R.mipmap.marker2)

                val title = "Kyoto, Kyoto Prefecture"
                val title2 = "Kobe, Hyogo"
                val title3 = "Fukuoka, Fukuoka"
                val title4 = "Hiroshima, Hirosima Prefecture"

                val datas = ArrayList<LocationsData>()

                var data = LocationsData()
                data.location = first
                data.bitmapDescriptor = bitmapDescriptor
                data.title = title
                datas.add(data)

                data = LocationsData()
                data.location = second
                data.bitmapDescriptor = bitmapDescriptor2
                data.title = title2
                datas.add(data)

                data = LocationsData()
                data.location = third
                data.bitmapDescriptor = bitmapDescriptor2
                data.title = title3
                datas.add(data)

                data = LocationsData()
                data.location = fourth
                data.bitmapDescriptor = bitmapDescriptor
                data.title = title4
                datas.add(data)

                return datas
            }
    }
}
