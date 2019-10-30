package com.example.berchie.planready;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

// For this dialog to work these two text files will be needed
import static com.example.berchie.planready.InsertActivity.txt_date_total;
import static com.example.berchie.planready.InsertActivity.txt_insert_date;


public class cls_dialog_time extends Dialog {

    private TextView txt_start_date;
    private TextView txt_end_date;
    private TextView txt_total_day;
    private Button btn_check_time;
    final Calendar date = new GregorianCalendar();
    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy.MM.dd");
    final String formatDate = sdfNow.format(date.getTime());
    // re-naming calendars
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();


    public cls_dialog_time(final Context context) {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_time);

        txt_start_date = findViewById(R.id.txt_start_date);
        txt_end_date = findViewById(R.id.txt_end_date);
        txt_total_day = findViewById(R.id.txt_total_day);
        btn_check_time = findViewById(R.id.btn_check_time);

        txt_start_date.setText(formatDate);
        txt_end_date.setText(formatDate);
        //format date for dialog
        final DatePickerDialog.OnDateSetListener listener_start = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txt_start_date.setText(year + "." + (month + 1) + "." + dayOfMonth);
                c1.set(year, month, dayOfMonth);
                //Subtract  2nd calendar from 1st calendar to get total days
                txt_total_day.setText(String.valueOf((c2.getTime().getTime()-c1.getTime().getTime())/(1000*60*60*24)+1));
                txt_date_total.setText(txt_total_day.getText().toString());
            }
        };

        final DatePickerDialog.OnDateSetListener listenr_end = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txt_end_date.setText(year + "." + (month + 1) + "." + dayOfMonth);
                c2.set(year, month, dayOfMonth);
                //Subtract  2nd calendar from 1st calendar to get total days
                txt_total_day.setText(String.valueOf((c2.getTime().getTime()-c1.getTime().getTime())/(1000*60*60*24)+1));
                txt_date_total.setText(txt_total_day.getText().toString());
            }
        };
            //Set start dates for Date pickers
        txt_start_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(new cls_dialog_time(context).getContext(), listener_start, 2019, 0, 19);
                datePickerDialog.show();
            }
        });

        txt_end_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(new cls_dialog_time(context).getContext(), listenr_end, 2019, 1, 17);
                datePickerDialog.show();
            }
        });

        btn_check_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_insert_date.setText(txt_start_date.getText().toString() + " - " + txt_end_date.getText().toString());
                dismiss();
            }
        });

    }
}

