package com.example.coronatest_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.HashMap;

public class Ulsan extends AppCompatActivity {
    TextView textView5, textView6, textView7, textView8;
    String url1 = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=";
    String url2 = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%BD%94%EB%A1%9C%EB%82%98+%ED%99%95%EC%A7%84%EC%9E%90";
    //지역
    TextView textView1_1, textView2_1, textView3_1, textView4_1, textView5_1;
    //당일 확진자
    TextView textView1_2, textView2_2, textView3_2, textView4_2, textView5_2;

    //총 확진자
    TextView textView1_3, textView2_3, textView3_3, textView4_3, textView5_3;

    String id = null;
    String url = "https://covid19.ulsan.go.kr/index.do";
    String msg;
    final Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulsan);
        //지역
        textView1_1 = findViewById(R.id.textView1_1);
        textView2_1 = findViewById(R.id.textView2_1);
        textView3_1 = findViewById(R.id.textView3_1);
        textView4_1 = findViewById(R.id.textView4_1);
        textView5_1 = findViewById(R.id.textView5_1);

        //오늘
        textView1_2 = findViewById(R.id.textView1_2);
        textView2_2 = findViewById(R.id.textView2_2);
        textView3_2 = findViewById(R.id.textView3_2);
        textView4_2 = findViewById(R.id.textView4_2);
        textView5_2 = findViewById(R.id.textView5_2);

        //총
        textView1_3 = findViewById(R.id.textView1_3);
        textView2_3 = findViewById(R.id.textView2_3);
        textView3_3 = findViewById(R.id.textView3_3);
        textView4_3 = findViewById(R.id.textView4_3);
        textView5_3 = findViewById(R.id.textView5_3);

        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);


        new Thread(){
            @Override
            public void run(){
                Document doc = null;
                try{
                    doc = Jsoup.connect(url).get();
                    Elements elements = doc.select("tbody > tr");//태그로 가져오기


                    textView1_1.setText("중구");
                    textView2_1.setText("남구");
                    textView3_1.setText("동구");
                    textView4_1.setText("북구");
                    textView5_1.setText("울주군");


                    for(int i = 0; i<70;i++) {
                        String a = elements.select("td").get(i).text();


                        if (i == 5) {
                            bundle.putString("중구총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 6) {
                            bundle.putString("남구총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 7) {
                            bundle.putString("동구총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 8) {
                            bundle.putString("북구총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 9) {
                            bundle.putString("울주군총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

//                        if (i == 10) {
//                            bundle.putString("동대문구총확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
                        if (i == 11) {
                            bundle.putString("중구당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 12) {
                            bundle.putString("남구당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 13) {
                            bundle.putString("동구당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 14) {
                            bundle.putString("북구당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 15) {
                            bundle.putString("울진군당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            break;
                        }


                    }





                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                Document doc = null;
                try{
                    doc = Jsoup.connect(url1).get();
                    Elements elements = doc.select("td.number");//테그로 가져오기




                    for(int i = 0; i<200;i++) {
                        String a = elements.get(i).text();


                        if (i == 59) {
                            bundle.putString("울산총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i ==61 ) {
                            bundle.putString("울산완치", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 62 ) {
                            bundle.putString("울산사망", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            break;
                        }

                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                Document doc = null;
                try{
                    doc = Jsoup.connect(url2).get();
                    Elements elements = doc.select(".confirmed_case");//테그로 가져오기




                    for(int i = 0; i<200;i++) {
                        String a = elements.get(i).text();


                        if (i == 12) {
                            bundle.putString("울산신규확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            break;
                        }




                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }





    @SuppressLint("HandlerLeak")

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg){
            Bundle bundles6 = msg.getData();
            textView6.setText(bundles6.getString("울산총확진자"));

            Bundle bundles7 = msg.getData();
            textView5.setText(bundles7.getString("울산신규확진자"));

            Bundle bundles8 = msg.getData();
            textView7.setText(bundles8.getString("울산완치"));

            Bundle bundles9 = msg.getData();
            textView8.setText(bundles9.getString("울산사망"));

            Bundle bundle2 = msg.getData();
            textView1_2.setText(bundle2.getString("중구총확진자"));

            Bundle bundle3 = msg.getData();
            textView2_2.setText(bundle3.getString("남구총확진자"));

            Bundle bundle4 = msg.getData();
            textView3_2.setText(bundle4.getString("동구총확진자"));

            Bundle bundle5 = msg.getData();
            textView4_2.setText(bundle5.getString("북구총확진자"));

            Bundle bundle6 = msg.getData();
            textView5_2.setText(bundle6.getString("울주군총확진자"));

//            Bundle bundle7 = msg.getData();
//            textView6_3.setText(bundle7.getString("광진구총확진자"));
//
//            Bundle bundle8 = msg.getData();
//            textView7_3.setText(bundle8.getString("구로구총확진자"));
//
//            Bundle bundle9 = msg.getData();
//            textView8_3.setText(bundle9.getString("금천구총확진자"));
//
//            Bundle bundle10 = msg.getData();
//            textView9_3.setText(bundle10.getString("노원구총확진자"));
//
//            Bundle bundle11 = msg.getData();
//            textView10_3.setText(bundle11.getString("도봉구총확진자"));
//
//            Bundle bundle12 = msg.getData();
//            textView11_3.setText(bundle12.getString("동대문구총확진자"));
//
//            Bundle bundle13 = msg.getData();
//            textView12_3.setText(bundle13.getString("동작구총확진자"));
//
//            Bundle bundle14 = msg.getData();
//            textView13_3.setText(bundle14.getString("마포구총확진자"));
//
//            Bundle bundle15 = msg.getData();
//            textView14_3.setText(bundle15.getString("서대문구총확진자"));
//
//            Bundle bundle16 = msg.getData();
//            textView15_3.setText(bundle16.getString("서초구총확진자"));
//
//            Bundle bundle17 = msg.getData();
//            textView16_3.setText(bundle17.getString("성동구총확진자"));
//
//            Bundle bundle18 = msg.getData();
//            textView17_3.setText(bundle18.getString("성북구총확진자"));
//
//            Bundle bundle19 = msg.getData();
//            textView18_3.setText(bundle19.getString("송파구총확진자"));
//
//            Bundle bundle20 = msg.getData();
//            textView19_3.setText(bundle20.getString("양천구총확진자"));
//
//            Bundle bundle21 = msg.getData();
//            textView20_3.setText(bundle21.getString("영등포구총확진자"));
//
//            Bundle bundle22 = msg.getData();
//            textView21_3.setText(bundle22.getString("용산구총확진자"));
//
//            Bundle bundle23 = msg.getData();
//            textView22_3.setText(bundle23.getString("은평구총확진자"));
//
//            Bundle bundle24 = msg.getData();
//            textView23_3.setText(bundle24.getString("종로구총확진자"));
//
//            Bundle bundle25 = msg.getData();
//            textView24_3.setText(bundle25.getString("중구총확진자"));
//
//            Bundle bundle26 = msg.getData();
//            textView25_3.setText(bundle26.getString("중량구총확진자"));
//
//            Bundle bundle27 = msg.getData();
//            textView26_3.setText(bundle27.getString("기타총확진자"));
//
            Bundle bundle = msg.getData();
            textView1_3.setText(bundle.getString("중구당일확진자"));

            Bundle bundle28 = msg.getData();
            textView2_3.setText(bundle28.getString("남구당일확진자"));

            Bundle bundle29 = msg.getData();
            textView3_3.setText(bundle29.getString("동구당일확진자"));

            Bundle bundle30 = msg.getData();
            textView4_3.setText(bundle30.getString("북구당일확진자"));

            Bundle bundle31 = msg.getData();
            textView5_3.setText(bundle31.getString("울진군당일확진자"));
//
//            Bundle bundle32 = msg.getData();
//            textView6_2.setText(bundle32.getString("광진구당일확진자"));
//
//            Bundle bundle33 = msg.getData();
//            textView7_2.setText(bundle33.getString("구로구당일확진자"));
//
//            Bundle bundle34 = msg.getData();
//            textView8_2.setText(bundle34.getString("금천구당일확진자"));
//
//            Bundle bundle35 = msg.getData();
//            textView9_2.setText(bundle35.getString("노원구당일확진자"));
//
//            Bundle bundle36 = msg.getData();
//            textView10_2.setText(bundle36.getString("도봉구당일확진자"));
//
//            Bundle bundle37 = msg.getData();
//            textView11_2.setText(bundle37.getString("동대문구당일확진자"));
//
//            Bundle bundle38 = msg.getData();
//            textView12_2.setText(bundle38.getString("동작구당일확진자"));
//
//            Bundle bundle39 = msg.getData();
//            textView13_2.setText(bundle39.getString("마포구당일확진자"));
//
//            Bundle bundle40 = msg.getData();
//            textView14_2.setText(bundle40.getString("서대문구당일확진자"));
//
//            Bundle bundle41 = msg.getData();
//            textView15_2.setText(bundle41.getString("서초구당일확진자"));
//
//            Bundle bundle42 = msg.getData();
//            textView16_2.setText(bundle42.getString("성동구당일확진자"));
//
//            Bundle bundle43 = msg.getData();
//            textView17_2.setText(bundle43.getString("성북구당일확진자"));
//
//            Bundle bundle44 = msg.getData();
//            textView18_2.setText(bundle44.getString("송파구당일확진자"));
//
//            Bundle bundle45 = msg.getData();
//            textView19_2.setText(bundle45.getString("양천구당일확진자"));
//
//            Bundle bundle46 = msg.getData();
//            textView20_2.setText(bundle46.getString("영등포구당일확진자"));
//
//            Bundle bundle52 = msg.getData();
//            textView21_2.setText(bundle52.getString("용산구당일확진자"));
//
//            Bundle bundle47 = msg.getData();
//            textView22_2.setText(bundle47.getString("은평구당일확진자"));
//
//            Bundle bundle48 = msg.getData();
//            textView23_2.setText(bundle48.getString("종로구당일확진자"));
//
//            Bundle bundle49 = msg.getData();
//            textView24_2.setText(bundle49.getString("중구당일확진자"));
//
//            Bundle bundle50 = msg.getData();
//            textView25_2.setText(bundle50.getString("중량구당일확진자"));
//
//            Bundle bundle51 = msg.getData();
//            textView26_2.setText(bundle51.getString("기타당일확진자"));

        }
    };

}