package com.example.aula2_11082025;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    Button button;

    ListView l;

    ArrayList<String> notas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        l = findViewById(R.id.lista);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            EditText edText = findViewById(R.id.editText);
            String texto = edText.getText().toString();
            ContentValues cv = new ContentValues();
            cv.put("titulo", "Nota do Usuario");
            cv.put("texto", texto);
            db.insert("notas", null, cv);


            notas.add(texto);

        });
        db = openOrCreateDatabase("app_database", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "titulo VARCHAR, texto TEXT)");
        ContentValues values = new ContentValues();
        values.put("titulo", "Mi primera nota");
        values.put("texto", "Este é o texto da nota");
        db.insert("notas", null,values);

        ArrayAdapter<String> adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                notas);
        l.setAdapter(adapter);

    }
}