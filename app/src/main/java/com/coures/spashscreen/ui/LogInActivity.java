package com.coures.spashscreen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.coures.spashscreen.R;
import com.coures.spashscreen.services.LogIn;
import com.coures.spashscreen.services.SimpleAuth;
import com.coures.spashscreen.util.AnimationManager;
import com.coures.spashscreen.util.ToastManager;

public class LogInActivity extends AppCompatActivity {

    private ImageView splash_iv;
    private Button loginBtn;
    private EditText username,password;
    private LogIn logIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        splash_iv = findViewById(R.id.splash_iv);
        loginBtn = findViewById(R.id.loginBtn);
        username = findViewById(R.id.username_tv);
        password = findViewById(R.id.password_tv);
        logIn = new SimpleAuth();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (logIn.auth(username.getText().toString(),password.getText().toString())){
                    ToastManager.success(LogInActivity.this,(ViewGroup)splash_iv.getParent(),getString(R.string.msg_success_login));
                    Intent i = new Intent(LogInActivity.this,MainActivity.class);
                    i.putExtra("username",username.getText().toString());
                    startActivity(i);
                    finish();
                }
                else
                    ToastManager.error(LogInActivity.this,(ViewGroup)splash_iv.getParent(),getString(R.string.msg_error_login));

            }
        });

        AnimationManager.RevealAnim(splash_iv,new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                splash_iv.setVisibility(View.GONE);
            }
        },AnimationManager.RevealType.REVERSE);

    }
}