package com.example.gtr.libsapplication;

import java.util.List;

/**
 * Created by GTR on 2017/4/4.
 */

interface IDao<T> {

    boolean insert(T t);
    boolean deleta(T t);
    boolean update(T t);
    List<T> queryAll();
    T queryById(long id);
    List<T> queryByParams(String where, String... params);
}
