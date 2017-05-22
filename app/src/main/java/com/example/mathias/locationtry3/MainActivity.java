package com.example.mathias.locationtry3;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
/*
    private TextView textViewOnce;
    private LocationManager locationManager;
    private Button buttonOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Henter ting fra View
        buttonOnce = (Button) findViewById(R.id.buttonOnce);
        textViewOnce = (TextView) findViewById(R.id.textViewOnce);

        //laver locationManager
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        //Tjekker og requester adgang til location service
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //Hvis FINE og COARSE adgang ikke er givet bliver det requested. Hvis man får adgang bliver configureButton metoden kørt, som sætter en onClickListener på knappen.
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //Requester adgang fra brugeren
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET
                }, 10);
                //Dette kalder onRequestPermissionResult
                return;
            }
        } else {
            configureButton();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            //Case 10 er en kombination af permission requests.
            case 10:
                //Hvis der er givet adgang kører vi configureButton som giver knappen en onClickListener.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    configureButton();
                return;
        }
    }

    private void configureButton() {
        buttonOnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //På klik køres metoden der printer lokation ud
                getLocationOnce();
            }
        });
    }

    private void getLocationOnce() {

        if (locationManager.getLastKnownLocation("gps") == null) {
            Location loc = locationManager.getLastKnownLocation("network");
            textViewOnce.setText(String.valueOf(loc.getLongitude() + ". " + loc.getLatitude() + loc.getProvider()));
        } else {

            Location loc2 = locationManager.getLastKnownLocation("gps");
            textViewOnce.setText(String.valueOf(loc2.getLongitude() + ". " + loc2.getLatitude() + loc2.getProvider()));
        }

    }*/
}
