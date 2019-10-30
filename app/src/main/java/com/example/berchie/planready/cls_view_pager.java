package com.example.berchie.planready;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.io.PrintWriter;
import java.io.StringWriter;


public class cls_view_pager extends ViewPager {
    private boolean enabled;

    public cls_view_pager(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.enabled=true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        try {
            if(this.enabled)
            {
                return super.onTouchEvent(event);
            }
        }
        catch (Exception e)
        {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            Log.e("INFO", exceptionAsString);
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event)
    {
        if(this.enabled)
        {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }


}
