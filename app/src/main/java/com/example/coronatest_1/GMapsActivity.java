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
    Marker a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18;
    HashMap<String, String> markerMap = new HashMap<String, String>();
    String id = null;
    String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%BD%94%EB%A1%9C%EB%82%98+%ED%99%95%EC%A7%84%EC%9E%90";
    String msg;
    String seoultoday = null;
    String chungnamtoday = null;
    String gg = null;
    String incheon = null;
    String busan = null;
    String degu = null;
    String 광주, 대전 ,울산, 세종, 강원, 충북, 전북, 전남, 경남, 경북, 제주, 검역;
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

        LatLng location6 = new LatLng(35.823250, 128.573377);//대구
        a6 = mMap.addMarker(new MarkerOptions().position(location6));
        id = a6.getId();
        markerMap.put(id, "a6");

        LatLng location7 = new LatLng(35.158966, 126.828431);//광주
        a7 = mMap.addMarker(new MarkerOptions().position(location7));
        id = a7.getId();
        markerMap.put(id, "a7");

        LatLng location8 = new LatLng(36.340487, 127.394989);//대전
        a8 = mMap.addMarker(new MarkerOptions().position(location8));
        id = a8.getId();
        markerMap.put(id, "a8");

        LatLng location9 = new LatLng(35.549599, 129.274554);//울산
        a9 = mMap.addMarker(new MarkerOptions().position(location9));
        id = a9.getId();
        markerMap.put(id, "a9");

        LatLng location10 = new LatLng(36.560969, 127.258404);//세종
        a10 = mMap.addMarker(new MarkerOptions().position(location10));
        id = a10.getId();
        markerMap.put(id, "a10");

        LatLng location11 = new LatLng(37.836372, 128.152352);//강원
        a11 = mMap.addMarker(new MarkerOptions().position(location11));
        id = a11.getId();
        markerMap.put(id, "a11");

        LatLng location12 = new LatLng(37.009543, 127.738258);//충북
        a12= mMap.addMarker(new MarkerOptions().position(location12));
        id = a12.getId();
        markerMap.put(id, "a12");

        LatLng location13 = new LatLng(35.715299, 127.143020);//전북
        a13= mMap.addMarker(new MarkerOptions().position(location13));
        id = a13.getId();
        markerMap.put(id, "a13");

        LatLng location14 = new LatLng(34.860866, 127.068295);//전남
        a14= mMap.addMarker(new MarkerOptions().position(location14));
        id = a14.getId();
        markerMap.put(id, "a14");

        LatLng location15 = new LatLng(33.467247, 126.513488);//제주
        a15= mMap.addMarker(new MarkerOptions().position(location15));
        id = a15.getId();
        markerMap.put(id, "a15");

        LatLng location16 = new LatLng(34.942815, 129.563343);//검역
        a16= mMap.addMarker(new MarkerOptions().position(location16));
        id = a16.getId();
        markerMap.put(id, "a16");

        LatLng location17 = new LatLng(36.296288, 128.899491);//경북
        a17= mMap.addMarker(new MarkerOptions().position(location17));
        id = a17.getId();
        markerMap.put(id, "a17");

        LatLng location18 = new LatLng(35.472209, 128.230307);//경남
        a18= mMap.addMarker(new MarkerOptions().position(location18));
        id = a18.getId();
        markerMap.put(id, "a18");


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location12, (float) 6.8));

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
                    Intent i = new Intent(GMapsActivity.this, Incheon.class);
                    startActivity(i);
                }
                else if(m.equals("a5")){
                    Intent i = new Intent(GMapsActivity.this, Busan.class);
                    startActivity(i);
                }
                else if(m.equals("a6")){
                    Intent i = new Intent(GMapsActivity.this, degu.class);
                    startActivity(i);
                }
                else if(m.equals("a7")){
                    Intent i = new Intent(GMapsActivity.this, Gwangju.class);
                    startActivity(i);
                }
                else if(m.equals("a8")){
                    Intent i = new Intent(GMapsActivity.this, Daejeon.class);
                    startActivity(i);
                }
                else if(m.equals("a9")){
                    Intent i = new Intent(GMapsActivity.this, Ulsan.class);
                    startActivity(i);
                }
                else if(m.equals("a10")){
                    Intent i = new Intent(GMapsActivity.this, Sejong.class);
                    startActivity(i);
                }
                else if(m.equals("a11")){
                    Intent i = new Intent(GMapsActivity.this, Kangwon.class);
                    startActivity(i);
                }
                else if(m.equals("a12")){
                    Intent i = new Intent(GMapsActivity.this, Chungbuk.class);
                    startActivity(i);
                }
                else if(m.equals("a13")){
                    Intent i = new Intent(GMapsActivity.this, Jeonbuk.class);
                    startActivity(i);
                }
                else if(m.equals("a14")){
                    Intent i = new Intent(GMapsActivity.this, Jeonnam.class);
                    startActivity(i);
                }
                else if(m.equals("a15")){
                    Intent i = new Intent(GMapsActivity.this, Jeju.class);
                    startActivity(i);
                }

                else if(m.equals("a16")){
                    Intent i = new Intent(GMapsActivity.this, Quar.class);
                    startActivity(i);
                }
                else if(m.equals("a17")){
                    Intent i = new Intent(GMapsActivity.this, Gyeonbuk.class);
                    startActivity(i);
                }
                else if(m.equals("a18")){
                    Intent i = new Intent(GMapsActivity.this, Gyeonnam.class);
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

                Bundle bundle6 = msg.getData();
                a6.setTitle(bundle6.getString("대구"));

                Bundle bundle7 = msg.getData();
                a7.setTitle(bundle7.getString("광주"));

                Bundle bundle8 = msg.getData();
                a8.setTitle(bundle8.getString("대전"));

                Bundle bundle9 = msg.getData();
                a9.setTitle(bundle9.getString("울산"));

                Bundle bundle10 = msg.getData();
                a10.setTitle(bundle10.getString("세종"));

                Bundle bundle11 = msg.getData();
                a11.setTitle(bundle11.getString("강원"));

                Bundle bundle12 = msg.getData();
                a12.setTitle(bundle12.getString("충북"));

                Bundle bundle13 = msg.getData();
                a13.setTitle(bundle13.getString("전북"));

                Bundle bundle14 = msg.getData();
                a14.setTitle(bundle14.getString("전남"));

                Bundle bundle15 = msg.getData();
                a15.setTitle(bundle15.getString("제주"));

                Bundle bundle16 = msg.getData();
                a16.setTitle(bundle16.getString("검역"));

                Bundle bundle17 = msg.getData();
                a17.setTitle(bundle17.getString("경북"));

                Bundle bundle18 = msg.getData();
                a18.setTitle(bundle18.getString("경남"));
            }
        };

        new Thread(){

            @Override
            public void run(){

                try{
                    Document doc = Jsoup.connect(url).get();
                    Elements elements = doc.select(".confirmed_case ");//태그로 가져오기

                    seoultoday = elements.get(0).text();
                    chungnamtoday = elements.get(8).text();
                    gg = elements.get(1).text();
                    incheon = elements.get(3).text();
                    busan = elements.get(4).text();
                    degu = elements.get(2).text();
                    광주 = elements.get(11).text();
                    대전 = elements.get(14).text();
                    울산 = elements.get(12).text();
                    세종 = elements.get(17).text();
                    강원 = elements.get(9).text();
                    충북 = elements.get(10).text();
                    전북 = elements.get(13).text();
                    전남 = elements.get(15).text();
                    경북 = elements.get(6).text();
                    경남 = elements.get(5).text();
                    제주 = elements.get(16).text();
                    검역 = elements.get(7).text();


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

                    bundle.putString("대구","대구 : " + degu );
                    Message mmsg6 = handler.obtainMessage();
                    mmsg6.setData(bundle);
                    handler.sendMessage(mmsg6);

                    bundle.putString("광주","광주 : " + 광주 );
                    Message mmsg7 = handler.obtainMessage();
                    mmsg7.setData(bundle);
                    handler.sendMessage(mmsg7);

                    bundle.putString("대전","대전 : " + 대전 );
                    Message mmsg8 = handler.obtainMessage();
                    mmsg8.setData(bundle);
                    handler.sendMessage(mmsg8);

                    bundle.putString("울산","울산 : " + 울산 );
                    Message mmsg9 = handler.obtainMessage();
                    mmsg9.setData(bundle);
                    handler.sendMessage(mmsg9);

                    bundle.putString("세종","세종 : " + 세종 );
                    Message mmsg10 = handler.obtainMessage();
                    mmsg10.setData(bundle);
                    handler.sendMessage(mmsg10);

                    bundle.putString("강원","강원 : " + 강원 );
                    Message mmsg11 = handler.obtainMessage();
                    mmsg11.setData(bundle);
                    handler.sendMessage(mmsg11);

                    bundle.putString("충북","충북 : " + 충북 );
                    Message mmsg12 = handler.obtainMessage();
                    mmsg12.setData(bundle);
                    handler.sendMessage(mmsg12);

                    bundle.putString("전북","전북 : " + 전북 );
                    Message mmsg13 = handler.obtainMessage();
                    mmsg13.setData(bundle);
                    handler.sendMessage(mmsg13);

                    bundle.putString("전남","전남 : " + 전남 );
                    Message mmsg14 = handler.obtainMessage();
                    mmsg14.setData(bundle);
                    handler.sendMessage(mmsg14);

                    bundle.putString("제주","제주 : " + 제주 );
                    Message mmsg15 = handler.obtainMessage();
                    mmsg15.setData(bundle);
                    handler.sendMessage(mmsg15);

                    bundle.putString("검역","검역 : " + 검역 );
                    Message mmsg16 = handler.obtainMessage();
                    mmsg16.setData(bundle);
                    handler.sendMessage(mmsg16);

                    bundle.putString("경북","경북 : " + 경북 );
                    Message mmsg17 = handler.obtainMessage();
                    mmsg17.setData(bundle);
                    handler.sendMessage(mmsg17);

                    bundle.putString("경남","경남 : " + 경남 );
                    Message mmsg18 = handler.obtainMessage();
                    mmsg18.setData(bundle);
                    handler.sendMessage(mmsg18);


                }catch (IOException e){
                    e.printStackTrace();
                }
            }


        }.start();

    }

}