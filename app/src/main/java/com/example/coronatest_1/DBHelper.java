package com.example.coronatest_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("MM/dd");

    private String getTime(){
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }


    String id = null;
    String url = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11&ncvContSeq=&contSeq=&board_id=&gubun=";
    String msg;
    final Bundle bundle = new Bundle();

    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuffer sb = new StringBuffer();
        sb.append( " CREATE TABLE CO_TABLE ( ");
        sb.append( " DATE INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append( " TODAY TEXT, " );

        // SQL 실행
        db.execSQL(sb.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "Version 올라감", Toast.LENGTH_SHORT).show();
    }

    public void testDB(){
        SQLiteDatabase db = getReadableDatabase();
    }

    public void adddata(PresentActivity presentActivity){

        new Thread() {
            @Override
            public void run() {
                Document doc = null;

                try {
                    doc = Jsoup.connect(url).get();
                    Elements elements = doc.select("p.inner_value");//테그로 가져오기

                    String today = elements.get(0).text();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        SQLiteDatabase db = getWritableDatabase();

        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO CO_TABLE ( ");
        sb.append("DATE, TODAY)");
        sb.append("VALUES(?,?)");

        db.execSQL(sb.toString(), new Object[]{
                presentActivity.getTime()
                , presentActivity.today});
    }


}