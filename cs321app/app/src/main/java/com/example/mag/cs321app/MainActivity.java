package com.example.mag.cs321app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.firebase.client.Firebase;


public class MainActivity extends AppCompatActivity {

    private EditText mvalueField;
    private Button maddBtn;
    private EditText mKeyValue;
    private Button msignUpBtn;

    private Firebase mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        mRef = new Firebase("https://cs321app.firebaseio.com/Users");

        mvalueField = (EditText) findViewById(R.id.valueField);
        maddBtn = (Button) findViewById(R.id.addBtn);
        mKeyValue = (EditText) findViewById(R.id.keyValue);

        maddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = mvalueField.getText().toString(); //password (value in tutorial)
                String username = mKeyValue.getText().toString(); //username (key in tutorial)
                Firebase mRefChild = mRef.child(username);

                mRef.setValue(password);


            }
        });

        msignUpBtn = (Button) findViewById(R.id.signUpBtn);

        msignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateAccountActivity.class));
            }
            //do something when sign up button is clicked

        });

    }

}
