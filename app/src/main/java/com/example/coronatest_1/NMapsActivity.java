package com.example.coronatest_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.CaseMap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.google.android.gms.maps.model.MarkerOptions;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.MapView;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;


public class NMapsActivity extends AppCompatActivity implements OnMapReadyCallback, OnClickListener{
    private MapView mapView;
    private static NaverMap naverMap;
    private InfoWindow infoWindow;
    private InfoWindow infoWindow1;
    Button btn_now;
    Button bt;
    TextView a;
    String url = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=";
    String seoultoday = null;
    String chungnamtoday = null;
    SQLiteDatabase sql;
    String gg = null;
    String incheon = null;
    String busan = null;
    String id;
    HashMap<String, String> markerMap = new HashMap<String, String>();
    private final String dbName = "dbTest1";
    private final String tableName = "person";
    final Bundle bundle = new Bundle();
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
                //String b = (String) a.getText();
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

        Handler handler = new Handler(){

            @Override
            public void handleMessage(Message msg){
                Bundle bundle = msg.getData();
                a.setText(bundle.getString("message"));

                //Bundle bundle2 = msg.getData();
                //a1.setTitle(bundle2.getString("mes"));
            }
        };

        new Thread(){

            @Override
            public void run(){

                try{
                    Document doc = Jsoup.connect(url).get();
                    Elements elements = doc.select("table > tbody > tr");//태그로 가져오기

                    seoultoday = elements.select("td").get(8).text();
                    chungnamtoday = elements.select("td").get(96).text();
                    gg = elements.select("td").get(72).text();
                    incheon = elements.select("td").get(32).text();
                    busan = elements.select("td").get(16).text();

                    bundle.putString("message","서울 : " + seoultoday );
                    Message mmsg = handler.obtainMessage();
                    mmsg.setData(bundle);
                    handler.sendMessage(mmsg);


                    bundle.putString("mes", "충남 : " + chungnamtoday );
                    Message mmsg2 = handler.obtainMessage();
                    mmsg2.setData(bundle);
                    handler.sendMessage(mmsg2);

                    bundle.putString("gg","경기 : " + gg );
                    Message mmsg3 = handler.obtainMessage();
                    mmsg3.setData(bundle);
                    handler.sendMessage(mmsg3);

                    bundle.putString("인천","인천 : " + incheon );
                    Message mmsg4 = handler.obtainMessage();
                    mmsg4.setData(bundle);
                    handler.sendMessage(mmsg4);

                    bundle.putString("부산","부산 : " + busan );
                    Message mmsg5 = handler.obtainMessage();
                    mmsg5.setData(bundle);
                    handler.sendMessage(mmsg5);


                }catch (IOException e){
                    e.printStackTrace();
                }
            }


        }.start();

    }






}