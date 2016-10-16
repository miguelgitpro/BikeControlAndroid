package com.jrivera.bikecontrolandroid.fragments;


import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.Firebase;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.jrivera.bikecontrolandroid.R;


public class FirstMapFragment extends SupportMapFragment implements OnMapReadyCallback {
    private static final String ARG_POSITION = "position";

    private int position;
    GoogleMap mMap;
    public static FirstMapFragment newInstance(int position) {
        FirstMapFragment f = new FirstMapFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        Firebase.setAndroidContext(getContext());
        getMapAsync(this);
        return root;
    }

    @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            miUbicacion(googleMap);
        }
    public void  actualizarUbicacionActual(Location location) {
        final Firebase myFirebaseRef = new Firebase("https://bike-control-c8904.firebaseio.com/");

        if (location != null) {
            double lat = location.getLatitude();
            double lon = location.getLongitude();
            System.out.println(lat+" "+lon);
            myFirebaseRef.child("BikeControl").child("Bike-02").child("Position").child("Lat").setValue(lat);
            myFirebaseRef.child("BikeControl").child("Bike-02").child("Position").child("Lon").setValue(lon);


        }

    }
        android.location.LocationListener locationListener = new android.location.LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                actualizarUbicacionActual(location);
                double lat = location.getLatitude();
                double lon = location.getLongitude();

                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(new LatLng(lat,lon))
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_bike)).draggable(true));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        private void miUbicacion(GoogleMap googleMap){
                LocationManager locationManager= (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
                Location location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
            actualizarUbicacionActual(location);

            mMap = googleMap;
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
            new LatLng(location.getLatitude(),location.getLongitude()), 18));
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,10000000,0,locationListener);
        }

    }
