package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
DBHelper DB;
EditText email, password;
Button btnlogin, btnreg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.emailidd);
        password = (EditText) findViewById(R.id.password);
        Button btnlogin = (Button) findViewById(R.id.loginbutton);
        Button btnreg = (Button) findViewById(R.id.registeration);
        DB = new DBHelper(this);
        //creating a cursor
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String emailid = email.getText().toString();
              String pass = password.getText().toString();
              if(emailid.equals("") || pass.equals("")){
                  Toast.makeText(MainActivity.this, "Enter every field", Toast.LENGTH_SHORT).show();
              }
              else {
                  Boolean checkuserpass = DB.Checkuemailpassword(emailid, pass);
                  if(checkuserpass==true){
                      Toast.makeText(MainActivity.this, "Sign in successful!", Toast.LENGTH_SHORT).show();
                      Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                      startActivity(intent);
                  }
                  else
                  {
                      Toast.makeText(MainActivity.this, "Sign in failed", Toast.LENGTH_SHORT).show();
                  }
              }
            }
        });
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(getApplicationContext(),Registration2.class);
              startActivity(intent);
            }
        });

    }



}