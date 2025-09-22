package com.example.aula2_11082025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TabuadaResultado extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tabuada_resultado);
        tv = findViewById(R.id.tvResultado);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        int num =b.getInt("num");
        for(int a=0; a<11;a++){

            tv.setText(tv.getText()+ "\n"+a+" * "+num+" = "+a*num);
        }

    }
}