package com.example.aula2_11082025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tabuada extends AppCompatActivity {

    TextView tvTab, tvResult;
    String resultado="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tabuada);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        int num = b.getInt("num");
        tvTab = findViewById(R.id.tvTabuada);
        tvResult = findViewById(R.id.tvResultado);
        tvTab.setText("Tabuada do " +  num);

        for (int a=0; a<11; a++){
            resultado = resultado + a+" x "+num+ " = " + a*num+"\n";
            tvResult.setText(resultado);
        }
    }
}