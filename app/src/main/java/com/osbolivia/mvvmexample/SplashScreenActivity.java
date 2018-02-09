package com.osbolivia.mvvmexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.osbolivia.mvvmexample.Utils.PreferencesUtil;

public class SplashScreenActivity extends AppCompatActivity {

    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        prefs = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentMain = new Intent(SplashScreenActivity.this, MainActivity.class);
                Intent itentCheckIn = new Intent(SplashScreenActivity.this, CheckInActivity.class);

                String nombreUsuario = PreferencesUtil.getNombrePreferences(prefs);
                String password = PreferencesUtil.getApellidoPreferences(prefs);

                if (!TextUtils.isEmpty(PreferencesUtil.getNombrePreferences(prefs)) && !TextUtils.isEmpty(PreferencesUtil.getApellidoPreferences(prefs))) {
                    startActivity(itentCheckIn);
                } else {
                    startActivity(intentMain);
                }

                finish();
            }
        }, 3000);
    }
}
