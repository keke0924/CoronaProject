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

public class Seoul extends AppCompatActivity {
    TableLayout tb;
    TextView textView1_1;
    TextView textView1_2;
    TextView textView1_3;
    String id = null;
    String url = "https://www.seoul.go.kr/coronaV/coronaStatus.do";
    String msg;
    final Bundle bundle = new Bundle();
    String seoultoday = null;
    String seoultotal = null;
    String 강남구총확진자 = null;
    String 강남구오늘확진자 = null;
    String 강동구총확진자 = null;
    String 강북구총확진자 = null;
    String 강서구총확진자 = null;
    String 관악구총확진자 = null;
    String 광진구총확진자 = null;
    String 구로구총확진자 = null;
    String 금천구총확진자 = null;
    String 노원구총확진자 = null;
    String 도봉구총확진자 = null;
    Button btn;

    private static final String TAG_LOCAL = "local";
    private static final String TAG_TODAY ="today";
    private static final String TAG_TOTAL ="total";

    SQLiteDatabase sampleDB = null;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seoul);
        textView1_1 = findViewById(R.id.textView1_1);
        textView1_2 = findViewById(R.id.textView1_2);
        textView1_3 = findViewById(R.id.textView1_3);
        btn = findViewById(R.id.btn);
        tb = (TableLayout)findViewById(R.id.tableLayout);
        tb.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(v);
    }

    View.OnClickListener v = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            new Thread(){
                @Override
                public void run(){
                    Document doc = null;
                    try{
                        doc = Jsoup.connect(url).get();
                        Elements elements = doc.select("tbody > tr");//테그로 가져오기

                        강남구총확진자 = elements.select("td").get(0).text();
                        강남구오늘확진자 = elements.select("td").get(1).text();

                        //msg = elements.text();

                        textView1_1.setText("강남구");
                        bundle.putString("message",강남구오늘확진자 );
                        Message mmsg = handler.obtainMessage();
                        mmsg.setData(bundle);
                        handler.sendMessage(mmsg);


                        bundle.putString("mes",강남구총확진자 );
                        Message mmsg2 = handler.obtainMessage();
                        mmsg2.setData(bundle);
                        handler.sendMessage(mmsg2);


                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }.start();
            tb.setVisibility(View.VISIBLE);
        }
    };

    @SuppressLint("HandlerLeak")

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg){
            Bundle bundle = msg.getData();
            textView1_2.setText(bundle.getString("message"));

            Bundle bundle2 = msg.getData();
            textView1_3.setText(bundle2.getString("mes"));
        }
    };

}