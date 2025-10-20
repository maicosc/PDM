package com.example.aula2_11082025;

import static androidx.core.content.res.ResourcesCompat.getDrawable;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {

  int mResource;


  ImageView img;
  TextView tv;
    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {


        super(context, resource, objects);
        mResource = resource;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(mResource,parent,false);
        Planeta p = getItem(position);
        img =  view.findViewById(R.id.imgV);
        tv = view.findViewById(R.id.tV);
        tv.setText(p.nome);
        img.setImageResource(p.img);

        return view;

    }
}
