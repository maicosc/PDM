package com.example.aula2_11082025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int num;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        num = Integer.parseInt(findViewById(R.id.etNum).toString());
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, TabuadaResultado.class);
            Bundle b = new Bundle();
            b.putInt("num", num);
            intent.putExtras(b);
            startActivity(intent);
        });
    }
}