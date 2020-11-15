package com.example.pruebas12;
import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ContactoAdapter extends BaseAdapter {
private Contacto contacto;
    private  ArrayList<Contacto>contactos;
public ContactoAdapter(){
  contactos = new ArrayList<>();

}
public void addContacto(Contacto contacto){
contactos.add(contacto);
notifyDataSetChanged();
}
public void clear(){
    contactos.clear();
    notifyDataSetChanged();
}



    @Override
    public int getCount() {
        return contactos.size();
    }

    @Override
    public Object getItem(int position) {
        return contactos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View renglon, ViewGroup lista) {

        LayoutInflater inflater = LayoutInflater.from(lista.getContext());
        View renglonView = inflater.inflate(R.layout.row,null);

        contacto = contactos.get(position);
        Button llamarbtn = renglonView.findViewById(R.id.llamarbtn);
        Button eliminarbtn = renglonView.findViewById(R.id.eliminarbtn);
        TextView nombreRow = renglonView.findViewById(R.id.nombreRow);
        TextView telefonoRow = renglonView.findViewById(R.id.telefonoRow);

        nombreRow.setText(contacto.getNombre());
        telefonoRow.setText(contacto.getTelefono());
        /*
        eliminarbtn.setOnClickListener(
                (v)->{
                    String id = contacto.getNombre();
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("users");
                    reference.setValue(null);

                }
        );

         */
        llamarbtn.setOnClickListener(
                (v) -> {
                    String tel = "tel:"+contacto.getTelefono();
                    Intent i = new Intent(Intent.ACTION_CALL);
                    i.setData(Uri.parse(tel));
                    lista.getContext().startActivity(i);
                }
        );


        return renglonView;
    }
}
