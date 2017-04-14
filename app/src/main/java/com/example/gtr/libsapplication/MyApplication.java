package com.example.gtr.libsapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by GTR on 2017/4/4.
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext= getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
