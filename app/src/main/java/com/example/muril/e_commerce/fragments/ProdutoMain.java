package com.example.muril.e_commerce.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.muril.e_commerce.R;

/**
 * Created by muril on 26/04/2017.
 */

public class ProdutoMain extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.produto_main, container, false);
        ((TextView) v.findViewById(R.id.textView3)).setText(getArguments().getString("DADOSFRAG"));
        return v;

    }

}
