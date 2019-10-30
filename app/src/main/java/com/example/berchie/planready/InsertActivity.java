package com.example.berchie.planready;

import android.app.TimePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class InsertActivity extends AppCompatActivity {

    private EditText edit_plan;
    public static EditText studyTime;
    public static TextView txt_day_of_week;
    private ImageView img_done;
    private TextView txt_alarm_time;
    public static TextView txt_insert_date;
    private Switch swi_alarm;
    public static TextView txt_date_total;

    cls_cursor_adapter myAdapter;
    SQLiteDatabase db;
    db_create dbCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Calendar date = new GregorianCalendar();
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy.MM.dd");
        String formatDate = sdfNow.format(date.getTime());

        dbCreate = new db_create(this);
        db=dbCreate.getWritableDatabase();

        edit_plan = findViewById(R.id.edit_plan);
        studyTime = findViewById(R.id.studyTime);
        txt_day_of_week = findViewById(R.id.txt_day_of_week);
        img_done = findViewById(R.id.img_done);
        txt_alarm_time = findViewById(R.id.txt_alarm_time);
        txt_insert_date = findViewById(R.id.txt_insert_date);
        swi_alarm = findViewById(R.id.swi_alarm);
        txt_date_total = findViewById(R.id.txt_date_total);
        // format date
        txt_insert_date.setText(formatDate + " - " + formatDate);
        txt_day_of_week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //open day picker dialog
                cls_custom_dialog dialog = new cls_custom_dialog(InsertActivity.this);
                dialog.show();
            }
        });
        // set time picker format
        final TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                txt_alarm_time.setText(hourOfDay + ":" + minute);
            }
        };
        // Open calendar dialog
        txt_insert_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cls_dialog_time dialog = new cls_dialog_time(InsertActivity.this);
                dialog.show();
            }
        });
        //Open Time picker dialog
        txt_alarm_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog dialog = new TimePickerDialog(InsertActivity.this, listener, 0, 0, false);
                dialog.show();
            }
        });
        // When the switch button is clicked the alarm will be allowed to be selected
        swi_alarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    txt_alarm_time.setClickable(true);
                    txt_alarm_time.setTextColor(Color.parseColor("#00aaff"));
                } else {
                    txt_alarm_time.setClickable(false);
                    txt_alarm_time.setTextColor(Color.parseColor("#d6d7d7"));
                }
            }
        });
        // When the done icon is clicked the data inputted will be stored in the MyTable database
        img_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plan = edit_plan.getText().toString();
                int studytime = Integer.parseInt(studyTime.getText().toString());
                String dayOfWeek = txt_day_of_week.getText().toString();
                String date = txt_insert_date.getText().toString();
                int totalDay = Integer.parseInt(txt_date_total.getText().toString());
                String alarm = txt_alarm_time.getText().toString();
                String query = String.format("INSERT INTO %s VALUES ( null, '%s', %d,'%s', '%s', %d, '%s' );", "myTable", plan, studytime, dayOfWeek, date, totalDay, alarm);
                Log.d("insert plan", query);
                db.execSQL(query);
                finish();
            }
        });

    }
}