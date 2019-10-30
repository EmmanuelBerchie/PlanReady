package com.example.berchie.planready;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;




public class home_fragment extends Fragment {
    ViewGroup rootView;
    ListView listView;
    cls_cursor_adapter myAdapter;
    SQLiteDatabase db;
    Cursor cursor;
    db_create dbCreate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);

        rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home, container, false);

        return rootView;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        dbCreate = new db_create(getActivity());
        db=dbCreate.getWritableDatabase();

        cursor = db.rawQuery("SELECT * FROM myTable", null);
        // retrieve the plan title from the adpapter class
        myAdapter = new cls_cursor_adapter(getActivity(), cursor);

        listView= rootView.findViewById(R.id.list_home);

        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(onItemClickListener);
    }

    public AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    };
}
