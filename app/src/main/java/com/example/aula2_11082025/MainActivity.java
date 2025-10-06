package com.example.aula2_11082025;






import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
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
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <String> textos;
    ListView listView;
    Button btSalvar;
    EditText etUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        etUser = findViewById(R.id.etTextoUser);
        btSalvar =findViewById(R.id.btSalvar);
        textos = new ArrayList<>();
        etUser.setOnKeyListener((v, keyCode, event) -> {
                if(event.getAction() == KeyEvent.KEYCODE_ENTER){
                    if(etUser.getText().toString().trim().isEmpty()){
                        Toast.makeText(getApplicationContext(),"Preencha o campo de texto! IDIOTA!!!", Toast.LENGTH_LONG).show();
                    }else{
                        textos.add(etUser.getText().toString());
                        ((ArrayAdapter)listView.getAdapter()).notifyDataSetChanged();
                        etUser.setText("");
                        etUser.requestFocus();
                    }
                }
                return false;
        });
        btSalvar.setOnClickListener(v -> {

            if(etUser.getText().toString().trim().isEmpty()){
                Toast.makeText(getApplicationContext(),"Preencha o campo de texto! IDIOTA!!!", Toast.LENGTH_LONG).show();
            }else{
                textos.add(etUser.getText().toString());
                ((ArrayAdapter)listView.getAdapter()).notifyDataSetChanged();
                etUser.setText("");
                etUser.requestFocus();
            }


        });


        ArrayAdapter<String> adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                textos);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener((parent, view, position, id) -> {

                AlertDialog.Builder caixa = new AlertDialog.Builder(this);
                caixa.setTitle("Excluir item");
                caixa.setMessage("Tem certeza que deseja excluir o item \""+ textos.get(position) +"\"?");
                caixa.setPositiveButton("Sim", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        textos.remove(position);
                        ((ArrayAdapter)listView.getAdapter()).notifyDataSetChanged();
                    }
                });
                caixa.setNegativeButton("Não", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.dismiss();
                    }
                });
            AlertDialog alerta = caixa.create();
                alerta.show();


            return false;
        });
    }

}
