package com.example.ui_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_display_string);

        TextView txvShow = (TextView) findViewById(R.id.txvShow);
        Intent intent = getIntent();
        String reveivedString = intent.getStringExtra("userInput");

        txvShow.setText("輸入:"+reveivedString);
    }
}