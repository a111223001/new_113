package com.example.explicltlntentdemo2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(requestCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    output.setText(("計算結果:" + bundle.getDouble("RESULT"));
                }
                break;
        }
    }

    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.lblOutput);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 EditText txtopd1,txtopd2;
                 txtopd1 = (EditText) findViewById(R.id.txtOpd1);
                 txtopd2 = (EditText) findViewById(R.id.txtOpd2);
                Intent intent = new Intent(MainActivity.this, OpActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("OPERAND01",txtopd1.getText().toString());
                bundle.putString("OPERAND02",txtopd2.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent,1);

            }
        });
    }
}