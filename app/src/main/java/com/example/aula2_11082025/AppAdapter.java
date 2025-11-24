package com.example.aula2_11082025;

import android.content.Context;

import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {

    public AppAdapter(MainActivity mainActivity, int app_lista, @NonNull List<ApplicationInfo> objects) {
        super(mainActivity, app_lista, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.app_lista, parent, false);
        ApplicationInfo applicationInfo = getItem(position);
        TextView tvApp = view.findViewById(R.id.tvApp);
        ImageView imgApp = view.findViewById(R.id.imgApp);
        imgApp.setImageDrawable(applicationInfo.loadIcon(getContext().getPackageManager()));
        tvApp.setText(applicationInfo.loadLabel(getContext().getPackageManager()));
        return view;

    }

}
