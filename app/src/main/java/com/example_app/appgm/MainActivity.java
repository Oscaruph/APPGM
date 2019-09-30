package com.example_app.appgm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public  class MainActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener{
    private GoogleMap mMap;
    private LatLng sitios[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitGoogleMaps();
    }
    private void InitGoogleMaps(){
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng MexicoCity = new LatLng(19.432241, -99.177254);
        mMap.addMarker(new MarkerOptions().position(MexicoCity).title("Ciudad de Mexico"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MexicoCity));
        initMarkers();
    }

    private void initMarkers(){
        int numero_sitios = 8;
        this.sitios = new LatLng[numero_sitios];
        this.sitios[0] = new LatLng(19.432241, -99.177254);
        this.sitios[1] = new LatLng(51.507351,-0.127758);
        this.sitios[2] = new LatLng(48.856613,2.352222);
        this.sitios[3] = new LatLng(38.889931,-77.009003);
        this.sitios[4] = new LatLng(-15.77972,-47.92972);
        this.sitios[5] = new LatLng(50.85045,4.34878);
        this.sitios[6] = new LatLng(55.751244,37.618423);
        this.sitios[7] = new LatLng(30.044281,31.340002);
        mMap.addMarker(new MarkerOptions().position(sitios[0]).title(getString(R.string.ButtonUno)));
        mMap.addMarker(new MarkerOptions().position(sitios[1]).title(getString(R.string.ButtonDos)));
        mMap.addMarker(new MarkerOptions().position(sitios[2]).title(getString(R.string.ButtonTres)));
        mMap.addMarker(new MarkerOptions().position(sitios[3]).title(getString(R.string.ButtonCuatro)));
        mMap.addMarker(new MarkerOptions().position(sitios[4]).title(getString(R.string.ButtonCinco)));
        mMap.addMarker(new MarkerOptions().position(sitios[5]).title(getString(R.string.ButtonSeis)));
        mMap.addMarker(new MarkerOptions().position(sitios[6]).title(getString(R.string.ButtonSiete)));
        mMap.addMarker(new MarkerOptions().position(sitios[7]).title(getString(R.string.ButtonOcho)));
    }


    private void moveCameraToPosition(LatLng newPosition){
        // Zoom in, animating the camera
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        // Zoom out to zoom level 10, animating with a duration of 2 seconds
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000,null);
        // Construct a CameraPosition focusing on Mountain View and  animate the camera to that position
        CameraPosition cameraPosition = new CameraPosition.Builder()
        .target(newPosition)
        .zoom(14)
        .bearing(90)
        .tilt(30)
        .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    public void onClick(View v){
        moveCameraToPosition(sitios[Integer.valueOf(v.getTag().toString())]);
    }






}

