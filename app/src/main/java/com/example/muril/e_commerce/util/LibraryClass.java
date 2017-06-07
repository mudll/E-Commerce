package com.example.muril.e_commerce.util;

import android.content.Intent;
import android.widget.EditText;

import com.example.muril.e_commerce.LoginActivity;
import com.example.muril.e_commerce.LojaMain;
import com.example.muril.e_commerce.R;
import com.example.muril.e_commerce.Usuario;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by Murilo on 06/06/2017.
 */

public class LibraryClass {

    private static Firebase firebase;
    static Usuario user;

    public static Firebase getFirebase() {
        if (firebase == null) {
            firebase = new Firebase("https://e-commerce-aa1f2.firebaseio.com/");
        }
        return firebase;
    }

    public static Usuario getUser() {

        firebase = new Firebase("https://e-commerce-aa1f2.firebaseio.com/Usuario/Logado");
        firebase.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot valor : dataSnapshot.getChildren()) {
                            Usuario user2 = valor.getValue(Usuario.class);
                            user = user2;
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                    }

                }

        );
    return user;
    }

}
