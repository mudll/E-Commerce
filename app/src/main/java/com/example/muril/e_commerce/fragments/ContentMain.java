package com.example.muril.e_commerce.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.muril.e_commerce.util.MensagemUtil;
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
    String strmaster;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public ContentMain vaindo(String str){
        strmaster = str;
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (strmaster == null) {
            produtos = Produtos.getProdutos();
        } else {
            produtos = Produtos.fazoteste(strmaster);
        }

        View v = inflater.inflate(R.layout.prodlist_activity, container, false);

        meuAdapter = new MeuAdapter(getActivity(), produtos);
        produtosLista = (ListView) v.findViewById(R.id.listProd);
        produtosLista.setAdapter(meuAdapter);
        produtosLista.setOnItemClickListener(this);

        return v;
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Produtos prod2 = meuAdapter.getItem(position);
        MensagemUtil.addMsg(this.getActivity(), "Escolhido: " + prod2.prodNome);

        ProdutoMain produtoFrag = new ProdutoMain();
        Bundle dados = new Bundle();
        dados.putString("DADOSFRAG", prod2.prodNome);
        produtoFrag.setArguments(dados);
        getFragmentManager().beginTransaction().replace(R.id.mainfrag, produtoFrag).commit();

    }
}
