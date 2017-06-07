package com.example.muril.e_commerce;


import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.muril.e_commerce.util.LibraryClass;
import com.example.muril.e_commerce.util.MensagemUtil;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Murilo on 06/06/2017.
 */

public class CarrinhoFB extends Activity {

    private Firebase firebase;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);
















//        firebase = LibraryClass.getFirebase();
//
//        ArrayList<Produtos> prodBD;
//        prodBD = Produtos.getProdutos();
//
//        Produtos prod;
//        for(int i = 0; i < prodBD.size(); i++) {
//            prod = prodBD.get(i);
//            String id = firebase.push().getKey();
//            firebase.child("Produtos").child(String.valueOf(id)).setValue(prod);
//        }

    }


}
