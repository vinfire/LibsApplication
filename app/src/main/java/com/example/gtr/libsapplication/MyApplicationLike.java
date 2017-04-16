package com.example.gtr.libsapplication;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.example.gtr.libsapplication.tinker.log.MyLogImp;
import com.example.gtr.libsapplication.tinker.util.MyApplicationContext;
import com.example.gtr.libsapplication.tinker.util.TinkerManager;
import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by GTR on 2017/4/4.
 */
@DefaultLifeCycle(application = "com.example.gtr.libsapplication.MyApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class MyApplicationLike extends DefaultApplicationLike {

    private static Context mContext;

    public MyApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        MyApplicationContext.application = getApplication();
        MyApplicationContext.context = getApplication();
        TinkerManager.setTinkerApplicationLike(this);

        TinkerManager.initFastCrashProtect();
        //should set before tinker is installed
        TinkerManager.setUpgradeRetryEnable(true);

        //optional set logIml, or you can use default debug log
        TinkerInstaller.setLogIml(new MyLogImp());

        //installTinker after load multiDex
        //or you can put com.tencent.tinker.** to main dex
        TinkerManager.installTinker(this);
        Tinker tinker = Tinker.with(getApplication());

        this.mContext = base;
    }

    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        getApplication().registerActivityLifecycleCallbacks(callback);
    }

    public static Context getContext(){
        return mContext;
    }
}
