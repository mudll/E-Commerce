package com.example.muril.e_commerce.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.muril.e_commerce.Produtos;
import com.example.muril.e_commerce.R;
import com.example.muril.e_commerce.Usuario;
import com.example.muril.e_commerce.util.LibraryClass;
import com.firebase.client.Firebase;

/**
 * Created by muril on 26/04/2017.
 */

public class ProdutoMain extends Fragment {

    Produtos prodV;
    private Firebase firebase;
    private Usuario userlog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        FloatingActionButton fab = (FloatingActionButton) getFragmentManager().getFragment()..   //findViewById(R.id.prodFab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Adicionado ao Carrinho", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//            }
//        });

    }

    public ProdutoMain dadosprod(Produtos prodVeio) {
        prodV = prodVeio;
        return null;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.produto_main, container, false);

       FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.prodFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adicionado ao Carrinho", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                firebase = LibraryClass.getFirebase();
//                userlog = LibraryClass.getUser();
//
//                String userlognick = userlog.getNick();


                Produtos prodt = new Produtos("Ts", "p", 100, "BD");
                String id = firebase.push().getKey();
                firebase.child("Carrinho").child(id).setValue(prodV);


            }
        });

        String precoStr = Integer.toString(prodV.prodPrec);

        ((TextView) v.findViewById(R.id.prodNome)).setText(prodV.prodNome);
        ((TextView) v.findViewById(R.id.prodDesc)).setText(prodV.prodDesc);
        ((TextView) v.findViewById(R.id.prodPreco)).setText(precoStr);

        final String switchVar = prodV.prodDepa;
        switch (switchVar) {
            case "Desktop":
                ((ImageView) v.findViewById(R.id.imageView2)).setImageResource(R.mipmap.ic_desktop_windows_black_48dp);
                break;
            case "Notebook":
                ((ImageView) v.findViewById(R.id.imageView2)).setImageResource(R.mipmap.ic_laptop_mac_black_48dp);
                break;
            case "Acessorios":
                ((ImageView) v.findViewById(R.id.imageView2)).setImageResource(R.mipmap.ic_mouse_black_48dp);
                break;
            case "Smartphone":
                ((ImageView) v.findViewById(R.id.imageView2)).setImageResource(R.mipmap.ic_phonelink_ring_black_48dp);
                break;
            case "Tv":
                ((ImageView) v.findViewById(R.id.imageView2)).setImageResource(R.mipmap.ic_tv_black_48dp);
                break;
            case "Camera":
                ((ImageView) v.findViewById(R.id.imageView2)).setImageResource(R.mipmap.ic_camera_alt_black_48dp);
                break;
            default:
                ((ImageView) v.findViewById(R.id.imageView2)).setImageResource(R.mipmap.logo);
                break;

        }

        Button button = (Button) v.findViewById(R.id.buttonVolt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentMain mFrag = new ContentMain();
                mFrag.vaindo(switchVar);
                getFragmentManager().beginTransaction().replace(R.id.mainfrag, mFrag).commit();

            }
        });

        return v;
    }
 }
