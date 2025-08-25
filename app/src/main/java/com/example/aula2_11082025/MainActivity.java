package com.example.aula2_11082025;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ciclo_vida", "OnStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ciclo_vida", "OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ciclo_vida", "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ciclo_vida", "OnStop");
    }
}