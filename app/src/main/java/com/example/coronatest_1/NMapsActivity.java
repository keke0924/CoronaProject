package com.example.coronatest_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.MapView;
import com.naver.maps.map.OnMapReadyCallback;


public class NMapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;
    private static NaverMap naverMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_maps);

        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady( NaverMap naverMap) {

        this.naverMap = naverMap;
        // Add a marker in Sydney and move the camera
        //LatLng location = new LatLng(37.487936, 126.825071);
        //mMap.addMarker(new MarkerOptions().position(location).title("쌍용역"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 7));
        CameraPosition cameraPosition = new CameraPosition(
                new LatLng(36.79379851270565, 127.12149128900404),  // 위치 지정
                5.6                           // 줌 레벨
        );
        naverMap.setCameraPosition(cameraPosition);

    }
}