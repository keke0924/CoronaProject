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

public class Daejeon extends AppCompatActivity {
    TableLayout tb;
    //지역
    TextView textView1_1, textView2_1, textView3_1, textView4_1, textView5_1, textView6_1, textView7_1, textView8_1, textView9_1, textView10_1;
    TextView textView11_1, textView12_1, textView13_1, textView14_1, textView15_1, textView16_1, textView17_1, textView18_1, textView19_1, textView20_1;
    TextView textView21_1, textView22_1, textView23_1, textView24_1, textView25_1, textView26_1, textView27_1, textView28_1, textView29_1,textView30_1 ,textView31_1;

    //당일 확진자
    TextView textView1_2, textView2_2, textView3_2, textView4_2, textView5_2, textView6_2, textView7_2, textView8_2, textView9_2, textView10_2;
    TextView textView11_2, textView12_2, textView13_2, textView14_2, textView15_2, textView16_2, textView17_2, textView18_2, textView19_2, textView20_2;
    TextView textView21_2, textView22_2, textView23_2, textView24_2, textView25_2, textView26_2, textView27_2,textView28_2,textView29_2,textView30_2, textView31_2;

    //총 확진자
    TextView textView1_3, textView2_3, textView3_3, textView4_3, textView5_3, textView6_3, textView7_3, textView8_3, textView9_3, textView10_3;
    TextView textView11_3, textView12_3, textView13_3, textView14_3, textView15_3, textView16_3, textView17_3, textView18_3, textView19_3, textView20_3;
    TextView textView21_3, textView22_3, textView23_3, textView24_3, textView25_3, textView26_3, textView27_3,textView28_3,textView29_3,textView30_3, textView31_3;

    String id = null;
    String url = "https://www.daejeon.go.kr/corona19/index.do";
    String msg;
    final Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daejeon);
        //지역
        textView1_1 = findViewById(R.id.textView1_1);
        textView2_1 = findViewById(R.id.textView2_1);
        textView3_1 = findViewById(R.id.textView3_1);
        textView4_1 = findViewById(R.id.textView4_1);
        textView5_1 = findViewById(R.id.textView5_1);
        textView6_1 = findViewById(R.id.textView6_1);
        textView7_1 = findViewById(R.id.textView7_1);
        textView8_1 = findViewById(R.id.textView8_1);
        textView9_1 = findViewById(R.id.textView9_1);
        textView10_1 = findViewById(R.id.textView10_1);
        textView11_1 = findViewById(R.id.textView11_1);


        //오늘
        textView1_2 = findViewById(R.id.textView1_2);
        textView2_2 = findViewById(R.id.textView2_2);
        textView3_2 = findViewById(R.id.textView3_2);
        textView4_2 = findViewById(R.id.textView4_2);
        textView5_2 = findViewById(R.id.textView5_2);
        textView6_2 = findViewById(R.id.textView6_2);
        textView7_2 = findViewById(R.id.textView7_2);
        textView8_2 = findViewById(R.id.textView8_2);
        textView9_2 = findViewById(R.id.textView9_2);
        textView10_2 = findViewById(R.id.textView10_2);
        textView11_2 = findViewById(R.id.textView11_2);


        //총
        textView1_3 = findViewById(R.id.textView1_3);
        textView2_3 = findViewById(R.id.textView2_3);
        textView3_3 = findViewById(R.id.textView3_3);
        textView4_3 = findViewById(R.id.textView4_3);
        textView5_3 = findViewById(R.id.textView5_3);
        textView6_3 = findViewById(R.id.textView6_3);
        textView7_3 = findViewById(R.id.textView7_3);
        textView8_3 = findViewById(R.id.textView8_3);
        textView9_3 = findViewById(R.id.textView9_3);
        textView10_3 = findViewById(R.id.textView10_3);
        textView11_3 = findViewById(R.id.textView11_3);



        new Thread(){
            @Override
            public void run(){
                Document doc = null;
                try{
                    textView1_1.setText("유성구");
                    textView2_1.setText("대덕구");
                    textView3_1.setText("서구");
                    textView4_1.setText("중구");
                    textView5_1.setText("동구");



                    doc = Jsoup.connect(url).get();
                    Elements elements = doc.select(".wrap_map_status");//태그로 가져오기

                    for(int i = 0; i<70;i++) {
                        String a = elements.select("strong").get(i).text();


                        if (i == 0) {
                            bundle.putString("유성구총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 1) {
                            bundle.putString("대덕구총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 2) {
                            bundle.putString("서구총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 3) {
                            bundle.putString("중구총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 4) {
                            bundle.putString("동구총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            break;
                        }

//                        if (i == 7) {
//                            bundle.putString("미추홀구당일확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 8) {
//                            bundle.putString("연수구총확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 9) {
//                            bundle.putString("연수구당일확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 10) {
//                            bundle.putString("남동구총확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 11) {
//                            bundle.putString("남동구당일확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 12) {
//                            bundle.putString("부평총확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 13) {
//                            bundle.putString("부평당일확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//                        if (i == 14) {
//                            bundle.putString("계양구총확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 15) {
//                            bundle.putString("계양구당일확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//                        if (i == 16) {
//                            bundle.putString("서구총확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 17) {
//                            bundle.putString("서구당일확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 18) {
//                            bundle.putString("강화군총확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 19) {
//                            bundle.putString("강화군당일확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 20) {
//                            bundle.putString("옹진군총확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 21) {
//                            bundle.putString("옹진군당일확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 22) {
//                            bundle.putString("기타총확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }
//
//                        if (i == 23) {
//                            bundle.putString("기타당일확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            break;
//                        }
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

            Bundle bundle2 = msg.getData();
            textView1_3.setText(bundle2.getString("유성구총확진자"));

//            Bundle bundle3 = msg.getData();
//            textView1_2.setText(bundle3.getString("중구당일확진자"));

            Bundle bundle4 = msg.getData();
            textView2_3.setText(bundle4.getString("대덕구총확진자"));

//            Bundle bundle5 = msg.getData();
//            textView2_2.setText(bundle5.getString("동구당일확진자"));

            Bundle bundle6 = msg.getData();
            textView3_3.setText(bundle6.getString("서구총확진자"));

//            Bundle bundle7 = msg.getData();
//            textView3_2.setText(bundle7.getString("미추홀구당일확진자"));

            Bundle bundle8 = msg.getData();
            textView4_3.setText(bundle8.getString("중구총확진자"));

//            Bundle bundle9 = msg.getData();
//            textView4_2.setText(bundle9.getString("연수구당일확진자"));

            Bundle bundle10 = msg.getData();
            textView5_3.setText(bundle10.getString("동구총확진자"));




        }
    };

}