package com.coures.spashscreen.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.coures.spashscreen.R;

public class MainActivity extends AppCompatActivity {

    private TextView sayHi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sayHi = findViewById(R.id.sayHi);
        if (getIntent().getExtras()!=null)
            sayHi.setText(getString(R.string.say_Hi)+" "+getIntent().getStringExtra("username"));
    }
}