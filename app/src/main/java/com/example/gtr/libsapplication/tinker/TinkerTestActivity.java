package com.example.gtr.libsapplication.tinker;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gtr.libsapplication.R;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class TinkerTestActivity extends AppCompatActivity {

    private TextView tvTinker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinker_test);

        tvTinker = (TextView) findViewById(R.id.tv_tinker);
        tvTinker.setText("this is ok");
    }

    public void show(View view){
        Toast.makeText(getApplicationContext(), "this is ok!", Toast.LENGTH_SHORT).show();
    }

    public void loadPatchButton(View view){
        TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/patch_signed_7zip.apk");
        if (file.exists()){
            Toast.makeText(this, "文件已存在", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "文件不存在", Toast.LENGTH_SHORT).show();
        }
        Log.i("PATH", "loadPatchButton: "+Environment.getExternalStorageDirectory().getAbsolutePath());
    }
}
