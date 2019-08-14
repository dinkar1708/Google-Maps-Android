package com.google.maps.android

import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng

import java.lang.reflect.Array
import java.util.ArrayList

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
                val first = LatLng(28.6164, 77.3725)
                val second = LatLng(28.5672, 77.3261)
                val third = LatLng(28.4649, 77.5113)
                val fourth = LatLng(28.5665, 77.3406)


                val bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.marker)
                val bitmapDescriptor2 = BitmapDescriptorFactory.fromResource(R.mipmap.marker2)

                val title = "Fortis Hospital, Noida, Uttar Pradesh, India"
                val title2 = "The Great India Place Mall, Noida, Uttar Pradesh, India"
                val title3 = "Pari Chowk, NRI City, Greater Noida, Uttar Pradesh 201310, India"
                val title4 = "Arun Vihar, Sector 37, Noida, Uttar Pradesh 201303, India"

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
