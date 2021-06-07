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

public class Jeju extends AppCompatActivity {
    TextView textView5, textView6, textView7, textView8;
    String url = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=";
    String url2 = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%BD%94%EB%A1%9C%EB%82%98+%ED%99%95%EC%A7%84%EC%9E%90";
    final Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeju);

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
                    Elements elements = doc.select("td.number");//테그로 가져오기




                    for(int i = 0; i<200;i++) {
                        String a = elements.get(i).text();


                        if (i == 139) {
                            bundle.putString("제주총확진자", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }

                        if (i ==141 ) {
                            bundle.putString("제주완치", a);
                            Message mmsg = handler.obtainMessage();
                            mmsg.setData(bundle);
                            handler.sendMessage(mmsg);
                            continue;
                        }
                        if (i == 142 ) {
                            bundle.putString("제주사망", a);
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


                        if (i == 16) {
                            bundle.putString("제주신규확진자", a);
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
            textView6.setText(bundle6.getString("제주총확진자"));

            Bundle bundle7 = msg.getData();
            textView5.setText(bundle7.getString("제주신규확진자"));

            Bundle bundle8 = msg.getData();
            textView7.setText(bundle8.getString("제주완치"));

            Bundle bundle9 = msg.getData();
            textView8.setText(bundle9.getString("제주사망"));

        }
    };
}