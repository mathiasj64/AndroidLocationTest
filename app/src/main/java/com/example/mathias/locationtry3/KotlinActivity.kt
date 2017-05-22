package com.example.mathias.locationtry3

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.location.Location
import android.location.LocationManager

class KotlinActivity : Activity() {

    //private var locationManager: LocationManager? = null

    var locationManager: LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //laver locationManager
        //locationManager = getSystemService(Context.LOCATION_SERVICE) as locationManager

        //Tjekker og requester adgang til location service
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //Hvis FINE og COARSE adgang ikke er givet bliver det requested. Hvis man får adgang bliver configureButton metoden kørt, som sætter en onClickListener på knappen.
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //Requester adgang fra brugeren
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET), 10)
                //Dette kalder onRequestPermissionResult
                return
            }
        } else {
            configureButton()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
        //Case 10 er en kombination af permission requests.
            10 -> {
                //Hvis der er givet adgang kører vi configureButton som giver knappen en onClickListener.
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    configureButton()
                return
            }
        }
    }

    private fun configureButton() {
        buttonOnce.setOnClickListener {
            //På klik køres metoden der printer lokation ud
            getLocationOnce()
        }
    }


    private fun getLocationOnce() {

        if (locationManager == null) {
            locationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        }

        if (locationManager!!.getLastKnownLocation("gps") == null) {
            val loc = locationManager!!.getLastKnownLocation("network")
            textViewOnce.text = (loc.longitude.toString() + ". " + loc.latitude + loc.provider).toString()
        } else {

            val loc2 = locationManager!!.getLastKnownLocation("gps")
            textViewOnce.text = (loc2.longitude.toString() + ". " + loc2.latitude + loc2.provider).toString()
        }

    }
}
