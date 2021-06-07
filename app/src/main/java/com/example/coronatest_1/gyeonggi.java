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

public class gyeonggi extends AppCompatActivity {

    TextView textView5, textView6, textView7, textView8;
    String url1 = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=";
    String url2 = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%BD%94%EB%A1%9C%EB%82%98+%ED%99%95%EC%A7%84%EC%9E%90";

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
    String url = "https://www.gg.go.kr/contents/contents.do?ciIdx=1150&menuId=2909";
    String msg;
    final Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyeonggi);
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
        textView12_1 = findViewById(R.id.textView12_1);
        textView13_1 = findViewById(R.id.textView13_1);
        textView14_1 = findViewById(R.id.textView14_1);
        textView15_1 = findViewById(R.id.textView15_1);
        textView16_1 = findViewById(R.id.textView16_1);
        textView17_1 = findViewById(R.id.textView17_1);
        textView18_1 = findViewById(R.id.textView18_1);
        textView19_1 = findViewById(R.id.textView19_1);
        textView20_1 = findViewById(R.id.textView20_1);
        textView21_1 = findViewById(R.id.textView21_1);
        textView22_1 = findViewById(R.id.textView22_1);
        textView23_1 = findViewById(R.id.textView23_1);
        textView24_1 = findViewById(R.id.textView24_1);
        textView25_1 = findViewById(R.id.textView25_1);
        textView26_1 = findViewById(R.id.textView26_1);
        textView27_1 = findViewById(R.id.textView27_1);
        textView28_1 = findViewById(R.id.textView28_1);
        textView29_1 = findViewById(R.id.textView29_1);
        textView30_1 = findViewById(R.id.textView30_1);
        textView31_1 = findViewById(R.id.textView31_1);

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
        textView12_2 = findViewById(R.id.textView12_2);
        textView13_2 = findViewById(R.id.textView13_2);
        textView14_2 = findViewById(R.id.textView14_2);
        textView15_2 = findViewById(R.id.textView15_2);
        textView16_2 = findViewById(R.id.textView16_2);
        textView17_2 = findViewById(R.id.textView17_2);
        textView18_2 = findViewById(R.id.textView18_2);
        textView19_2 = findViewById(R.id.textView19_2);
        textView20_2 = findViewById(R.id.textView20_2);
        textView21_2 = findViewById(R.id.textView21_2);
        textView22_2 = findViewById(R.id.textView22_2);
        textView23_2 = findViewById(R.id.textView23_2);
        textView24_2 = findViewById(R.id.textView24_2);
        textView25_2 = findViewById(R.id.textView25_2);
        textView26_2 = findViewById(R.id.textView26_2);
        textView27_2 = findViewById(R.id.textView27_2);
        textView28_2 = findViewById(R.id.textView28_2);
        textView29_2 = findViewById(R.id.textView29_2);
        textView30_2 = findViewById(R.id.textView30_2);
        textView31_2 = findViewById(R.id.textView31_2);

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
        textView12_3 = findViewById(R.id.textView12_3);
        textView13_3 = findViewById(R.id.textView13_3);
        textView14_3 = findViewById(R.id.textView14_3);
        textView15_3 = findViewById(R.id.textView15_3);
        textView16_3 = findViewById(R.id.textView16_3);
        textView17_3 = findViewById(R.id.textView17_3);
        textView18_3 = findViewById(R.id.textView18_3);
        textView19_3 = findViewById(R.id.textView19_3);
        textView20_3 = findViewById(R.id.textView20_3);
        textView21_3 = findViewById(R.id.textView21_3);
        textView22_3 = findViewById(R.id.textView22_3);
        textView23_3 = findViewById(R.id.textView23_3);
        textView24_3 = findViewById(R.id.textView24_3);
        textView25_3 = findViewById(R.id.textView25_3);
        textView26_3 = findViewById(R.id.textView26_3);
        textView27_3 = findViewById(R.id.textView27_3);
        textView28_3 = findViewById(R.id.textView28_3);
        textView29_3 = findViewById(R.id.textView29_3);
        textView30_3 = findViewById(R.id.textView30_3);
        textView31_3 = findViewById(R.id.textView31_3);

        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);


        new Thread(){
            @Override
            public void run(){
                Document doc = null;
                try{
                    textView1_1.setText("수원");
                    textView2_1.setText("고양");
                    textView3_1.setText("용인");
                    textView4_1.setText("성남");
                    textView5_1.setText("부천");
                    textView6_1.setText("안산");
                    textView7_1.setText("화성");
                    textView8_1.setText("남양주");
                    textView9_1.setText("안양");
                    textView10_1.setText("평택");
                    textView11_1.setText("의정부");
                    textView12_1.setText("파주");
                    textView13_1.setText("시흥");
                    textView14_1.setText("김포");
                    textView15_1.setText("광명");
                    textView16_1.setText("광주");
                    textView17_1.setText("군포");
                    textView18_1.setText("이천");
                    textView19_1.setText("오산");
                    textView20_1.setText("하남");
                    textView21_1.setText("양주");
                    textView22_1.setText("구리");
                    textView23_1.setText("안성");
                    textView24_1.setText("포천");
                    textView25_1.setText("의왕");
                    textView26_1.setText("여주");
                    textView27_1.setText("앙평");
                    textView28_1.setText("동두천");
                    textView29_1.setText("과천");
                    textView30_1.setText("가평");
                    textView31_1.setText("연천");



                    doc = Jsoup.connect(url).get();
                    Elements elements = doc.select(".mt-4.zone dd");//태그로 가져오기

                    for(int i = 0; i<70;i++) {
                        String a = elements.select("strong").get(i).text();

                        if (i == 1) {
                            bundle.putString("수원총확진자", a);
                            Message mmsg2 = handler.obtainMessage();
                            mmsg2.setData(bundle);
                            handler.sendMessage(mmsg2);
                            continue;
                        }


                        if (i == 2) {
                            bundle.putString("고양총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 3) {
                            bundle.putString("용인총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 4) {
                            bundle.putString("성남총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 5) {
                            bundle.putString("부천총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 6) {
                            bundle.putString("안산총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 7) {
                            bundle.putString("화성총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 8) {
                            bundle.putString("남양주총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 9) {
                            bundle.putString("안양총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 10) {
                            bundle.putString("평택총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 11) {
                            bundle.putString("의정부총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 12) {
                            bundle.putString("파주총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 13) {
                            bundle.putString("시흥총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 14) {
                            bundle.putString("김포총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 15) {
                            bundle.putString("광명총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 16) {
                            bundle.putString("광주총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 17) {
                            bundle.putString("군포총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 18) {
                            bundle.putString("이천총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 19) {
                            bundle.putString("오산총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 20) {
                            bundle.putString("하남총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 21) {
                            bundle.putString("양주총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 22) {
                            bundle.putString("구리총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 23) {
                            bundle.putString("안성총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 24) {
                            bundle.putString("포천총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 25) {
                            bundle.putString("의왕총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 26) {
                            bundle.putString("여주총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 27) {
                            bundle.putString("양평총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 28) {
                            bundle.putString("동두천총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 29) {
                            bundle.putString("과천총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 30) {
                            bundle.putString("가평총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 31) {
                            bundle.putString("연천총확진자", a);
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

                    doc = Jsoup.connect(url).get();
                    Elements elements = doc.select(".mt-4.zone dd");//태그로 가져오기

                    for(int i = 0; i<70;i++) {
                        String a = elements.select(".count").get(i).text();

                        if (i == 1) {
                            bundle.putString("수원당일확진자", a);
                            Message mmsg2 = handler.obtainMessage();
                            mmsg2.setData(bundle);
                            handler.sendMessage(mmsg2);
                            continue;
                        }


                        if (i == 2) {
                            bundle.putString("고양당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 3) {
                            bundle.putString("용인당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 4) {
                            bundle.putString("성남당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 5) {
                            bundle.putString("부천당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 6) {
                            bundle.putString("안산당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 7) {
                            bundle.putString("화성당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 8) {
                            bundle.putString("남양주당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 9) {
                            bundle.putString("안양당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 10) {
                            bundle.putString("평택당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 11) {
                            bundle.putString("의정부당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 12) {
                            bundle.putString("파주당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 13) {
                            bundle.putString("시흥당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 14) {
                            bundle.putString("김포당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 15) {
                            bundle.putString("광명당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 16) {
                            bundle.putString("광주당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 17) {
                            bundle.putString("군포당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 18) {
                            bundle.putString("이천당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 19) {
                            bundle.putString("오산당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 20) {
                            bundle.putString("하남당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 21) {
                            bundle.putString("양주당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 22) {
                            bundle.putString("구리당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 23) {
                            bundle.putString("안성당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 24) {
                            bundle.putString("포천당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 25) {
                            bundle.putString("의왕당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 26) {
                            bundle.putString("여주당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 27) {
                            bundle.putString("양평당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 28) {
                            bundle.putString("동두천당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 29) {
                            bundle.putString("과천당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 30) {
                            bundle.putString("가평당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 31) {
                            bundle.putString("연천당일확진자", a);
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


                        if (i == 75) {
                            bundle.putString("경기총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i ==77 ) {
                            bundle.putString("경기완치", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 78 ) {
                            bundle.putString("경기사망", a);
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


                        if (i == 1) {
                            bundle.putString("경기신규확진자", a);
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
            textView6.setText(bundles6.getString("경기총확진자"));

            Bundle bundles7 = msg.getData();
            textView5.setText(bundles7.getString("경기신규확진자"));

            Bundle bundles8 = msg.getData();
            textView7.setText(bundles8.getString("경기완치"));

            Bundle bundles9 = msg.getData();
            textView8.setText(bundles9.getString("경기사망"));

            Bundle bundle2 = msg.getData();
            textView1_3.setText(bundle2.getString("수원총확진자"));

            Bundle bundle3 = msg.getData();
            textView2_3.setText(bundle3.getString("고양총확진자"));

            Bundle bundle4 = msg.getData();
            textView3_3.setText(bundle4.getString("용인총확진자"));

            Bundle bundle5 = msg.getData();
            textView4_3.setText(bundle5.getString("성남총확진자"));

            Bundle bundle6 = msg.getData();
            textView5_3.setText(bundle6.getString("부천총확진자"));

            Bundle bundle7 = msg.getData();
            textView6_3.setText(bundle7.getString("안산총확진자"));

            Bundle bundle8 = msg.getData();
            textView7_3.setText(bundle8.getString("화성총확진자"));

            Bundle bundle9 = msg.getData();
            textView8_3.setText(bundle9.getString("남양주총확진자"));

            Bundle bundle10 = msg.getData();
            textView9_3.setText(bundle10.getString("안양총확진자"));

            Bundle bundle11 = msg.getData();
            textView10_3.setText(bundle11.getString("평택총확진자"));

            Bundle bundle12 = msg.getData();
            textView11_3.setText(bundle12.getString("의정부총확진자"));

            Bundle bundle13 = msg.getData();
            textView12_3.setText(bundle13.getString("파주총확진자"));

            Bundle bundle14 = msg.getData();
            textView13_3.setText(bundle14.getString("시흥총확진자"));

            Bundle bundle15 = msg.getData();
            textView14_3.setText(bundle15.getString("김포총확진자"));

            Bundle bundle16 = msg.getData();
            textView15_3.setText(bundle16.getString("광명총확진자"));

            Bundle bundle17 = msg.getData();
            textView16_3.setText(bundle17.getString("광주총확진자"));

            Bundle bundle18 = msg.getData();
            textView17_3.setText(bundle18.getString("군포총확진자"));

            Bundle bundle19 = msg.getData();
            textView18_3.setText(bundle19.getString("이천총확진자"));

            Bundle bundle20 = msg.getData();
            textView19_3.setText(bundle20.getString("오산총확진자"));

            Bundle bundle21 = msg.getData();
            textView20_3.setText(bundle21.getString("하남총확진자"));

            Bundle bundle22 = msg.getData();
            textView21_3.setText(bundle22.getString("양주총확진자"));

            Bundle bundle23 = msg.getData();
            textView22_3.setText(bundle23.getString("구리총확진자"));

            Bundle bundle24 = msg.getData();
            textView23_3.setText(bundle24.getString("안성총확진자"));

            Bundle bundle25 = msg.getData();
            textView24_3.setText(bundle25.getString("포천총확진자"));

            Bundle bundle26 = msg.getData();
            textView25_3.setText(bundle26.getString("의왕총확진자"));

            Bundle bundle27 = msg.getData();
            textView26_3.setText(bundle27.getString("여주총확진자"));

            Bundle bundle = msg.getData();
            textView27_3.setText(bundle.getString("양평총확진자"));

            Bundle bundle28 = msg.getData();
            textView28_3.setText(bundle28.getString("동두천총확진자"));

            Bundle bundle29 = msg.getData();
            textView29_3.setText(bundle29.getString("과천총확진자"));

            Bundle bundle30 = msg.getData();
            textView30_3.setText(bundle30.getString("가평총확진자"));

            Bundle bundle31 = msg.getData();
            textView31_3.setText(bundle31.getString("연천총확진자"));

            Bundle bundle32 = msg.getData();
            textView1_2.setText(bundle32.getString("수원당일확진자"));

            Bundle bundle33 = msg.getData();
            textView2_2.setText(bundle33.getString("고양당일확진자"));

            Bundle bundle34 = msg.getData();
            textView3_2.setText(bundle34.getString("용인당일확진자"));

            Bundle bundle35 = msg.getData();
            textView4_2.setText(bundle35.getString("성남당일확진자"));

            Bundle bundle36 = msg.getData();
            textView5_2.setText(bundle36.getString("부천당일확진자"));

            Bundle bundle37 = msg.getData();
            textView6_2.setText(bundle37.getString("안산당일확진자"));

            Bundle bundle38 = msg.getData();
            textView7_2.setText(bundle38.getString("화성당일확진자"));

            Bundle bundle39 = msg.getData();
            textView8_2.setText(bundle39.getString("남양주당일확진자"));

            Bundle bundle40 = msg.getData();
            textView9_2.setText(bundle40.getString("안양당일확진자"));

            Bundle bundle41 = msg.getData();
            textView10_2.setText(bundle41.getString("평택당일확진자"));

            Bundle bundle42 = msg.getData();
            textView11_2.setText(bundle42.getString("의정부당일확진자"));

            Bundle bundle43 = msg.getData();
            textView12_2.setText(bundle43.getString("파주당일확진자"));

            Bundle bundle44 = msg.getData();
            textView13_2.setText(bundle44.getString("시흥당일확진자"));

            Bundle bundle45 = msg.getData();
            textView14_2.setText(bundle45.getString("김포당일확진자"));

            Bundle bundle46 = msg.getData();
            textView15_2.setText(bundle46.getString("광명당일확진자"));

            Bundle bundle47 = msg.getData();
            textView16_2.setText(bundle47.getString("광주당일확진자"));

            Bundle bundle48 = msg.getData();
            textView17_2.setText(bundle48.getString("군포당일확진자"));

            Bundle bundle49 = msg.getData();
            textView18_2.setText(bundle49.getString("이천당일확진자"));

            Bundle bundle50 = msg.getData();
            textView19_2.setText(bundle50.getString("오산당일확진자"));

            Bundle bundle51 = msg.getData();
            textView20_2.setText(bundle51.getString("하남당일확진자"));

            Bundle bundle52 = msg.getData();
            textView21_2.setText(bundle52.getString("양주당일확진자"));

            Bundle bundle53 = msg.getData();
            textView22_2.setText(bundle53.getString("구리당일확진자"));

            Bundle bundle54 = msg.getData();
            textView23_2.setText(bundle54.getString("안성당일확진자"));

            Bundle bundle55 = msg.getData();
            textView24_2.setText(bundle55.getString("포천당일확진자"));

            Bundle bundle56 = msg.getData();
            textView25_2.setText(bundle56.getString("의왕당일확진자"));

            Bundle bundle57 = msg.getData();
            textView26_2.setText(bundle57.getString("여주당일확진자"));

            Bundle bundle58= msg.getData();
            textView27_2.setText(bundle58.getString("양평당일확진자"));

            Bundle bundle59 = msg.getData();
            textView28_2.setText(bundle59.getString("동두천당일확진자"));

            Bundle bundle60 = msg.getData();
            textView29_2.setText(bundle60.getString("과천당일확진자"));

            Bundle bundle61 = msg.getData();
            textView30_2.setText(bundle61.getString("가평당일확진자"));

            Bundle bundle62 = msg.getData();
            textView31_2.setText(bundle62.getString("연천당일확진자"));



        }
    };

}