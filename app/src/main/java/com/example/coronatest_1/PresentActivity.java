package com.example.coronatest_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PresentActivity extends AppCompatActivity {

    public Object today;
    //누적
    TextView textView1_1, textView2_1;

    //격리해제
    TextView textView1_2, textView2_2;

    //격리 중
    TextView textView1_3, textView2_3;

    //사망
    TextView textView1_4, textView2_4;

    //날
    TextView textView1_6, textView2_6;

    //일일확진자
    TextView textView1_7, textView2_7;

    TextView seoul, tseoul, busan, tbusan, daegu, tdaegu, incheon, tincheon, gwangju, tgwangju, daejeon, tdaejeon, ulsan, tulsan, saejong, tsaejong;
    TextView keongi, tkeongi, gangwon, tgangwon, chungbuk, tchungbuk, chungnam, tchungnam, jeonbuk, tjeonbuk, jeonnam, tjeonnam, keongbuk, tkeongbuk, keongnam, tkeongnam;
    TextView jeju, tjeju, x, tx;

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

    String getTime(){
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

        //지역별
        seoul = findViewById(R.id.seoul);
        tseoul = findViewById(R.id.tseoul);

        busan = findViewById(R.id.busan);
        tbusan = findViewById(R.id.tbusan);

        daegu = findViewById(R.id.daegu);
        tdaegu = findViewById(R.id.tdaegu);

        incheon = findViewById(R.id.incheon);
        tincheon = findViewById(R.id.tincheon);

        gwangju = findViewById(R.id.gwangju);
        tgwangju = findViewById(R.id.tgwangju);

        daejeon = findViewById(R.id.daejeon);
        tdaejeon = findViewById(R.id.tdaejeon);

        ulsan = findViewById(R.id.ulsan);
        tulsan = findViewById(R.id.tulsan);

        saejong = findViewById(R.id.saejong);
        tsaejong = findViewById(R.id.tsaejong);

        keongi = findViewById(R.id.keongi);
        tkeongi = findViewById(R.id.tkeongi);

        gangwon = findViewById(R.id.gangwon);
        tgangwon = findViewById(R.id.tgangwon);

        chungbuk = findViewById(R.id.chunbuk);
        tchungbuk = findViewById(R.id.tchunbuk);

        chungnam = findViewById(R.id.chunnam);
        tchungnam = findViewById(R.id.tchunnam);

        jeonbuk = findViewById(R.id.jeonbuk);
        tjeonbuk = findViewById(R.id.tjeonbuk);

        jeonnam = findViewById(R.id.jeonnam);
        tjeonnam = findViewById(R.id.tjeonnam);

        keongbuk = findViewById(R.id.keongbuk);
        tkeongbuk = findViewById(R.id.tkeongbuk);

        keongnam = findViewById(R.id.keongnam);
        tkeongnam = findViewById(R.id.tkeongnam);

        jeju = findViewById(R.id.jeju);
        tjeju = findViewById(R.id.tjeju);

        x = findViewById(R.id.x);
        tx = findViewById(R.id.tx);




        //btn = findViewById(R.id.btn);
        //tb = (TableLayout)findViewById(R.id.tableLayout);
        //tb.setVisibility(View.INVISIBLE);
        //btn.setOnClickListener(v);

        new Thread() {
            @Override
            public void run() {
                Document doc = null;
                Document doc2 = null;
                Document doc3 = null;

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

                    //String a5 = elements2.get(0).text();
                    bundle.putString("일일확진자", String.valueOf(a7));
                    Message mmsg6 = handler.obtainMessage();
                    mmsg6.setData(bundle);
                    handler.sendMessage(mmsg6);

                    doc3 = Jsoup.connect(url).get();
                    Elements elements3 = doc3.select("td.number");

                    String l1 = elements3.get(3).text();
                    bundle.putString("서울총", String.valueOf(l1));
                    Message msg1 = handler.obtainMessage();
                    msg1.setData(bundle);
                    handler.sendMessage(msg1);

                    String l2 = elements3.get(0).text();
                    bundle.putString("서울오늘", String.valueOf(l2));
                    Message msg2 = handler.obtainMessage();
                    msg2.setData(bundle);
                    handler.sendMessage(msg2);

                    String l3 = elements3.get(11).text();
                    bundle.putString("부산총", String.valueOf(l3));
                    Message msg3 = handler.obtainMessage();
                    msg3.setData(bundle);
                    handler.sendMessage(msg3);

                    String l4 = elements3.get(8).text();
                    bundle.putString("부산오늘", String.valueOf(l4));
                    Message msg4 = handler.obtainMessage();
                    msg4.setData(bundle);
                    handler.sendMessage(msg4);

                    String l5 = elements3.get(19).text();
                    bundle.putString("대구총", String.valueOf(l5));
                    Message msg5 = handler.obtainMessage();
                    msg5.setData(bundle);
                    handler.sendMessage(msg5);

                    String l6 = elements3.get(16).text();
                    bundle.putString("대구오늘", String.valueOf(l6));
                    Message msg6 = handler.obtainMessage();
                    msg6.setData(bundle);
                    handler.sendMessage(msg6);

                    String l7 = elements3.get(27).text();
                    bundle.putString("인천총", String.valueOf(l7));
                    Message msg7 = handler.obtainMessage();
                    msg7.setData(bundle);
                    handler.sendMessage(msg7);

                    String l8 = elements3.get(24).text();
                    bundle.putString("인천오늘", String.valueOf(l8));
                    Message msg8 = handler.obtainMessage();
                    msg8.setData(bundle);
                    handler.sendMessage(msg8);

                    String l9 = elements3.get(35).text();
                    bundle.putString("광주총", String.valueOf(l9));
                    Message msg9 = handler.obtainMessage();
                    msg9.setData(bundle);
                    handler.sendMessage(msg9);

                    String l10 = elements3.get(32).text();
                    bundle.putString("광주오늘", String.valueOf(l10));
                    Message msg10 = handler.obtainMessage();
                    msg10.setData(bundle);
                    handler.sendMessage(msg10);

                    String l11 = elements3.get(43).text();
                    bundle.putString("대전총", String.valueOf(l11));
                    Message msg11 = handler.obtainMessage();
                    msg11.setData(bundle);
                    handler.sendMessage(msg11);

                    String l12 = elements3.get(40).text();
                    bundle.putString("대전오늘", String.valueOf(l12));
                    Message msg12 = handler.obtainMessage();
                    msg12.setData(bundle);
                    handler.sendMessage(msg12);

                    String l13 = elements3.get(51).text();
                    bundle.putString("울산총", String.valueOf(l13));
                    Message msg13 = handler.obtainMessage();
                    msg13.setData(bundle);
                    handler.sendMessage(msg13);

                    String l14 = elements3.get(48).text();
                    bundle.putString("울산오늘", String.valueOf(l14));
                    Message msg14 = handler.obtainMessage();
                    msg14.setData(bundle);
                    handler.sendMessage(msg14);

                    String l15 = elements3.get(59).text();
                    bundle.putString("세종총", String.valueOf(l15));
                    Message msg15 = handler.obtainMessage();
                    msg15.setData(bundle);
                    handler.sendMessage(msg15);

                    String l16 = elements3.get(56).text();
                    bundle.putString("세종오늘", String.valueOf(l16));
                    Message msg16 = handler.obtainMessage();
                    msg16.setData(bundle);
                    handler.sendMessage(msg16);

                    String l17 = elements3.get(64).text();
                    bundle.putString("경기총", String.valueOf(l17));
                    Message msg17 = handler.obtainMessage();
                    msg17.setData(bundle);
                    handler.sendMessage(msg17);

                    String l18 = elements3.get(61).text();
                    bundle.putString("경기오늘", String.valueOf(l18));
                    Message msg18 = handler.obtainMessage();
                    msg18.setData(bundle);
                    handler.sendMessage(msg18);

                    String l19 = elements3.get(72).text();
                    bundle.putString("강원총", String.valueOf(l19));
                    Message msg19 = handler.obtainMessage();
                    msg19.setData(bundle);
                    handler.sendMessage(msg19);

                    String l20 = elements3.get(69).text();
                    bundle.putString("강원오늘", String.valueOf(l20));
                    Message msg20 = handler.obtainMessage();
                    msg20.setData(bundle);
                    handler.sendMessage(msg20);

                    String l21 = elements3.get(80).text();
                    bundle.putString("충북총", String.valueOf(l21));
                    Message msg21 = handler.obtainMessage();
                    msg21.setData(bundle);
                    handler.sendMessage(msg21);

                    String l22 = elements3.get(77).text();
                    bundle.putString("충북오늘", String.valueOf(l22));
                    Message msg22 = handler.obtainMessage();
                    msg22.setData(bundle);
                    handler.sendMessage(msg22);

                    String l23 = elements3.get(88).text();
                    bundle.putString("충남총", String.valueOf(l23));
                    Message msg23 = handler.obtainMessage();
                    msg23.setData(bundle);
                    handler.sendMessage(msg23);

                    String l24 = elements3.get(85).text();
                    bundle.putString("충남오늘", String.valueOf(l24));
                    Message msg24 = handler.obtainMessage();
                    msg24.setData(bundle);
                    handler.sendMessage(msg24);

                    String l25 = elements3.get(96).text();
                    bundle.putString("전북총", String.valueOf(l25));
                    Message msg25 = handler.obtainMessage();
                    msg25.setData(bundle);
                    handler.sendMessage(msg25);

                    String l26 = elements3.get(93).text();
                    bundle.putString("전북오늘", String.valueOf(l26));
                    Message msg26 = handler.obtainMessage();
                    msg26.setData(bundle);
                    handler.sendMessage(msg26);

                    String l27 = elements3.get(104).text();
                    bundle.putString("전남총", String.valueOf(l27));
                    Message msg27 = handler.obtainMessage();
                    msg27.setData(bundle);
                    handler.sendMessage(msg27);

                    String l28 = elements3.get(101).text();
                    bundle.putString("전남오늘", String.valueOf(l28));
                    Message msg28 = handler.obtainMessage();
                    msg28.setData(bundle);
                    handler.sendMessage(msg28);

                    String l29 = elements3.get(112).text();
                    bundle.putString("경북총", String.valueOf(l29));
                    Message msg29 = handler.obtainMessage();
                    msg29.setData(bundle);
                    handler.sendMessage(msg29);

                    String l30 = elements3.get(109).text();
                    bundle.putString("경북오늘", String.valueOf(l30));
                    Message msg30 = handler.obtainMessage();
                    msg30.setData(bundle);
                    handler.sendMessage(msg30);

                    String l31 = elements3.get(120).text();
                    bundle.putString("경남총", String.valueOf(l31));
                    Message msg31 = handler.obtainMessage();
                    msg31.setData(bundle);
                    handler.sendMessage(msg31);

                    String l32 = elements3.get(117).text();
                    bundle.putString("경남오늘", String.valueOf(l32));
                    Message msg32 = handler.obtainMessage();
                    msg32.setData(bundle);
                    handler.sendMessage(msg32);

                    String l33 = elements3.get(128).text();
                    bundle.putString("제주총", String.valueOf(l33));
                    Message msg33 = handler.obtainMessage();
                    msg33.setData(bundle);
                    handler.sendMessage(msg33);

                    String l34 = elements3.get(125).text();
                    bundle.putString("제주오늘", String.valueOf(l34));
                    Message msg34 = handler.obtainMessage();
                    msg34.setData(bundle);
                    handler.sendMessage(msg34);

                    String l35 = elements3.get(136).text();
                    bundle.putString("검역총", String.valueOf(l35));
                    Message msg35 = handler.obtainMessage();
                    msg35.setData(bundle);
                    handler.sendMessage(msg35);

                    String l36 = elements3.get(133).text();
                    bundle.putString("검역오늘", String.valueOf(l36));
                    Message msg36 = handler.obtainMessage();
                    msg36.setData(bundle);
                    handler.sendMessage(msg36);



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


            //표
            Bundle bundle11 = msg.getData();
            seoul.setText(bundle11.getString("서울총"));

            Bundle bundle12 = msg.getData();
            tseoul.setText(bundle12.getString("서울오늘"));

            Bundle bundle13 = msg.getData();
            busan.setText(bundle13.getString("부산총"));

            Bundle bundle14 = msg.getData();
            tbusan.setText(bundle14.getString("부산오늘"));

            Bundle bundle15 = msg.getData();
            daegu.setText(bundle15.getString("대구총"));

            Bundle bundle16 = msg.getData();
            tdaegu.setText(bundle16.getString("대구오늘"));

            Bundle bundle17 = msg.getData();
            incheon.setText(bundle17.getString("인천총"));

            Bundle bundle18 = msg.getData();
            tincheon.setText(bundle18.getString("인천오늘"));

            Bundle bundle19 = msg.getData();
            gwangju.setText(bundle19.getString("광주총"));

            Bundle bundle20 = msg.getData();
            tgwangju.setText(bundle20.getString("광주오늘"));

            Bundle bundle21 = msg.getData();
            daejeon.setText(bundle21.getString("대전총"));

            Bundle bundle22 = msg.getData();
            tdaejeon.setText(bundle22.getString("대전오늘"));

            Bundle bundle23 = msg.getData();
            ulsan.setText(bundle23.getString("울산총"));

            Bundle bundle24 = msg.getData();
            tulsan.setText(bundle24.getString("울산오늘"));

            Bundle bundle25 = msg.getData();
            saejong.setText(bundle25.getString("세종총"));

            Bundle bundle26 = msg.getData();
            tsaejong.setText(bundle26.getString("세종오늘"));

            Bundle bundle27 = msg.getData();
            keongi.setText(bundle27.getString("경기총"));

            Bundle bundle28 = msg.getData();
            tkeongi.setText(bundle28.getString("경기오늘"));

            Bundle bundle29 = msg.getData();
            gangwon.setText(bundle29.getString("강원총"));

            Bundle bundle30 = msg.getData();
            tgangwon.setText(bundle30.getString("강원오늘"));

            Bundle bundle31 = msg.getData();
            chungbuk.setText(bundle31.getString("충북총"));

            Bundle bundle32 = msg.getData();
            tchungbuk.setText(bundle32.getString("충북오늘"));

            Bundle bundle33 = msg.getData();
            chungnam.setText(bundle33.getString("충남총"));

            Bundle bundle34 = msg.getData();
            tchungnam.setText(bundle34.getString("충남오늘"));

            Bundle bundle35 = msg.getData();
            jeonbuk.setText(bundle35.getString("전북총"));

            Bundle bundle36 = msg.getData();
            tjeonbuk.setText(bundle36.getString("전북오늘"));

            Bundle bundle37 = msg.getData();
            jeonnam.setText(bundle37.getString("전남총"));

            Bundle bundle38 = msg.getData();
            tjeonnam.setText(bundle38.getString("전남오늘"));

            Bundle bundle39 = msg.getData();
            keongbuk.setText(bundle39.getString("경북총"));

            Bundle bundle40 = msg.getData();
            tkeongbuk.setText(bundle40.getString("경북오늘"));

            Bundle bundle41 = msg.getData();
            keongnam.setText(bundle41.getString("경남총"));

            Bundle bundle42 = msg.getData();
            tkeongnam.setText(bundle42.getString("경남오늘"));

            Bundle bundle43 = msg.getData();
            jeju.setText(bundle43.getString("제주총"));

            Bundle bundle44 = msg.getData();
            tjeju.setText(bundle44.getString("제주오늘"));

            Bundle bundle45 = msg.getData();
            x.setText(bundle45.getString("검역총"));

            Bundle bundle46 = msg.getData();
            tx.setText(bundle46.getString("검역오늘"));

        }
    };



}