package com.example.gtr.libsapplication;

import com.example.gtr.libsapplication.greendao.GreenDaoManager;
import com.example.gtr.libsapplication.greendao.entity.User;
import com.example.gtr.libsapplication.greendao.gen.DaoSession;
import com.example.gtr.libsapplication.greendao.gen.UserDao;

import java.util.List;

/**
 * Created by GTR on 2017/4/4.
 */

public class UserDaoManagr implements IDao<User> {

    private DaoSession mDaoSession = GreenDaoManager.getInstance().getSession();

    @Override
    public boolean insert(User user) {
        long insert = mDaoSession.getUserDao().insert(user);
        return insert>0;
    }

    @Override
    public boolean deleta(User user) {
        try {
            mDaoSession.getUserDao().delete(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(User user) {
        try{
            mDaoSession.getUserDao().update(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<User> queryAll() {
        return mDaoSession.getUserDao().loadAll();
    }

    @Override
    public User queryById(long id) {
        return mDaoSession.getUserDao().loadByRowId(id);
    }

    @Override
    public List<User> queryByParams(String where, String... params) {
        return mDaoSession.getUserDao().queryRaw(where, params);
    }

    public User queryByName(String name){
        return mDaoSession.getUserDao()
                .queryBuilder()
                .where(UserDao.Properties.Name.eq(name))
                .build()
                .unique();
    }
}
