package com.example.gtr.libsapplication.greendao;

import com.example.gtr.libsapplication.MyApplication;
import com.example.gtr.libsapplication.MySqlLiteOpenHelper;
import com.example.gtr.libsapplication.greendao.gen.DaoMaster;
import com.example.gtr.libsapplication.greendao.gen.DaoSession;

/**
 * Created by GTR on 2017/4/4.
 */

public class GreenDaoManager {

    private static GreenDaoManager mInstance;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private String DB_NAME= "test.db";

    private GreenDaoManager(){
        MySqlLiteOpenHelper helper = new MySqlLiteOpenHelper(MyApplication.getContext(), DB_NAME, null);
        mDaoMaster = new DaoMaster(helper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public static GreenDaoManager getInstance(){
        if (mInstance == null){
            synchronized(GreenDaoManager.class){
                if (mInstance == null){
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getMaster(){
        return mDaoMaster;
    }

    public DaoSession getSession(){
        return mDaoSession;
    }

    public DaoSession getNewSession(){
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}
