package com.example.aula2_11082025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText etPeso, etAltura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button5);
        etAltura=findViewById(R.id.etAltura);
        etPeso=findViewById(R.id.etPeso);
        button.setOnClickListener( v -> {
            Intent intent = new Intent(this, ImcResultado.class);
            Bundle b = new Bundle();
            double peso = Double.parseDouble(etPeso.getText().toString());
            double altura = Double.parseDouble(etAltura.getText().toString());
            b.putDouble("peso",peso);
            b.putDouble("altura",altura);
            intent.putExtras(b);
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}