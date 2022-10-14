package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    final String log_name = "hello world";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void goToRegisterActivity(View view)
    {
        Intent intent = new Intent(this,Registration2.class);
        startActivity(intent);
        Log.d("Hi", log_name);
    }

}