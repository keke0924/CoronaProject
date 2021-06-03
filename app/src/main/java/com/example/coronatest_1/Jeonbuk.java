package com.example.coronatest_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TableLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Jeonbuk extends AppCompatActivity {
    TableLayout tb;
    //지역
    TextView textView1_1, textView2_1, textView3_1, textView4_1, textView5_1, textView6_1, textView7_1, textView8_1, textView9_1, textView10_1;
    TextView textView11_1, textView12_1, textView13_1, textView14_1, textView15_1;


    //총 확진자
    TextView textView1_3, textView2_3, textView3_3, textView4_3, textView5_3, textView6_3, textView7_3, textView8_3, textView9_3, textView10_3;
    TextView textView11_3, textView12_3, textView13_3, textView14_3, textView15_3;

    String url = "https://www.jeonbuk.go.kr/board/list.jeonbuk?boardId=BBS_0000105&menuCd=DOM_000000110001000000&contentsSid=1219&cpath=";
    final Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeonbuk);
        //지역
        textView1_1 = findViewById(R.id.textViewg1_1);
        textView2_1 = findViewById(R.id.textViewg2_1);
        textView3_1 = findViewById(R.id.textViewg3_1);
        textView4_1 = findViewById(R.id.textViewg4_1);
        textView5_1 = findViewById(R.id.textViewg5_1);
        textView6_1 = findViewById(R.id.textViewg6_1);
        textView7_1 = findViewById(R.id.textViewg7_1);
        textView8_1 = findViewById(R.id.textViewg8_1);
        textView9_1 = findViewById(R.id.textViewg9_1);
        textView10_1 = findViewById(R.id.textViewg10_1);
        textView11_1 = findViewById(R.id.textViewg11_1);
        textView12_1 = findViewById(R.id.textViewg12_1);
        textView13_1 = findViewById(R.id.textViewg13_1);
        textView14_1 = findViewById(R.id.textViewg14_1);
        textView15_1 = findViewById(R.id.textViewg15_1);


        //총
        textView1_3 = findViewById(R.id.textViewg1_3);
        textView2_3 = findViewById(R.id.textViewg2_3);
        textView3_3 = findViewById(R.id.textViewg3_3);
        textView4_3 = findViewById(R.id.textViewg4_3);
        textView5_3 = findViewById(R.id.textViewg5_3);
        textView6_3 = findViewById(R.id.textViewg6_3);
        textView7_3 = findViewById(R.id.textViewg7_3);
        textView8_3 = findViewById(R.id.textViewg8_3);
        textView9_3 = findViewById(R.id.textViewg9_3);
        textView10_3 = findViewById(R.id.textViewg10_3);
        textView11_3 = findViewById(R.id.textViewg11_3);
        textView12_3 = findViewById(R.id.textViewg12_3);
        textView13_3 = findViewById(R.id.textViewg13_3);
        textView14_3 = findViewById(R.id.textViewg14_3);
        textView15_3 = findViewById(R.id.textViewg15_3);

        textView1_1.setText("전주시");
        textView2_1.setText("강동구");
        textView3_1.setText("강북구");
        textView4_1.setText("강서구");
        textView5_1.setText("관악구");
        textView6_1.setText("광진구");
        textView7_1.setText("구로구");
        textView8_1.setText("금천구");
        textView9_1.setText("노원구");
        textView10_1.setText("도봉구");
        textView11_1.setText("동대문구");
        textView12_1.setText("동작구");
        textView13_1.setText("마포구");
        textView14_1.setText("서대문구");
        textView15_1.setText("서초구");

        new Thread(){
            @Override
            public void run(){
                Document doc = null;
                try{
                    doc = Jsoup.connect(url).get();
                    Elements elements = doc.select(".city");//태그로 가져오기



                    for(int i = 0; i<70;i++) {
                        String a = elements.select("strong").get(i).text();

                        if (i == 1) {
                            bundle.putString("전주시총확진자", a);
                            Message mmsg2 = handler.obtainMessage();
                            mmsg2.setData(bundle);
                            handler.sendMessage(mmsg2);
                            continue;
                        }

                        if (i == 2) {
                            bundle.putString("군산시총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 3) {
                            bundle.putString("익산시총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 4) {
                            bundle.putString("정읍시총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 5) {
                            bundle.putString("남원시총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 6) {
                            bundle.putString("김제시총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 7) {
                            bundle.putString("완주군총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 8) {
                            bundle.putString("진안군총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 9) {
                            bundle.putString("무주군총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 10) {
                            bundle.putString("장수군총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 11) {
                            bundle.putString("임실군총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 12) {
                            bundle.putString("순창군총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 13) {
                            bundle.putString("고창군총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i == 14) {
                            bundle.putString("부안군총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 15) {
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
    }







    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg){

            Bundle bundle2 = msg.getData();
            textView1_3.setText(bundle2.getString("전주시총확진자"));

            Bundle bundle3 = msg.getData();
            textView2_3.setText(bundle3.getString("군산시총확진자"));

            Bundle bundle4 = msg.getData();
            textView3_3.setText(bundle4.getString("익산시총확진자"));

            Bundle bundle5 = msg.getData();
            textView4_3.setText(bundle5.getString("정읍시총확진자"));

            Bundle bundle6 = msg.getData();
            textView5_3.setText(bundle6.getString("남원시총확진자"));

            Bundle bundle7 = msg.getData();
            textView6_3.setText(bundle7.getString("김제시총확진자"));

            Bundle bundle8 = msg.getData();
            textView7_3.setText(bundle8.getString("완주군총확진자"));

            Bundle bundle9 = msg.getData();
            textView8_3.setText(bundle9.getString("진안군총확진자"));

            Bundle bundle10 = msg.getData();
            textView9_3.setText(bundle10.getString("무주군총확진자"));

            Bundle bundle11 = msg.getData();
            textView10_3.setText(bundle11.getString("장수군총확진자"));

            Bundle bundle12 = msg.getData();
            textView11_3.setText(bundle12.getString("임실군총확진자"));

            Bundle bundle13 = msg.getData();
            textView12_3.setText(bundle13.getString("순창군총확진자"));

            Bundle bundle14 = msg.getData();
            textView13_3.setText(bundle14.getString("고창군총확진자"));

            Bundle bundle15 = msg.getData();
            textView14_3.setText(bundle15.getString("부안군총확진자"));

            Bundle bundle16 = msg.getData();
            textView15_3.setText(bundle16.getString("기타총확진자"));

        }
    };

}