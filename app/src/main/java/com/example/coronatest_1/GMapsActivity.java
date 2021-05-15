package com.example.coronatest_1;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng location = new LatLng(36.793875837165665, 127.12144837365759);

        mMap.addMarker(new MarkerOptions().position(location).title("쌍용역"));

        LatLng location2 = new LatLng(37.55609637360114, 126.97225807999249);
        mMap.addMarker(new MarkerOptions().position(location2).title("서울역"));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 7));
        googleMap.setOnInfoWindowClickListener(infoWindowClickListener);
        googleMap.setOnInfoWindowClickListener(infoWindowClickListener2);


    }

    GoogleMap.OnInfoWindowClickListener infoWindowClickListener = new GoogleMap.OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {
            Intent intent1 = new Intent(GMapsActivity.this, Seoul.class);
            startActivity(intent1);
        }
    };

    GoogleMap.OnInfoWindowClickListener infoWindowClickListener2 = new GoogleMap.OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {
            Intent intent2 = new Intent(GMapsActivity.this, Seoul.class);
            startActivity(intent2);
        }
    };

}