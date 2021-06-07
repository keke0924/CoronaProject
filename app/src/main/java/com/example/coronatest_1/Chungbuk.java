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

public class Chungbuk extends AppCompatActivity {
    TextView textView5, textView6, textView7, textView8;
    String url1 = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=";
    String url2 = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%BD%94%EB%A1%9C%EB%82%98+%ED%99%95%EC%A7%84%EC%9E%90";

    //지역
    TextView textView1_1, textView2_1, textView3_1, textView4_1, textView5_1, textView6_1, textView7_1, textView8_1, textView9_1, textView10_1;
    TextView textView11_1;
    //당일 확진자
    TextView textView1_2, textView2_2, textView3_2, textView4_2, textView5_2, textView6_2, textView7_2, textView8_2, textView9_2, textView10_2;
    TextView textView11_2;
    //총 확진자
    TextView textView1_3, textView2_3, textView3_3, textView4_3, textView5_3, textView6_3, textView7_3, textView8_3, textView9_3, textView10_3;
    TextView textView11_3;
    String id = null;
    String url = "http://www1.chungbuk.go.kr/covid-19/index.do";
    final Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chungbuk);
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

        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);

        new Thread(){
            @Override
            public void run(){
                Document doc = null;
                try{
                    textView1_1.setText("단양군");
                    textView2_1.setText("제천시");
                    textView3_1.setText("충주시");
                    textView4_1.setText("음성군");
                    textView5_1.setText("괴산군");
                    textView6_1.setText("증평군");
                    textView7_1.setText("진천군");
                    textView8_1.setText("청주시");
                    textView9_1.setText("보은군");
                    textView10_1.setText("옥천군");
                    textView11_1.setText("영동군");


                    doc = Jsoup.connect(url).get();
                    Elements elements = doc.select(".inline_box");//태그로 가져오기

                    for(int i = 0; i<70;i++) {
                        String a = elements.select("a").get(i).text();


                        if (i == 0) {
                            bundle.putString("단양군", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 1) {
                            bundle.putString("제천시", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 2) {
                            bundle.putString("충주시", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 3) {
                            bundle.putString("음성군", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 4) {
                            bundle.putString("괴산군", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 5) {
                            bundle.putString("증평군", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 6) {
                            bundle.putString("진천군", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 7) {
                            bundle.putString("청주시", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 8) {
                            bundle.putString("보은군", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 9) {
                            bundle.putString("옥천군", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 10) {
                            bundle.putString("영동군", a);
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


                        if (i == 91) {
                            bundle.putString("충북총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i ==93 ) {
                            bundle.putString("충북완치", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 94 ) {
                            bundle.putString("충북사망", a);
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
                    Elements elements = doc.select(".confirmed_case");//태그로 가져오기




                    for(int i = 0; i<200;i++) {
                        String a = elements.get(i).text();


                        if (i == 10) {
                            bundle.putString("충북신규확진자", a);
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
            textView6.setText(bundles6.getString("충북총확진자"));

            Bundle bundles7 = msg.getData();
            textView5.setText(bundles7.getString("충북신규확진자"));

            Bundle bundles8 = msg.getData();
            textView7.setText(bundles8.getString("충북완치"));

            Bundle bundles9 = msg.getData();
            textView8.setText(bundles9.getString("충북사망"));

            Bundle bundle2 = msg.getData();
            textView1_3.setText(bundle2.getString("단양군"));

            Bundle bundle4 = msg.getData();
            textView2_3.setText(bundle4.getString("제천시"));

            Bundle bundle6 = msg.getData();
            textView3_3.setText(bundle6.getString("충주시"));

            Bundle bundle8 = msg.getData();
            textView4_3.setText(bundle8.getString("음성군"));

            Bundle bundle10 = msg.getData();
            textView5_3.setText(bundle10.getString("괴산군"));

            Bundle bundle12 = msg.getData();
            textView6_3.setText(bundle12.getString("증평군"));

            Bundle bundle14 = msg.getData();
            textView7_3.setText(bundle14.getString("진천군"));


            Bundle bundle16 = msg.getData();
            textView8_3.setText(bundle16.getString("청주시"));


            Bundle bundle18 = msg.getData();
            textView9_3.setText(bundle18.getString("보은군"));

            Bundle bundle20 = msg.getData();
            textView10_3.setText(bundle20.getString("옥천군"));


            Bundle bundle22 = msg.getData();
            textView11_3.setText(bundle22.getString("영동군"));

        }
    };

}