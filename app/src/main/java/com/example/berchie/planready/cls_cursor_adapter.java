package com.example.berchie.planready;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class cls_cursor_adapter extends CursorAdapter {
    public cls_cursor_adapter(Context context, Cursor c)
    {
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        //Retrieving column plan from database myTable
        TextView txt_plan_title = view.findViewById(R.id.txt_plan_title);
        String planTitle = cursor.getString(cursor.getColumnIndex("plan"));
        txt_plan_title.setText(planTitle);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent)
    {
        //  inflate listview_home
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.listview_home, parent, false);
        return v;
    }
}
