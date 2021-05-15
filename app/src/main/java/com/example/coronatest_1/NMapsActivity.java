package com.example.coronatest_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.MapView;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;


public class NMapsActivity extends AppCompatActivity implements OnMapReadyCallback, OnClickListener{
    private MapView mapView;
    private static NaverMap naverMap;
    private InfoWindow infoWindow;
    private InfoWindow infoWindow1;
    Button btn_now;
    Button bt;
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
        CameraPosition cameraPosition = new CameraPosition(
                new LatLng(36.79379851270565, 127.12149128900404),  // 위치 지정
                5.6                           // 줌 레벨
        );
        naverMap.setCameraPosition(cameraPosition);
        Marker marker = new Marker();
        marker.getTag();
        //marker.setPosition(new LatLng(36.79379851270565,127.12149128900404));
        //marker.setMap(naverMap);

        infoWindow = new InfoWindow();
        infoWindow.setAdapter(new InfoWindow.DefaultTextAdapter(getApplicationContext()) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                String a;
                a = "쌍용역";
                return a;
            }
        });

        infoWindow.setPosition(new LatLng(36.413436852701466, 126.88437382859924));
        infoWindow.setAlpha(0.7f);
        infoWindow.setMap(naverMap);
        //infoWindow.setOnClickListener(this);
        infoWindow.setOnClickListener(overlay -> {
            Intent intent1 = new Intent(NMapsActivity.this, Chungnam.class);
            startActivity(intent1);
            return false;
        });

        infoWindow1 = new InfoWindow();
        infoWindow1.setAdapter(new InfoWindow.DefaultTextAdapter(getApplicationContext()) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {

                String a;
                a = "서울역";
                return a;
            }
        });



        infoWindow1.setPosition(new LatLng(37.55609637360114, 126.97225807999249));
        infoWindow1.setAlpha(0.7f);
        infoWindow1.setMap(naverMap);
        infoWindow1.setOnClickListener(overlay -> {
            Intent intent1 = new Intent(NMapsActivity.this, Seoul.class);
            startActivity(intent1);
            return false;
        });
        //infoWindow1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.now){
            Intent intent1 = new Intent(NMapsActivity.this, now.class);
            startActivity(intent1);
        }
    }






}