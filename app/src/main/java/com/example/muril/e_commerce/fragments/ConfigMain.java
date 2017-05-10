package com.example.muril.e_commerce.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.muril.e_commerce.CadastroActivity;
import com.example.muril.e_commerce.LoginActivity;
import com.example.muril.e_commerce.R;
import com.example.muril.e_commerce.util.ArrayFormEdit;
import com.example.muril.e_commerce.util.Validate;

import java.util.ArrayList;

/**
 * Created by muril on 10/05/2017.
 */

public class ConfigMain extends Fragment {
    Button pass;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.content_conf_main, container, false);

        pass = (Button) v.findViewById(R.id.btnConf);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passCheck(v);
            }
        });

        return v;
    }

    public void passCheck(View v) {
        ArrayList<ArrayFormEdit> senhas = new ArrayList<>();
        senhas.add(new ArrayFormEdit((EditText) getActivity().findViewById(R.id.conf_senha_nova1), "Senha"));
        senhas.add(new ArrayFormEdit((EditText) getActivity().findViewById(R.id.conf_senha_nova2), "Confirmar Senha"));

        Validate.validateSenha(senhas);
    }
}
