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

    public menu_NewsMapFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu__news_map, container, false);
        //txtCountry = (TextView) findViewById(R.id.txtCountry);

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
                Log.d("Info System:",String.valueOf(location.getLatitude())+ String.valueOf(location.getLongitude()));

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
                    //latitude = (double) location.getLatitude();
                    //longitude = (double) location.getLongitude();

                    addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                    String address = addresses.get(0).getAddressLine(0);
                    String area = addresses.get(0).getLocality();
                    String city = addresses.get(0).getAdminArea();
                    String country = addresses.get(0).getCountryName();

                    Log.d("System Info:","long " + location.getLongitude() +"\n"+ "lat " + location.getLatitude() + "\n" + "country: " + country);


                } catch (IOException e) {
                    e.printStackTrace();
                }






        return view;
    }

}
