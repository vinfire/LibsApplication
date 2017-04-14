package com.example.gtr.libsapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.gtr.libsapplication.greendao.gen.DaoMaster;
import com.example.gtr.libsapplication.greendao.gen.UserDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by GTR on 2017/4/4.
 */

public class MySqlLiteOpenHelper extends DaoMaster.OpenHelper {

    public MySqlLiteOpenHelper(Context context, String name) {
        super(context, name);
    }

    public MySqlLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.i("lxq","oldVersion:"+oldVersion+",newVersion"+newVersion);
        MigrationHelper.getInstance().migrate(db,UserDao.class);

    }
}
