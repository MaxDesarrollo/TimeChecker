package com.osbolivia.mvvmexample.Model;

/**
 * Created by osboliviadev on 1/2/18.
 */

public class UserPojo {

    public String nombre;
    public String apellido;
    public String nombreHint;
    public String apellidoHint;
    public String imeiUsuario;

    public UserPojo(String nombreHint, String apellidoHint) {
        this.nombreHint = nombreHint;
        this.apellidoHint = apellidoHint;
    }
}
