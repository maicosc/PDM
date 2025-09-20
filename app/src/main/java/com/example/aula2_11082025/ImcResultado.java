package com.example.aula2_11082025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ImcResultado extends AppCompatActivity {

    Button buon;
    TextView tv,tvAlt, tvPe, tvTp;
    ImageView Iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc_resultado);
        tv = findViewById(R.id.tvResultado);
        tvAlt = findViewById(R.id.tvRAltura);
        tvPe = findViewById(R.id.tvRPeso);
        Iv=findViewById(R.id.ivResultado);
        tvTp=findViewById(R.id.tvTipo);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        double peso = b.getDouble("peso");
        double altura = b.getDouble("altura");
        double imc = peso/(altura*altura);
        tvPe.setText("Peso: " + String.format("%.2f", peso) + " Kg");
        tvAlt.setText("Altura: "+String.format("%.2f", altura)+" m");
        String resultado = "IMC: " + String.format("%.2f",imc);
        tv.setText(resultado);
        if(imc < 18.5){
            Iv.setImageDrawable(getDrawable(R.drawable.abaixopeso));
            tvTp.setText("Abaixo do Peso");
        }
        else if( imc >= 18.5 && imc<=24.9){
            Iv.setImageDrawable(getDrawable(R.drawable.normal));
            tvTp.setText("Peso Normal");
        }
        else if( imc >= 25 && imc<=29.9){
            Iv.setImageDrawable(getDrawable(R.drawable.sobrepeso));
            tvTp.setText("Sobrepeso");
        }
        else if( imc >= 30 && imc<=34.9){
            Iv.setImageDrawable(getDrawable(R.drawable.obesidade1));
            tvTp.setText("Obesidade 1");
        }
        else if( imc >= 35 && imc<=39.9){
            Iv.setImageDrawable(getDrawable(R.drawable.obesidade2));
            tvTp.setText("Obesidade 2");
        }
        else if( imc > 40){
            Iv.setImageDrawable(getDrawable(R.drawable.obesidade3));
            tvTp.setText("Obesidade 3");
        }
    }
}