package com.example.aula2_11082025;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText min, max;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        min = findViewById(R.id.etMin);
        max = findViewById(R.id.etMax);
        resultado = findViewById(R.id.tvResultado);
        button.setOnClickListener( v ->{

            Random random = new Random();
            int mini,maxi;
             mini = Integer.parseInt(min.getText().toString());
             maxi = Integer.parseInt(max.getText().toString());
            int sorteado = random.nextInt(maxi - mini +1) + mini;
            resultado.setText(Integer.toString(sorteado));

        });


    }

}