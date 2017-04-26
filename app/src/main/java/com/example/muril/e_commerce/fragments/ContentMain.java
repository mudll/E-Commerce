package com.example.muril.e_commerce.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.muril.e_commerce.util.MeuAdapter;
import com.example.muril.e_commerce.Produtos;
import com.example.muril.e_commerce.R;

import java.util.ArrayList;

/**
 * Created by muril on 04/04/2017.
 */

public class ContentMain extends Fragment implements AdapterView.OnItemClickListener {

    ArrayList<Produtos> produtos;
    ListView produtosLista;
    MeuAdapter meuAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        produtos = Produtos.getProdutos();
        meuAdapter = new MeuAdapter(getActivity(), produtos);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.prodlist_activity, container, false);
        produtosLista = (ListView) v.findViewById(R.id.listProd);
        produtosLista.setAdapter(meuAdapter);
        //produtosLista.setOnItemClickListener(this);

        return v;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
