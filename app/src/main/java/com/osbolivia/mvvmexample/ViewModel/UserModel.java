package com.osbolivia.mvvmexample.ViewModel;

import android.databinding.BaseObservable;

import com.osbolivia.mvvmexample.Model.UserPojo;
import com.osbolivia.mvvmexample.R;

/**
 * Created by osboliviadev on 1/2/18.
 */

public class UserModel extends BaseObservable{


    private String nombre ;
    private String apellido ;
    private String nombreHint;
    private String apellidoHint;
    private String imeiUsuario;

    private UserPojo userPojo;


    public UserModel(UserPojo userPojo) {
        this.nombreHint = userPojo.nombreHint;
        this.apellidoHint = userPojo.apellidoHint;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        notifyPropertyChanged(R.id.txtNombreRegistro);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        notifyPropertyChanged(R.id.txtApellidoRegistro);
    }

    public String getNombreHint() {
        return nombreHint;
    }

    public void setNombreHint(String nombreHint) {
        this.nombreHint = nombreHint;
    }

    public String getApellidoHint() {
        return apellidoHint;
    }

    public void setApellidoHint(String apellidoHint) {
        this.apellidoHint = apellidoHint;
    }

    public String getImeiUsuario() {
        return imeiUsuario;
    }

    public void setImeiUsuario(String imeiUsuario) {
        this.imeiUsuario = imeiUsuario;
    }

    public UserPojo getUserPojo() {
        return userPojo;
    }

    public void setUserPojo(UserPojo userPojo) {
        this.userPojo = userPojo;
    }
}
