package com.example.berchie.planready;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;


public class cls_custom_dialog extends Dialog {
    TextView txt_done;
    TextView txt_cancel;
    ToggleButton tog_sun;
    ToggleButton tog_mon;
    ToggleButton tog_tus;
    ToggleButton tog_wed;
    ToggleButton tog_tur;
    ToggleButton tog_fri;
    ToggleButton tog_sat;

    public cls_custom_dialog(Context context)
    {
        super(context);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_dayofweek);

        tog_mon= findViewById(R.id.tog_mon);
        tog_tus= findViewById(R.id.tog_tus);
        tog_wed= findViewById(R.id.tog_wed);
        tog_tur= findViewById(R.id.tog_thu);
        tog_fri= findViewById(R.id.tog_fri);
        tog_sat= findViewById(R.id.tog_sat);
        tog_sun= findViewById(R.id.tog_sun);


            // IF/ELSE statement used to uncheck any button that is checked

        tog_mon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked==true)
                {
                    tog_mon.setTextColor(Color.parseColor("#00AAFF"));
                }
                else
                {
                    tog_mon.setTextColor(Color.BLACK);

                }
            }
        });

        tog_tus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked==true)
                {
                    tog_tus.setTextColor(Color.parseColor("#00AAFF"));
                }
                else
                {
                    tog_tus.setTextColor(Color.BLACK);
                }
            }
        });

        tog_wed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked==true)
                {
                    tog_wed.setTextColor(Color.parseColor("#00AAFF"));

                }
                else
                {
                    tog_wed.setTextColor(Color.BLACK);
                }
            }
        });

        tog_tur.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked==true)
                {
                    tog_tur.setTextColor(Color.parseColor("#00AAFF"));
                }
                else
                {
                    tog_tur.setTextColor(Color.BLACK);
                }
            }
        });

        tog_fri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked==true)
                {
                    tog_fri.setTextColor(Color.parseColor("#00AAFF"));
                }
                else
                {
                    tog_fri.setTextColor(Color.BLACK);
                }
            }
        });

        tog_sat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked==true)
                {
                    tog_sat.setTextColor(Color.parseColor("#00AAFF"));
                }
                else
                {
                    tog_sat.setTextColor(Color.BLACK);
                }
            }
        });

        tog_sun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked==true)
                {
                    tog_sun.setTextColor(Color.parseColor("#00AAFF"));

                }
                else
                {
                    tog_sun.setTextColor(Color.BLACK);

                }
            }
        });

        txt_done = findViewById(R.id.txt_done);
        txt_cancel = findViewById(R.id.txt_cancel);
       // complete function and then check for days picked below
        txt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // IF/else  to check whether the deselects a particular day

                String str_tog="";

                if(tog_mon.isChecked())
                {
                    str_tog+=tog_mon.getTextOn().toString();
                }
                else
                {
                    str_tog+=("");
                }

                if(tog_tus.isChecked())
                {
                    str_tog+=(tog_tus.getTextOn().toString());
                }
                else
                {
                    str_tog+=("");
                }

                if(tog_wed.isChecked())
                {
                    str_tog+=(tog_wed.getTextOn().toString());
                }
                else
                {
                    str_tog+=("");
                }

                if(tog_tur.isChecked())
                {
                    str_tog+=(tog_tur.getTextOn().toString());
                }
                else
                {
                    str_tog+=("");
                }

                if(tog_fri.isChecked())
                {
                    str_tog+=(tog_fri.getTextOn().toString());
                }
                else
                {
                    str_tog+=("");
                }

                if(tog_sat.isChecked())
                {
                    str_tog+=(tog_sat.getTextOn().toString());
                }
                else
                {
                    str_tog+=("");
                }

                if(tog_sun.isChecked())
                {
                    str_tog+=(tog_sun.getTextOn().toString());
                }
                else
                {
                    str_tog+=("");
                }
                // place days not selected in insert activity page for exp. TT for tuesday, Thursday
               InsertActivity.txt_day_of_week.setText(str_tog);
                dismiss();
            }
        });
        txt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

}
