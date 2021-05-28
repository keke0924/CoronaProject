package com.example.coronatest_1;

import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.naver.maps.map.overlay.InfoWindow;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

public class GMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Marker a1;
    Marker a2;
    Marker a3;
    Marker a4;
    Marker a5;
    HashMap<String, String> markerMap = new HashMap<String, String>();
    String id = null;
    String url = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=";
    String msg;
    String seoultoday = null;
    String chungnamtoday = null;
    String gg = null;
    String incheon = null;
    String busan = null;
    String degu = null;
    String 광주 = null;
    String 대전 = null;
    SQLiteDatabase sql;
    private final String dbName = "dbTest1";
    private final String tableName = "person";
    final Bundle bundle = new Bundle();

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
        //String aa = "";
        LatLng location = new LatLng(36.714678, 126.863142);//충남
        a1 = mMap.addMarker(new MarkerOptions()
                        .position(location).title(""));
        id = a1.getId();
        markerMap.put(id, "a1");

        LatLng location2 = new LatLng(37.546731, 126.980576);//서울
        a2 = mMap.addMarker(new MarkerOptions().position(location2).title(""));
        id = a2.getId();
        markerMap.put(id, "a2");

        LatLng location3 = new LatLng(37.419567, 127.513731);//경기도
        a3 = mMap.addMarker(new MarkerOptions().position(location3).title(""));
        id = a3.getId();
        markerMap.put(id, "a3");

        LatLng location4 = new LatLng(37.440223, 126.705649);//인천
        a4 = mMap.addMarker(new MarkerOptions().position(location4).title(""));
        id = a4.getId();
        markerMap.put(id, "a4");

        LatLng location5 = new LatLng(35.155949, 129.046728);//부산
        a5 = mMap.addMarker(new MarkerOptions().position(location5));
        id = a5.getId();
        markerMap.put(id, "a5");



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, (float) 6.8));

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker marker) {
                String m = markerMap.get(marker.getId());
                if (m.equals("a1")){
                    Intent i = new Intent(GMapsActivity.this, Chungnam.class);
                    startActivity(i);
                }
                else if(m.equals("a2")){
                    Intent i = new Intent(GMapsActivity.this, Seoul.class);
                    startActivity(i);
                }
                else if(m.equals("a3")){
                    Intent i = new Intent(GMapsActivity.this, gyeonggi.class);
                    startActivity(i);
                }
                else if(m.equals("a4")){
                    Intent i = new Intent(GMapsActivity.this, gyeonggi.class);
                    startActivity(i);
                }
                else if(m.equals("a5")){
                    Intent i = new Intent(GMapsActivity.this, gyeonggi.class);
                    startActivity(i);
                }


            }
        });

         Handler handler = new Handler(){

            @Override
            public void handleMessage(Message msg){
                Bundle bundle = msg.getData();
                a2.setTitle(bundle.getString("message"));

                Bundle bundle2 = msg.getData();
                a1.setTitle(bundle2.getString("mes"));

                Bundle bundle3 = msg.getData();
                a3.setTitle(bundle3.getString("gg"));

                Bundle bundle4 = msg.getData();
                a4.setTitle(bundle4.getString("인천"));

                Bundle bundle5 = msg.getData();
                a5.setTitle(bundle5.getString("부산"));
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