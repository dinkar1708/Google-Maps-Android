package com.google.maps.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LocationComponentActivity : AppCompatActivity() {

    private lateinit var realLocationComponent: RealLocationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_component)

        realLocationComponent = RealLocationComponent(this)
        realLocationComponent.onCreate()
    }

    override fun onPause() {
        realLocationComponent.stopLocationUpdates()
        super.onPause()
    }

    override fun onResume() {
        realLocationComponent.onResume()
        super.onResume()
    }
}
