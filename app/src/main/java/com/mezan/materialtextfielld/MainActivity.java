package com.mezan.materialtextfielld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputEditText etEmail,etMobile,etPassword;
    TextInputLayout layoutE,layoutM,layoutP;
    Button btnLogin;
    ConstraintLayout rootLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail=findViewById(R.id.etEmail);
        etMobile=findViewById(R.id.etMobile);
        etPassword=findViewById(R.id.etPassword);
        layoutE=findViewById(R.id.layoutEmail);
        layoutM=findViewById(R.id.layoutMobile);
        layoutP=findViewById(R.id.layoutPassword);
        btnLogin=findViewById(R.id.btnLogin);
        rootLayout=findViewById(R.id.rootLayout);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid()){
                    Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"Login Error",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private boolean isValid(){
        boolean isvalid = true;

        String email= String.valueOf(etEmail.getText());
        String password= String.valueOf(etPassword.getText());
        String mobile = String.valueOf(etMobile.getText());
        TransitionManager.beginDelayedTransition(rootLayout);
        if(!isValidEmail(email)){
            layoutE.setErrorEnabled(true);
            layoutE.setError("Wrong Email Address");
            isvalid = false;
        }else {

            layoutE.setErrorEnabled(false);
        }
        if (password.isEmpty()){
            layoutP.setErrorEnabled(true);
            layoutP.setError("Password field can't be empty");
            isvalid=false;
        }else {
            layoutP.setErrorEnabled(false);
        }
        if(mobile.isEmpty()){
            layoutM.setErrorEnabled(true);
            layoutM.setError("Mobile field can't be empty");
            isvalid=false;
        }else {
            layoutM.setErrorEnabled(false);
        }
        return isvalid;
    }
//    fun String.isValidEmail(): Boolean
//        = !this.isNullOrEmpty() &&
//            Patterns.EMAIL_ADDRESS.matcher(this).matches()
    public boolean isValidEmail(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
