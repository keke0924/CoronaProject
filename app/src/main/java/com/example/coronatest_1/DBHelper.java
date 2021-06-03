package com.example.coronatest_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

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
        SQLiteDatabase db = getWritableDatabase();

        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO CO_TABLE ( ");
        sb.append("DATE, TODAY)");
        sb.append("VALUES(?,?)");

        db.execSQL(sb.toString(), new Object[]{
                presentActivity.mFormat
                , presentActivity.textView1_7});
    }


}