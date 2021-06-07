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

public class Chungnam extends AppCompatActivity {

    TextView textView5, textView6, textView7, textView8;
    String url1 = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=";
    String url2 = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%BD%94%EB%A1%9C%EB%82%98+%ED%99%95%EC%A7%84%EC%9E%90";

    //지역
    TextView textView1_1, textView2_1, textView3_1, textView4_1, textView5_1, textView6_1, textView7_1, textView8_1, textView9_1, textView10_1;
    TextView textView11_1, textView12_1, textView13_1, textView14_1, textView15_1, textView16_1, textView17_1, textView18_1, textView19_1, textView20_1;
    TextView textView21_1, textView22_1, textView23_1, textView24_1, textView25_1, textView26_1;

    //당일 확진자
    TextView textView1_2, textView2_2, textView3_2, textView4_2, textView5_2, textView6_2, textView7_2, textView8_2, textView9_2, textView10_2;
    TextView textView11_2, textView12_2, textView13_2, textView14_2, textView15_2, textView16_2, textView17_2, textView18_2, textView19_2, textView20_2;
    TextView textView21_2, textView22_2, textView23_2, textView24_2, textView25_2, textView26_2;

    //총 확진자
    TextView textView1_3, textView2_3, textView3_3, textView4_3, textView5_3, textView6_3, textView7_3, textView8_3, textView9_3, textView10_3;
    TextView textView11_3, textView12_3, textView13_3, textView14_3, textView15_3, textView16_3, textView17_3, textView18_3, textView19_3, textView20_3;
    TextView textView21_3, textView22_3, textView23_3, textView24_3, textView25_3, textView26_3;


    String url = "http://www.chungnam.go.kr/coronaStatus.do?tab=1";

    final Bundle bundle = new Bundle();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chungnam);
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
                    Elements elements = doc.select(".new_tbl_board.mb20 td");//테그로 가져오기


                    textView1_1.setText("천안");
                    textView2_1.setText("공주");
                    textView3_1.setText("보령");
                    textView4_1.setText("아산");
                    textView5_1.setText("서산");
                    textView6_1.setText("논산");
                    textView7_1.setText("계룡");
                    textView8_1.setText("당진");
                    textView9_1.setText("금산");
                    textView10_1.setText("부여");
                    textView11_1.setText("서천");
                    textView12_1.setText("청양");
                    textView13_1.setText("홍성");
                    textView14_1.setText("예산");
                    textView15_1.setText("태안");
                    textView16_1.setText("기타");


                    for(int i = 30; i<100;i++) {
                        String a = elements.get(i).text();


                        if (i == 38) {
                            bundle.putString("천안총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 39) {
                            bundle.putString("공주총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 40) {
                            bundle.putString("보령총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 41) {
                            bundle.putString("아산총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 42) {
                            bundle.putString("서산총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 43) {
                            bundle.putString("논산총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 44) {
                            bundle.putString("계룡총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 45) {
                            bundle.putString("당진총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 46) {
                            bundle.putString("금산총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 47) {
                            bundle.putString("부여총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 48) {
                            bundle.putString("서천총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 49) {
                            bundle.putString("청양총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 50) {
                            bundle.putString("홍성총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 51) {
                            bundle.putString("예산총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 52) {
                            bundle.putString("태안총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 53) {
                            bundle.putString("기타총확진자", a);
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


                        if (i == 99) {
                            bundle.putString("충남총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i ==101 ) {
                            bundle.putString("충남완치", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 102 ) {
                            bundle.putString("충남사망", a);
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


                        if (i == 8) {
                            bundle.putString("충남신규확진자", a);
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
            textView6.setText(bundles6.getString("충남총확진자"));

            Bundle bundles7 = msg.getData();
            textView5.setText(bundles7.getString("충남신규확진자"));

            Bundle bundles8 = msg.getData();
            textView7.setText(bundles8.getString("충남완치"));

            Bundle bundles9 = msg.getData();
            textView8.setText(bundles9.getString("충남사망"));

           Bundle bundle2 = msg.getData();
            textView1_3.setText(bundle2.getString("천안총확진자"));

            Bundle bundle3 = msg.getData();
            textView2_3.setText(bundle3.getString("공주총확진자"));

            Bundle bundle4 = msg.getData();
            textView3_3.setText(bundle4.getString("보령총확진자"));

            Bundle bundle5 = msg.getData();
            textView4_3.setText(bundle5.getString("아산총확진자"));

            Bundle bundle6 = msg.getData();
            textView5_3.setText(bundle6.getString("서산총확진자"));

            Bundle bundle7 = msg.getData();
            textView6_3.setText(bundle7.getString("논산총확진자"));

            Bundle bundle8 = msg.getData();
            textView7_3.setText(bundle8.getString("계룡총확진자"));

            Bundle bundle9 = msg.getData();
            textView8_3.setText(bundle9.getString("당진총확진자"));

            Bundle bundle10 = msg.getData();
            textView9_3.setText(bundle10.getString("금산총확진자"));

            Bundle bundle11 = msg.getData();
            textView10_3.setText(bundle11.getString("부여총확진자"));

            Bundle bundle12 = msg.getData();
            textView11_3.setText(bundle12.getString("서천총확진자"));

            Bundle bundle13 = msg.getData();
            textView12_3.setText(bundle13.getString("청양총확진자"));

            Bundle bundle14 = msg.getData();
            textView13_3.setText(bundle14.getString("홍성총확진자"));

            Bundle bundle15 = msg.getData();
            textView14_3.setText(bundle15.getString("예산총확진자"));

            Bundle bundle16 = msg.getData();
            textView15_3.setText(bundle16.getString("태안총확진자"));

            Bundle bundle17 = msg.getData();
            textView16_3.setText(bundle17.getString("기타총확진자"));




        }
    };

}
