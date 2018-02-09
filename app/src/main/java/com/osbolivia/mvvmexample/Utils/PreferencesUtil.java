package com.osbolivia.mvvmexample.Utils;

import android.content.SharedPreferences;

/**
 * Created by osboliviadev on 1/2/18.
 */

public class PreferencesUtil {

    public static String getNombrePreferences(SharedPreferences preferences) {
        return preferences.getString("nombre", "");
    }

    public static String getApellidoPreferences(SharedPreferences preferences) {
        return preferences.getString("apellido", "");
    }
}
