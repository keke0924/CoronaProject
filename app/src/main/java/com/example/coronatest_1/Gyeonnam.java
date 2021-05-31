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

public class Gyeonnam extends AppCompatActivity {
    TableLayout tb;
    //지역
    TextView textView1_1, textView2_1, textView3_1, textView4_1, textView5_1, textView6_1, textView7_1, textView8_1, textView9_1, textView10_1;
    TextView textView11_1, textView12_1, textView13_1, textView14_1, textView15_1, textView16_1, textView17_1, textView18_1, textView19_1, textView20_1;


    //당일 확진자
    TextView textView1_2, textView2_2, textView3_2, textView4_2, textView5_2, textView6_2, textView7_2, textView8_2, textView9_2, textView10_2;
    TextView textView11_2, textView12_2, textView13_2, textView14_2, textView15_2, textView16_2, textView17_2, textView18_2, textView19_2, textView20_2;


    //총 확진자
    TextView textView1_3, textView2_3, textView3_3, textView4_3, textView5_3, textView6_3, textView7_3, textView8_3, textView9_3, textView10_3;
    TextView textView11_3, textView12_3, textView13_3, textView14_3, textView15_3, textView16_3, textView17_3, textView18_3, textView19_3, textView20_3;


    String id = null;
    String url = "http://xn--19-q81ii1knc140d892b.kr/main/main.do";
    String msg;
    final Bundle bundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyeonnam);
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


        new Thread(){
            @Override
            public void run(){
                Document doc = null;
                try{
                    doc = Jsoup.connect(url).get();
                    Elements elements = doc.select("tbody > tr > td");//태태그로 가져오기

                    textView1_1.setText("창원");
                    textView2_1.setText("진주");
                    textView3_1.setText("통영");
                    textView4_1.setText("사천");
                    textView5_1.setText("김해");
                    textView6_1.setText("밀양");
                    textView7_1.setText("거제");
                    textView8_1.setText("양산");
                    textView9_1.setText("의령");
                    textView10_1.setText("함안");
                    textView11_1.setText("창녕");
                    textView12_1.setText("고성");
                    textView13_1.setText("남해");
                    textView14_1.setText("하동");
                    textView15_1.setText("산청");
                    textView16_1.setText("함양");
                    textView17_1.setText("거창");
                    textView18_1.setText("합천");


                    for(int i = 0; i<70;i++) {
                        String a = elements.get(i).text();

//                        if (i == 0) {
//                            bundle.putString("강남구총확진자", a);
//                            Message mmsg2 = handler.obtainMessage();
//                            mmsg2.setData(bundle);
//                            handler.sendMessage(mmsg2);
//                            continue;
//                        }

                        if (i == 2) {
                            bundle.putString("창원총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 3) {
                            bundle.putString("진주총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 4) {
                            bundle.putString("통영총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 5) {
                            bundle.putString("사천총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 6) {
                            bundle.putString("김해총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 7) {
                            bundle.putString("밀양총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 8) {
                            bundle.putString("거제총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 9) {
                            bundle.putString("양산총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 10) {
                            bundle.putString("의령총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 11) {
                            bundle.putString("함안총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 12) {
                            bundle.putString("창녕총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 13) {
                            bundle.putString("고성총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 14) {
                            bundle.putString("남해총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 15) {
                            bundle.putString("하동총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 16) {
                            bundle.putString("산청총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 17) {
                            bundle.putString("함양총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 18) {
                            bundle.putString("거창총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 19) {
                            bundle.putString("합천총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

//                        if (i == 19) {
//                            bundle.putString("중구총확진자", a);
//                            Message mmsg = handler.obtainMessage();
//                            mmsg.setData(bundle);
//                            handler.sendMessage(mmsg);
//                            continue;
//                        }

                        if (i == 22) {
                            bundle.putString("창원당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 23) {
                            bundle.putString("진주당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 24) {
                            bundle.putString("통영당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 25) {
                            bundle.putString("사천당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 26) {
                            bundle.putString("김해당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 27) {
                            bundle.putString("밀양당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 28) {
                            bundle.putString("거제당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 29) {
                            bundle.putString("양산당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 30) {
                            bundle.putString("의령당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 31) {
                            bundle.putString("함안당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 32) {
                            bundle.putString("창녕당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 33) {
                            bundle.putString("고성당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 34) {
                            bundle.putString("남해당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 35) {
                            bundle.putString("하동당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 36) {
                            bundle.putString("산청당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 37) {
                            bundle.putString("함양당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 38) {
                            bundle.putString("거창당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 39) {
                            bundle.putString("합천당일확진자", a);
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

            Bundle bundle2 = msg.getData();
            textView1_3.setText(bundle2.getString("창원총확진자"));

            Bundle bundle3 = msg.getData();
            textView2_3.setText(bundle3.getString("진주총확진자"));

            Bundle bundle4 = msg.getData();
            textView3_3.setText(bundle4.getString("통영총확진자"));

            Bundle bundle5 = msg.getData();
            textView4_3.setText(bundle5.getString("사천총확진자"));

            Bundle bundle6 = msg.getData();
            textView5_3.setText(bundle6.getString("김해총확진자"));

            Bundle bundle7 = msg.getData();
            textView6_3.setText(bundle7.getString("밀양총확진자"));

            Bundle bundle8 = msg.getData();
            textView7_3.setText(bundle8.getString("거제총확진자"));

            Bundle bundle9 = msg.getData();
            textView8_3.setText(bundle9.getString("양산총확진자"));

            Bundle bundle10 = msg.getData();
            textView9_3.setText(bundle10.getString("의령총확진자"));

            Bundle bundle11 = msg.getData();
            textView10_3.setText(bundle11.getString("함안총확진자"));

            Bundle bundle12 = msg.getData();
            textView11_3.setText(bundle12.getString("창녕총확진자"));

            Bundle bundle13 = msg.getData();
            textView12_3.setText(bundle13.getString("고성총확진자"));

            Bundle bundle14 = msg.getData();
            textView13_3.setText(bundle14.getString("남해총확진자"));

            Bundle bundle15 = msg.getData();
            textView14_3.setText(bundle15.getString("하동총확진자"));

            Bundle bundle16 = msg.getData();
            textView15_3.setText(bundle16.getString("산청총확진자"));

            Bundle bundle17 = msg.getData();
            textView16_3.setText(bundle17.getString("함양총확진자"));

            Bundle bundle18 = msg.getData();
            textView17_3.setText(bundle18.getString("거창총확진자"));

            Bundle bundle1 = msg.getData();
            textView18_3.setText(bundle1.getString("합천총확진자"));

            Bundle bundle19 = msg.getData();
            textView1_2.setText(bundle19.getString("창원당일확진자"));

            Bundle bundle20 = msg.getData();
            textView2_2.setText(bundle20.getString("진주당일확진자"));

            Bundle bundle21 = msg.getData();
            textView3_2.setText(bundle21.getString("통영당일확진자"));

            Bundle bundle22 = msg.getData();
            textView4_2.setText(bundle22.getString("사천당일확진자"));

            Bundle bundle23 = msg.getData();
            textView5_2.setText(bundle23.getString("김해당일확진자"));

            Bundle bundle24 = msg.getData();
            textView6_2.setText(bundle24.getString("밀양당일확진자"));

            Bundle bundle25 = msg.getData();
            textView7_2.setText(bundle25.getString("거제당일확진자"));

            Bundle bundle26 = msg.getData();
            textView8_2.setText(bundle26.getString("양산당일확진자"));

            Bundle bundle27 = msg.getData();
            textView9_2.setText(bundle27.getString("의령당일확진자"));

            Bundle bundle = msg.getData();
            textView10_2.setText(bundle.getString("함안당일확진자"));

            Bundle bundle28 = msg.getData();
            textView11_2.setText(bundle28.getString("창녕당일확진자"));

            Bundle bundle29 = msg.getData();
            textView12_2.setText(bundle29.getString("고성당일확진자"));

            Bundle bundle30 = msg.getData();
            textView13_2.setText(bundle30.getString("남해당일확진자"));

            Bundle bundle31 = msg.getData();
            textView14_2.setText(bundle31.getString("하동당일확진자"));

            Bundle bundle32 = msg.getData();
            textView15_2.setText(bundle32.getString("산청당일확진자"));

            Bundle bundle33 = msg.getData();
            textView16_2.setText(bundle33.getString("함양당일확진자"));

            Bundle bundle34 = msg.getData();
            textView17_2.setText(bundle34.getString("거창당일확진자"));

            Bundle bundle35 = msg.getData();
            textView18_2.setText(bundle35.getString("합천당일확진자"));

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