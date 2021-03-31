package com.example.crudandroidspring;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.crudandroidspring.Models.PresionArterial;

import java.util.List;

public class PresionAdapter extends ArrayAdapter<PresionArterial> {
    private Context context;
    private List<PresionArterial> presion;

    public PresionAdapter(@NonNull Context context, int resource, @NonNull List<PresionArterial> objects) {
        super(context, resource, objects);
        this.context=context;
        this.presion=objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.content_main, parent, false);

        // Obtener los imputs del front
        TextView txtIdPresion = (TextView) rowView.findViewById(R.id.ID);
        TextView txtSistolica = (TextView) rowView.findViewById(R.id.sisto);
        TextView txtDiastolica = (TextView) rowView.findViewById(R.id.diasto);

        // setiar los inputs con los datos de la lista "presion"
        txtIdPresion.setText(String.format("ID: %s", presion.get(position).getId()));
        txtSistolica.setText(String.format("SISTOLICA: %s", presion.get(position).getSistolica()));
        txtDiastolica.setText(String.format("DIASTOLICA: %s", presion.get(position).getDiastolica()));

        return rowView;
    }
}
