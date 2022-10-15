package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration2 extends AppCompatActivity {
    EditText username, passwordnew, confirmpassword, flatnumber, email, profession;
    Button register;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        username = (EditText) findViewById(R.id.username);
        passwordnew = (EditText) findViewById(R.id.passwordnew);
        confirmpassword = (EditText) findViewById(R.id.confirmpassword);
        flatnumber = (EditText) findViewById(R.id.flatnumber);
        email = (EditText) findViewById(R.id.enteremail);
        profession =(EditText) findViewById(R.id.profession);
        register =(Button) findViewById(R.id.register);
        DB = new DBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernamee = username.getText().toString();
                String passcode = passwordnew.getText().toString();
                String repass = confirmpassword.getText().toString();
                String flatnum = flatnumber.getText().toString();
                String emaill = email.getText().toString();
                String professionn = profession.getText().toString();
                if (usernamee.equals("") || passcode.equals("") || repass.equals("") || flatnum.equals("") || emaill.equals("") || professionn.equals("")) {
                    Toast.makeText(Registration2.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (passcode.equals(repass)) {
                        Boolean checkuser = DB.checkemailid(emaill);
                        if (checkuser == false) {
                            Boolean insert = DB.insertvalues(emaill, usernamee, flatnum, professionn, passcode);
                            if (insert == true) {
                                Toast.makeText(Registration2.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);

                            }
                            else {
                                Toast.makeText(Registration2.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }


                        }
                        else {
                            Toast.makeText(Registration2.this, "User Already Exists!", Toast.LENGTH_SHORT).show();
                        }


                    }
                    else {
                        Toast.makeText(Registration2.this, "passwords doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}