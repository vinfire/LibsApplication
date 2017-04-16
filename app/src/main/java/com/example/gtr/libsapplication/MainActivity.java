package com.example.gtr.libsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gtr.libsapplication.retrofit.RetrofitActivity;
import com.example.gtr.libsapplication.tinker.TinkerTestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void gotoRetrofit(View view){
        Intent intent = new Intent(this, RetrofitActivity.class);
        startActivity(intent);
    }

    public void gotoTinkerTest(View view){
        Intent intent = new Intent(this, TinkerTestActivity.class);
        startActivity(intent);
    }
}
