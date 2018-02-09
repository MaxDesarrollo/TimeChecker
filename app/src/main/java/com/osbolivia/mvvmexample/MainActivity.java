package com.osbolivia.mvvmexample;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.osbolivia.mvvmexample.Commands.UserRegistro;
import com.osbolivia.mvvmexample.Model.UserPojo;
import com.osbolivia.mvvmexample.ViewModel.UserModel;
import com.osbolivia.mvvmexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String nombreUsuario, apellidoUsuario, imei;
    SharedPreferences prefsUsuario;
    String pureba;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        prefsUsuario = getSharedPreferences("PreferenciasUsuario", Context.MODE_PRIVATE);



        UserModel userModel = new UserModel(new UserPojo("Nombre", "Apellido"));
        binding.setRegistro(userModel);


        binding.setRegistroEvent(new UserRegistro() {
            @Override
            public void onClickRegistro() {
                imei = getImei(getApplicationContext());
                nombreUsuario = binding.getRegistro().getNombre();
                apellidoUsuario = binding.getRegistro().getApellido();

                if (TextUtils.isEmpty(nombreUsuario) && TextUtils.isEmpty(apellidoUsuario)) {
                    Toast.makeText(MainActivity.this, "Por favor ingrese los datos solicitados", Toast.LENGTH_LONG).show();
                } else {
                    SaveOnPreferences(nombreUsuario, apellidoUsuario);
                    StartIntent();
                }


                //Toast.makeText(MainActivity.this,"Imei " + imei +" Nombre " + nombreUsuario + " Apellido "+apellidoUsuario,Toast.LENGTH_LONG).show();

            }
        });
    }

    public String getImei(Context context) {
        String imei = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        //imei = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.);

        int permissionCheck = ContextCompat.checkSelfPermission(
                context, Manifest.permission.READ_PHONE_STATE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 225);

        } else {
            Log.i("Mensaje", "Se tiene permiso!");
            imei = telephonyManager.getDeviceId();

            return imei;
        }


        return "";


    }

    private void SaveOnPreferences(String nombre, String apellido) {
        SharedPreferences.Editor editor = prefsUsuario.edit();
        editor.putString("nombre", nombre);
        editor.putString("apellido", apellido);
        editor.apply();
    }

    public void StartIntent() {
        Intent i = new Intent(MainActivity.this, CheckInActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
