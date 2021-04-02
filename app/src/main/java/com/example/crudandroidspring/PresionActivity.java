package com.example.crudandroidspring;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.crudandroidspring.Models.PresionArterial;
import com.example.crudandroidspring.Utils.Apis;
import com.example.crudandroidspring.Utils.PresionService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresionActivity extends AppCompatActivity {

    PresionService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presion_layout);

        TextView sistolica = (TextView) findViewById(R.id.sistolica);
        final EditText txtSistolica = (EditText) findViewById(R.id.txtSisto);
        TextView distolica = (TextView) findViewById(R.id.diastolica);
        final EditText txtDiastolica = (EditText) findViewById(R.id.txtDisto);

        Button btnSave = (Button)findViewById(R.id.btnSave);
        Button btnVolver=(Button)findViewById(R.id.btnVolver);
        Button btnEliminar=(Button)findViewById(R.id.btnEliminar);

        Bundle bundle = getIntent().getExtras();
        final String id = bundle.getString("ID");
        String sis = bundle.getString("SISTOLICA");
        String dis = bundle.getString("DIASTOLICA");

        txtSistolica.setText(sis);
        txtDiastolica.setText(dis);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PresionArterial p = new PresionArterial();
                p.setSistolica(txtSistolica.getText().toString());
                p.setDiastolica(txtDiastolica.getText().toString());
                p.setPacienteId(1);
                if(id.trim().length() == 0 || id.equals("")){
                    addPersona(p);
                    Intent intent = new Intent(PresionActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    updatePersona(Integer.valueOf(id), p);
                    Intent intent =new Intent(PresionActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePersona(Integer.valueOf(id));
                Intent intent =new Intent(PresionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(PresionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addPersona(PresionArterial p){
        service= Apis.getPresionService();
        Call<PresionArterial> call = service.addPresion(p);
        call.enqueue(new Callback<PresionArterial>() {

            @Override
            public void onResponse(Call<PresionArterial> call, Response<PresionArterial> response) {
                if(response.isSuccessful()){
                    Toast.makeText(PresionActivity.this,"Se agrego conéxito",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<PresionArterial> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });

        Intent intent = new Intent(PresionActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void updatePersona(int id, PresionArterial p){
        service= Apis.getPresionService();
        Call<PresionArterial>call = service.updatePresion(id, p);
        call.enqueue(new Callback<PresionArterial>() {
            @Override
            public void onResponse(Call<PresionArterial> call, Response<PresionArterial> response) {
                if(response.isSuccessful()){
                    Toast.makeText(PresionActivity.this, "Se Actualizó conéxito",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<PresionArterial> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent = new Intent(PresionActivity.this,MainActivity.class);
        startActivity(intent);
    }

    public void deletePersona(int id){
        service = Apis.getPresionService();
        Call<PresionArterial> call = service.deletePresion(id);
        call.enqueue(new Callback<PresionArterial>() {
            @Override
            public void onResponse(Call<PresionArterial> call, Response<PresionArterial> response) {
                if(response.isSuccessful()){
                    Toast.makeText(PresionActivity.this,"Se Elimino el registro",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PresionArterial> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent =new Intent(PresionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
