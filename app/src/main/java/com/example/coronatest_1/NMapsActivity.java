package com.example.coronatest_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

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
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;


public class NMapsActivity extends AppCompatActivity implements OnMapReadyCallback, OnClickListener {
    private MapView mapView;
    private static NaverMap naverMap;
    private InfoWindow infoWindow;
    Button btn_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_maps);

        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        btn_now= (Button)findViewById(R.id.now);
        btn_now.setOnClickListener(this);
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
        //Marker marker = new Marker();
        //marker.setPosition(new LatLng(36.79379851270565,127.12149128900404));
        //marker.setMap(naverMap);

        infoWindow = new InfoWindow();
        infoWindow.setAdapter(new InfoWindow.DefaultTextAdapter(getApplicationContext()) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                String a;
                a = "123";
                return a;
            }
        });
        infoWindow.setPosition(new LatLng(36.413436852701466, 126.88437382859924));
        infoWindow.setAlpha(0.7f);
        infoWindow.setMap(naverMap);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.now){
            Intent intent1 = new Intent(NMapsActivity.this, now.class);
            startActivity(intent1);
        }
    }
}