package com.example.coronatest_1;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button btn_corona;
    Button btn_map;
    Button btn_vac;

    @Override
    protected void onCreate(Bundle savedlnstanceState){
        super.onCreate(savedlnstanceState);
        setContentView(R.layout.activity_main);

        btn_corona = (Button)findViewById(R.id.btn_corona);
        btn_corona.setOnClickListener(this);
        btn_map= (Button)findViewById(R.id.btn_map);
        btn_map.setOnClickListener(this);
        btn_vac= (Button)findViewById(R.id.btn_vac);
        btn_vac.setOnClickListener(this);

       /* btn_corona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Present.class);
                startActivity(intent);
            }
        });*/
    }


    @Override
     public void onClick(View v) {
        if(v.getId()==R.id.btn_corona){
            Intent intent1 = new Intent(MainActivity.this, PresentActivity.class);
            startActivity(intent1);
        }
        else if(v.getId()==R.id.btn_map){
            Intent intent2 = new Intent(MainActivity.this, GMapsActivity.class);
            startActivity(intent2);
        }
        else if(v.getId()==R.id.btn_vac){
            Intent intent3 = new Intent(MainActivity.this, VacActivity.class);
            startActivity(intent3);
        }
    }
}