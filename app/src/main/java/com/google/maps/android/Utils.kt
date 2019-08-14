package com.google.maps.android

import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.nfc.Tag
import android.util.Log

/**
 * Created by dinakar.maurya on 23-01-2018.
 */

object Utils {

    private val TAG = Utils::class.java.simpleName

    /**
     * from google developers android console
     *
     * @param context
     * @return
     */
    fun isConnectedToInternet(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnected
        Log.i(TAG, " isConnectedToInternet $isConnected")
        return isConnected
    }

    /**
     * check if location services is enabled
     *
     * @param context
     * @return
     */
    fun isLocationServiceEnabled(context: Context): Boolean {
        var isGpsEnabled = false
        var isNetworkProviderEnabled = false

        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        try {
            isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            Log.i(TAG, " gps enabled - $isGpsEnabled")
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        try {
            isNetworkProviderEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            Log.i(TAG, " network enabled - $isNetworkProviderEnabled")

        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return isGpsEnabled || isNetworkProviderEnabled

    }
}
