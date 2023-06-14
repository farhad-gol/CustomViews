package com.fsc.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.fsc.customviews.Help;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Help h11 = findViewById(R.id.h11);
        h11.SetTitleBody("T","B");
        h11.setListener(new Help.HelpListener() {
            @Override
            public void SetValue(String text) {
                Toast.makeText(getBaseContext(),text,Toast.LENGTH_LONG).show();
            }
        });
    }
}