package com.example.aula2_11082025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImcResultado extends AppCompatActivity {

    Button buon;
    TextView tv;
    ImageView Iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc_resultado);
        tv = findViewById(R.id.tvResultado);
        Iv=findViewById(R.id.imageViewPerfil);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        double peso = b.getDouble("peso");
        double altura = b.getDouble("altura");
        double imc = peso/(altura*altura);
        tv.setText(Double.toString(imc));
    }
}