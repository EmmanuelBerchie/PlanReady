package com.example.berchie.planready;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class cls_tab_page_adapter extends FragmentStatePagerAdapter
{
    public cls_tab_page_adapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch(position)
        {
            case 0:
                home_fragment home_fragment = new home_fragment();

                return home_fragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return 1;
    }
}