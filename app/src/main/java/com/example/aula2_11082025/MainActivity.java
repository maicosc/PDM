package com.example.aula2_11082025;

import android.content.ContentValues;
import android.database.Cursor;
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

    Button butao;

    ListView l;

    ArrayList<String> nts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        l = findViewById(R.id.lista);
        butao = findViewById(R.id.button);
        EditText edText = findViewById(R.id.editText);

        db = openOrCreateDatabase("app_database", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "titulo VARCHAR, texto TEXT)");
        carregarListagem();

        butao.setOnClickListener(v -> {

            String txt = edText.getText().toString();
            ContentValues cv = new ContentValues();
            cv.put("titulo", "Notas Usuario");
            cv.put("texto", txt);
            db.insert("notas", null, cv);
            carregarListagem();

        });

    }
    public void carregarListagem(){
        ArrayList<String> textos = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            String text= cursor.getString(cursor.getColumnIndexOrThrow("texto"));
            textos.add(text);
            cursor.moveToNext();
        }

        ArrayAdapter<String> textAdapter = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                textos
        );
        l.setAdapter(textAdapter);
    }
}