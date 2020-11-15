package com.example.pruebas12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.UUID;

public class llamarActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText EditNombre, EditTelefono;
    private FirebaseDatabase db;
    private Button agregarbtn;
    private ListView listaContactos;


    private String miUsuario;
    private ContactoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamar);
        listaContactos = findViewById(R.id.listaContactos);
        agregarbtn = findViewById(R.id.agregarbtn);
        EditNombre = findViewById(R.id.EditNombre);
        EditTelefono = findViewById(R.id.EditTelefono);
        db = FirebaseDatabase.getInstance();
        miUsuario =getSharedPreferences("users", MODE_PRIVATE).getString("username", "NO_USERNAME");

adapter = new ContactoAdapter();
listaContactos.setAdapter(adapter);
        agregarbtn.setOnClickListener(this);


        loadDatabase();
    }

    private void loadDatabase(){
        DatabaseReference ref = db.getReference().child("users");
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot data) {
                       adapter.clear();
                       for(DataSnapshot child: data.getChildren()){
                           Contacto contacto = child.getValue(Contacto.class);
                           adapter.addContacto(contacto);

                       }

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                }
        );

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.agregarbtn:
                String id = db.getReference().child("usuario").push().getKey();
                String nombres = EditNombre.getText().toString();
                String telefonos = EditTelefono.getText().toString();

                DatabaseReference references = db.getReference().child("users").child(id);

                Contacto contacto = new Contacto(EditNombre.getText().toString(), EditTelefono.getText().toString());
                references.setValue(contacto);
                break;
        }
    }
}