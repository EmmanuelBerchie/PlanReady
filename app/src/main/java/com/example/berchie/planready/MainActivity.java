package com.example.berchie.planready;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Date date=new Date(System.currentTimeMillis());
    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy.MM.dd");
    String strNow = sdfNow.format(date);

    private android.support.v7.widget.Toolbar toolbar;
    private cls_view_pager viewPager;
    private ImageView img_calendar;
    private ImageView img_insert;
    private ImageView img_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = findViewById(R.id.pager);
        cls_tab_page_adapter tab_page_adapter = new cls_tab_page_adapter(getSupportFragmentManager());
        viewPager.setAdapter(tab_page_adapter);



        //Initializing the icons for the variables
        img_calendar = findViewById(R.id.img_calendar);
        img_insert = findViewById(R.id.img_insert);
        img_home = findViewById(R.id.img_home);

        // Action to commit when clicked
        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
                //img_home.setAlpha((float)1);
                //img_calendar.setAlpha((float)0.5);
            }
        });
        // Action to commit when clicked - Go to create a plan page
        img_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(intent);
            }
        });

        toolbar= findViewById(R.id.tbr_main);
        toolbar.setTitle(strNow);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        // Action to commit when clicked - Go to calendar page
        img_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity_Calendar.class);
                startActivity(intent);
            }
        });





    }
}
