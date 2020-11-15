package com.example.pruebas12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText EditUser;
private FirebaseDatabase db;
private Button ingresarbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ingresarbtn = findViewById(R.id.ingresarbtn);
        EditUser = findViewById(R.id.EditUser);
         db = FirebaseDatabase.getInstance();

        ingresarbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ingresarbtn:
                Intent i = new Intent(this,llamarActivity.class);
                String username = EditUser.getText().toString();
                //  i.putExtra("username", username);
                SharedPreferences preference = getSharedPreferences("usuarios", MODE_PRIVATE);
                preference.edit().putString("username", username).apply();
                startActivity(i);


                break;


        }
    }
}