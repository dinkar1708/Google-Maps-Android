package com.google.maps.android

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import android.util.Log
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

import java.util.ArrayList

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)

        if (!Utils.isConnectedToInternet(this)) {
            Toast.makeText(this, "Please connect to internet!", Toast.LENGTH_LONG).show()
        }

        if (!Utils.isLocationServiceEnabled(this)) {
            Toast.makeText(this, "Please enable location services!", Toast.LENGTH_LONG).show()
        }
        val permissionGranted = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

        if (permissionGranted) {
            Log.i(TAG, "permissionGranted fine location")
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), ACCESS_FINE_LOCATION_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            ACCESS_FINE_LOCATION_CODE -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "onRequestPermissionsResult fine location granted now...")
                }
            }
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap

        //        drawSimpleLocation();
        drawMultipleLocation()
    }

    /**
     * from google api
     */
    private fun drawSimpleLocation() {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        val sydney = LatLng(-33.852, 151.211)
        googleMap?.addMarker(MarkerOptions().position(sydney)
                .title("Marker in Sydney"))
        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    private fun drawMultipleLocation() {

        googleMap?.setOnMapLoadedCallback {
            // Create bounds that include all locations of the map
            val boundsBuilder = LatLngBounds.builder()
            val builder = LatLngBounds.Builder()

            val locationsDatas = LocationsData.data
            for (data in locationsDatas) {
                val marker = MarkerOptions().position(data.location).title(data.title)
                marker.icon(data.bitmapDescriptor)
                googleMap!!.addMarker(marker)
                //
                builder.include(data.location)
            }
            val bounds = builder.build()
            val padding = 150
            //  Returns a CameraUpdate that transforms the camera such that the specified latitude/longitude
            // bounds are centered on screen at the greatest possible zoom level.
            val cu = CameraUpdateFactory.newLatLngBounds(bounds, padding)
            googleMap?.moveCamera(cu)
            val durationMs = 3 * 1000
            // Moves the map according to the update with an animation over a specified duration,
            // and calls an optional callback on completion
            googleMap?.animateCamera(CameraUpdateFactory.zoomTo(10f), durationMs, null)
        }

    }

    companion object {

        private const val ACCESS_FINE_LOCATION_CODE = 120
        private val TAG = MapsActivity::class.java.simpleName
    }

}
