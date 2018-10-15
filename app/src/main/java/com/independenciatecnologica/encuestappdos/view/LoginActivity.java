package com.independenciatecnologica.encuestappdos.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.independenciatecnologica.encuestappdos.viewModel.LoginViewModel;
import com.independenciatecnologica.encuestappdos.model.User;
import com.independenciatecnologica.encuestappdos.R;
import com.independenciatecnologica.encuestappdos.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        initBinding();
    }

    private void initBinding(){
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setLifecycleOwner(this);
        LoginViewModel model = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setLoginViewModel(model);
        model.getLogin().observe(this,this::getUser);
    }

    private void getUser (User user){
        Toast.makeText(this,"Welcome mr :"+user.getUser(),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,ActivityList.class);
        startActivity(intent);
    }
}
