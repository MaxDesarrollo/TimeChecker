package com.osbolivia.mvvmexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.osbolivia.mvvmexample.Utils.PreferencesUtil;


public class CheckInActivity extends AppCompatActivity {


    SharedPreferences prefs;
    ImageView imgCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        prefs = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);

        imgCheck = (ImageView) findViewById(R.id.imgCheckIn);

        imgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetInfoWifi();
            }
        });


    }


    public String[] GetPreferences() {
        String nombreUsuario = PreferencesUtil.getNombrePreferences(prefs);
        String apellidoPreferences = PreferencesUtil.getApellidoPreferences(prefs);

        String[] usuario = {nombreUsuario, apellidoPreferences};

        return usuario;

    }


    public void GetInfoWifi(){

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if(wifiInfo == null){
            //
        }else{

            //tvSSID.setText("SSID: " + wifiInfo.getSSID());
            //tvRssi.setText("Rssi: " + wifiInfo.getRssi() + " dBm");


            String[] usuario = GetPreferences();
            String nombre = usuario[0];
            String apellidp = usuario[1];
            String SSID = wifiInfo.getSSID();
            Toast.makeText(getBaseContext(), "Nombre " + nombre + "Apellido " + apellidp + "SSID " + SSID, Toast.LENGTH_LONG).show();


        }

    }

    private String readtvWifiState(WifiManager wm){
        String result = "";
        switch (wm.getWifiState()){
            case WifiManager.WIFI_STATE_DISABLED:
                result = "WIFI_STATE_DISABLED";
                break;
            case WifiManager.WIFI_STATE_DISABLING:
                result = "WIFI_STATE_DISABLING";
                break;
            case WifiManager.WIFI_STATE_ENABLED:
                result = "WIFI_STATE_ENABLED";
                break;
            case WifiManager.WIFI_STATE_ENABLING:
                result = "WIFI_STATE_ENABLING";
                break;
            case WifiManager.WIFI_STATE_UNKNOWN:
                result = "WIFI_STATE_UNKNOWN";
                break;
            default:
        }
        return result;
    }
}
