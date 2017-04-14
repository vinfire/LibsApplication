package com.example.gtr.libsapplication;

import android.app.Application;
import android.content.Context;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by GTR on 2017/4/4.
 */
@DefaultLifeCycle(application = "com.example.gtr.libsapplication.MyApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class MyApplication extends DefaultApplicationLike {

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
