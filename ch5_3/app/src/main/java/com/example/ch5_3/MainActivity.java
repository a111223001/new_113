package com.example.ch5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements OnClickListener, View.OnLongClickListener {

    private  float original_size = 20;
    TextView TxvOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TxvOutput = (TextView) findViewById(R.id.TxvOutput);
        TxvOutput.setTextSize(original_size);
        Button btnEnlarge =(Button) findViewById(R.id.btnEnlarge);
        btnEnlarge.setOnClickListener(this);
        btnEnlarge.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float size = TxvOutput.getTextSize();
        Log.v("SIZE","size"+ size);
        TxvOutput.setTextSize(px2sp(this,size)+5);
    }

    @Override
    public boolean onLongClick(View v) {
        TxvOutput.setTextSize(original_size);
        return false;
    }
    public  static int px2sp(Context context, float pxValue){
        final float fonScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fonScale + 0.5f);
    }
}