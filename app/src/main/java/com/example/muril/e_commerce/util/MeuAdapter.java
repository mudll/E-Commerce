package com.example.muril.e_commerce.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.muril.e_commerce.Produtos;
import com.example.muril.e_commerce.R;

import java.util.ArrayList;

/**
 * Created by muril on 04/04/2017.
 */

public class MeuAdapter extends BaseAdapter {

    private LayoutInflater inflador;
    private ArrayList<Produtos> produtos;


    public MeuAdapter(Context context, ArrayList<Produtos> produtos) {
        this.produtos = produtos;
        inflador = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        Produtos produto = produtos.get(position);
        v = inflador.inflate(R.layout.prodlist_form, null);


        String prod2 = Integer.toString(produto.prodPrec);

        ((TextView) v.findViewById(R.id.nomeTxt)).setText(produto.prodNome);
        //((TextView) v.findViewById(R.id.depaTxt)).setText(produto.prodDepa);
        ((TextView) v.findViewById(R.id.precTxt)).setText(prod2);
        ((TextView) v.findViewById(R.id.descTxt)).setText(produto.prodDesc);

        return v;
    }
}
