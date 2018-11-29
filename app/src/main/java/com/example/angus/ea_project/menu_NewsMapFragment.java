package com.example.angus.ea_project;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class menu_NewsMapFragment extends Fragment {

    //private TextView txtCountry;
    Geocoder geocoder;
    List<Address> addresses;
    private LocationManager locationManager;
    private String provider;
    private Criteria criteria;
    private LocationListener locationListener;
    private TextView txtcountry;
    String blank = ""; //for attach in log.d, useless in program.


    public menu_NewsMapFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu__news_map, container, false);
        txtcountry = (TextView) view.findViewById(R.id.country);

        geocoder = new Geocoder(getActivity(), Locale.getDefault());
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();

        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setCostAllowed(false);
        provider = locationManager.getBestProvider(criteria, false);


        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return view;
        }
        final Location location = locationManager.getLastKnownLocation(provider);
        locationListener = new LocationListener() {
            String status;

            @Override
            public void onLocationChanged(Location location) {
                Log.d("Info System:", String.valueOf(location.getLatitude()) + String.valueOf(location.getLongitude()));

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

                //Toast.makeText(MainActivity.this, provider + "'s status changed to "+ status +"!",
                //Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProviderEnabled(String s) {
                //Toast.makeText(MainActivity.this, "Provider " + provider + " enabled!",
                //Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onProviderDisabled(String s) {
                //Toast.makeText(MainActivity.this, "Provider " + provider + " disabled!",
                //Toast.LENGTH_SHORT).show();

            }
        };


        try {
            double latitude = 0;
            latitude = location.getLatitude();
            double longitude = 0;
            longitude = location.getLongitude();
            String log = "Latitude : " + latitude + "  " + "Longtitude: " + longitude;
            Log.d("GPS Log String: ", String.valueOf(log));

            if (latitude != 0 && longitude != 0) {
                //Fetch user location from GPS
                addresses = geocoder.getFromLocation(latitude, longitude, 1);
            } else {
                //If failed, set GPS LongLat to Hong Kong (22.3964N, 114.1095E)
                latitude = 22.3964;
                longitude = 114.1095;
                addresses = geocoder.getFromLocation(latitude, longitude, 1);
            }

            // The below string is used to get different details from the Geocoder API.

            // String address = addresses.get(0).getAddressLine(0);
            // String area = addresses.get(0).getLocality();
            // String city = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();


            Log.d("System Info:", "long " + location.getLongitude() + "\n" + "lat " + location.getLatitude() + "\n" + "country: " + country);



            String[] isoCountryCodes = Locale.getISOCountries(); //Get all countries with country code.
            String countryCode = "";
            String countryName = country;


            for (String code : isoCountryCodes) {
                // To iterate through all country codes, we use for-loop
                // This for-loop is to fetch all country and country codes from Locale API.
                // Create a locale using each country code
                Locale locale = new Locale("", code);
                // Get country name for each code.
                String name = locale.getDisplayCountry();

                if (name.equals(countryName)) {
                    // if-statement: to compare Locale API and GeoCoder country name match or not.
                    // If there is same country name, fetch the country code and save to local variable countryCode.
                    countryCode = code;

                    //Log Country Code Information
                    Log.d("Country Code Info ", blank);
                    Log.d("Country ", countryName);
                    Log.d("Country Code ", countryCode);

                    //Set the textview in news map fragment to display country code
                    txtcountry.setText("Country Code : \n" + countryCode);
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();


            return view;
        }


        return view;
    }
}