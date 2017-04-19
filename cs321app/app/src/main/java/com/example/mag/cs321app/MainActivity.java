package com.example.mag.cs321app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.firebase.client.Firebase;


public class MainActivity extends AppCompatActivity {

    private EditText mvalueField;
    private Button maddBtn;

    private Firebase mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        mRef = new Firebase("https://cs321app.firebaseio.com/Users");

        mvalueField = (EditText) findViewById(R.id.valueField);
        maddBtn = (Button) findViewById(R.id.addBtn);

        maddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = mvalueField.getText().toString();
                Firebase mRefChild = mRef.child("Name");
                mRefChild.setValue(value);
            }
        });
    }
}
