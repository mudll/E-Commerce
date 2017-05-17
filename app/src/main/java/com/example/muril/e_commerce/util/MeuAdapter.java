package com.example.muril.e_commerce.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
    public Produtos getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        Produtos produto = produtos.get(position);

        if (v == null) {
            v = inflador.inflate(R.layout.prodlist_form, parent, false);
        }


        String prod2 = Integer.toString(produto.prodPrec);

        ((TextView) v.findViewById(R.id.nomeTxt)).setText(produto.prodNome);
        ((TextView) v.findViewById(R.id.precTxt)).setText(prod2);
        ((TextView) v.findViewById(R.id.descTxt)).setText(produto.prodDesc);

        String switchVar = produto.prodDepa;

        switch (switchVar) {
            case "Desktop":
                ((ImageView) v.findViewById(R.id.imageViewV)).setImageResource(R.mipmap.ic_desktop_windows_black_48dp);
                break;
            case "Notebook":
                ((ImageView) v.findViewById(R.id.imageViewV)).setImageResource(R.mipmap.ic_laptop_mac_black_48dp);
                break;
            case "Acessorios":
                ((ImageView) v.findViewById(R.id.imageViewV)).setImageResource(R.mipmap.ic_mouse_black_48dp);
                break;
            case "Smartphone":
                ((ImageView) v.findViewById(R.id.imageViewV)).setImageResource(R.mipmap.ic_phonelink_ring_black_48dp);
                break;
            case "Tv":
                ((ImageView) v.findViewById(R.id.imageViewV)).setImageResource(R.mipmap.ic_tv_black_48dp);
                break;
            case "Camera":
                ((ImageView) v.findViewById(R.id.imageViewV)).setImageResource(R.mipmap.ic_camera_alt_black_48dp);
                break;
            default:
                ((ImageView) v.findViewById(R.id.imageViewV)).setImageResource(R.mipmap.logo);
                break;

        }


        return v;
    }
}
