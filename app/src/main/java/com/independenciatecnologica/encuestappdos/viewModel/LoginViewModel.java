package com.independenciatecnologica.encuestappdos.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import com.independenciatecnologica.encuestappdos.model.User;
import com.independenciatecnologica.encuestappdos.util.Utility;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<String> user = new MutableLiveData<>();
    private MutableLiveData<String> pass = new MutableLiveData<>();
    private MutableLiveData<String>errorUser=new MutableLiveData<>();
    private MutableLiveData<String>errorPass=new MutableLiveData<>();
    private MutableLiveData<User> userLiveData;
    private MutableLiveData<Integer>busy;

    public MutableLiveData<String> getErrorUser() {
        return errorUser;
    }

    public void setErrorUser(MutableLiveData<String> errorUser) {
        this.errorUser = errorUser;
    }

    public MutableLiveData<String> getErrorPass() {
        return errorPass;
    }

    public void setErrorPass(MutableLiveData<String> errorPass) {
        this.errorPass = errorPass;
    }

    public LoginViewModel (){ }
    public MutableLiveData<User>getLogin(){
        if(userLiveData==null){
            userLiveData = new MutableLiveData<>();
        }
        return userLiveData;
    }
    public MutableLiveData<String> getUser() {
        this.errorUser.setValue("");
        return user;
    }

    public void setUser(MutableLiveData<String> user) {

        this.user = user;
    }

    public MutableLiveData<String> getPass() {
        return pass;
    }

    public void setPass(MutableLiveData<String> pass) {
        this.errorPass.setValue("");
        this.pass = pass;
    }

    public MutableLiveData<Integer>getBusy(){
        if(busy == null){
            busy = new MutableLiveData<>();
            busy.setValue(8);
        }
        return busy;
    }

    public void login(){
        if(!Utility.checking(user.getValue()))
            errorUser.setValue("you have to put a user");
         if(!Utility.checking(pass.getValue()))
            errorPass.setValue("you have to write a password");
        if(Utility.checking(user.getValue()) && Utility.checking(pass.getValue()) ){
            busy.setValue(0);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    String u =user.getValue();
                    String ps = pass.getValue();
                    User user = new User(u,ps);
                    userLiveData.setValue(user);
                    busy.setValue(8);
                    }
            },3000);
            }
    }
}
