package com.example.aula2_11082025;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    ListView listaS;
    List<String> listaNomesSensores;
    List<Sensor> listaSM;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listaS = findViewById(R.id.listaSensores);
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,sensor , sm.SENSOR_DELAY_NORMAL);
        listaSM = sm.getSensorList(Sensor.TYPE_ALL);

        

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        event.sensor.getName();


        for (Sensor s: listaSM) {
            sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);

            listaNomesSensores.add(s.getName());


        }
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listaNomesSensores);
        listaS.setAdapter(adapter);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}