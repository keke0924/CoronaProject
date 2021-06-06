package com.example.coronatest_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PresentActivity extends AppCompatActivity {
    TableLayout tb;
    //누적
    TextView textView1_1, textView2_1;

    //격리해제
    TextView textView1_2, textView2_2;

    //격리 중
    TextView textView1_3, textView2_3;

    //사망
    TextView textView1_4, textView2_4;

    //날짜
    TextView textView1_6, textView2_6;

    //일일확진자
    TextView textView1_7, textView2_7;

    String id = null;
    String url = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11&ncvContSeq=&contSeq=&board_id=&gubun=";
    String msg;
    final Bundle bundle = new Bundle();


    Button btn;

    private static final String TAG_STACK = "stack";
    private static final String TAG_TODAY = "clear";
    private static final String TAG_CURE = "cure";
    private static final String TAG_DEAD = "dead";

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("MM/dd");

    private String getTime(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present2);
        //누적
        textView1_1 = findViewById(R.id.textView1_1);

        //격리해제
        textView1_2 = findViewById(R.id.textView1_2);
        textView2_2 = findViewById(R.id.textView2_2);

        //격리중
        textView1_3 = findViewById(R.id.textView1_3);
        textView2_3 = findViewById(R.id.textView2_3);

        //사망
        textView1_4 = findViewById(R.id.textView1_4);
        textView2_4 = findViewById(R.id.textView2_4);

        //날짜
        textView1_6 = findViewById(R.id.textView1_6);

        //일일확진자
        textView2_1 = findViewById(R.id.textView2_1);
        textView1_7 = findViewById(R.id.textView1_7);


        //btn = findViewById(R.id.btn);
        //tb = (TableLayout)findViewById(R.id.tableLayout);
        //tb.setVisibility(View.INVISIBLE);
        //btn.setOnClickListener(v);

        new Thread() {
            @Override
            public void run() {
                Document doc = null;
                Document doc2 = null;

                try {
                    doc = Jsoup.connect(url).get();
                    Elements elements = doc.select("dd.ca_value");//테그로 가져오기

                    //누적
                    String a = elements.get(0).text();
                    bundle.putString("누적", String.valueOf(a));
                    Message mmsg = handler.obtainMessage();
                    mmsg.setData(bundle);
                    handler.sendMessage(mmsg);


                    //격리해제
                    String a2 = elements.get(2).text();
                    bundle.putString("격리해제", String.valueOf(a2));
                    Message mmsg2 = handler.obtainMessage();
                    mmsg2.setData(bundle);
                    handler.sendMessage(mmsg2);

                    String a8 = elements.get(3).text();
                    bundle.putString("전날해제", String.valueOf(a8));
                    Message mmsg8 = handler.obtainMessage();
                    mmsg8.setData(bundle);
                    handler.sendMessage(mmsg8);

                    //격리중
                    String a3 = elements.get(4).text();
                    bundle.putString("격리중", String.valueOf(a3));
                    Message mmsg3 = handler.obtainMessage();
                    mmsg3.setData(bundle);
                    handler.sendMessage(mmsg3);

                    String a9 = elements.get(5).text();
                    bundle.putString("전날격리", String.valueOf(a9));
                    Message mmsg9 = handler.obtainMessage();
                    mmsg9.setData(bundle);
                    handler.sendMessage(mmsg9);

                    //사망
                    String a4 = elements.get(6).text();
                    bundle.putString("사망", String.valueOf(a4));
                    Message mmsg4 = handler.obtainMessage();
                    mmsg4.setData(bundle);
                    handler.sendMessage(mmsg4);

                    String a10 = elements.get(7).text();
                    bundle.putString("전날사망", String.valueOf(a10));
                    Message mmsg10 = handler.obtainMessage();
                    mmsg10.setData(bundle);
                    handler.sendMessage(mmsg10);

                    String d = getTime();
                    bundle.putString("날짜", d);
                    Message daym = handler.obtainMessage();
                    daym.setData(bundle);
                    handler.sendMessage(daym);

                    doc2 = Jsoup.connect(url).get();
                    Elements elements2 = doc2.select("p.inner_value");//테그로 가져오기

                    String a7 = elements2.get(0).text();
                    bundle.putString("전날누적", String.valueOf(a7));
                    Message mmsg7 = handler.obtainMessage();
                    mmsg7.setData(bundle);
                    handler.sendMessage(mmsg7);

                    String a5 = elements2.get(0).text();
                    bundle.putString("일일확진자", String.valueOf(a5));
                    Message mmsg6 = handler.obtainMessage();
                    mmsg6.setData(bundle);
                    handler.sendMessage(mmsg6);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    @SuppressLint("HandlerLeak")

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            Bundle bundle1 = msg.getData();
            textView1_1.setText(bundle1.getString("누적"));

            Bundle bundle2 = msg.getData();
            textView1_2.setText(bundle2.getString("격리해제"));

            Bundle bundle8 = msg.getData();
            textView2_2.setText(bundle8.getString("전날해제"));

            Bundle bundle3 = msg.getData();
            textView1_3.setText(bundle3.getString("격리중"));

            Bundle bundle9 = msg.getData();
            textView2_3.setText(bundle9.getString("전날격리"));

            Bundle bundle4 = msg.getData();
            textView1_4.setText(bundle4.getString("사망"));

            Bundle bundle10 = msg.getData();
            textView2_4.setText(bundle10.getString("전날사망"));

            Bundle bundle5 = msg.getData();
            textView1_6.setText(bundle5.getString("날짜"));

            Bundle bundle7 = msg.getData();
            textView2_1.setText(bundle7.getString("전날누적"));

            Bundle bundle6 = msg.getData();
            textView1_7.setText(bundle6.getString("일일확진자"));

        }
    };

}