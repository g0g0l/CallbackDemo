package com.example.bibaswann.callbackdemo;

import android.accessibilityservice.AccessibilityService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomLayout customLayout = findViewById(R.id.myCustomLayout);
        //Alternatively you can create an instance of CustomLayout and add it from here
        customLayout.initViews(this, new CustomLayout.MyOnClickListener() {
            @Override
            public void onClick(String inputData) {
                Toast.makeText(MainActivity.this, inputData, Toast.LENGTH_LONG).show();
            }
        });
    }
}
