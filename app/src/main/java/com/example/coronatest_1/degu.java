package com.example.coronatest_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class degu extends AppCompatActivity {
    TextView textView5, textView6, textView7, textView8;
    String url = "http://covid19.daegu.go.kr/index.html";
    final Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degu);

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
                    Elements elements = doc.select(".inr em");//테그로 가져오기




                    for(int i = 0; i<100;i++) {
                        String a = elements.get(i).text();


                        if (i == 0) {
                            bundle.putString("대구당일확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i ==1 ) {
                            bundle.putString("대구총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 8 ) {
                            bundle.putString("대구치료중", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }


                        if (i == 11) {
                            bundle.putString("사망", a);
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


            Bundle bundle6 = msg.getData();
            textView5.setText(bundle6.getString("대구당일확진자"));

            Bundle bundle7 = msg.getData();
            textView6.setText(bundle7.getString("대구총확진자"));

            Bundle bundle8 = msg.getData();
            textView7.setText(bundle8.getString("대구치료중"));

            Bundle bundle9 = msg.getData();
            textView8.setText(bundle9.getString("사망"));




        }
    };
}