package com.example.muril.e_commerce.util;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by muril on 05/04/2017.
 */

public class Validate {


    public static boolean validateNotNull(ArrayList<ArrayFormEdit> camposForm) {

        for (int i = 0; i < camposForm.size(); i++) {
            EditText pegEdit = camposForm.get(i).editTxt;
            String strNme = camposForm.get(i).editNme;
            Editable txtEdit = pegEdit.getText();

            if (txtEdit != null) {
                String strEdit = txtEdit.toString();
                if (strEdit.startsWith(" ")) {
                    pegEdit.setFocusable(true);
                    pegEdit.requestFocus();
                    pegEdit.setError("Os campos não podem ser iniciados com espaço."); return false; }
                if (TextUtils.isEmpty(strEdit)) {

                    pegEdit.setFocusable(true);
                    pegEdit.requestFocus();
                    pegEdit.setError("O Campo " + strNme + " é Obrigatório");
                    return false;
                } else {
                    pegEdit.setError(null);

                }
            }
        }
        return true;
    }

    public static boolean validateCPF(EditText editCPF) {

        String CPF = editCPF.getText().toString();

        CPF = Mask.unmask(CPF);
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")) {
            editCPF.setFocusable(true);
            editCPF.requestFocus();
            editCPF.setError("CPF Inválido");
            return false;
        }
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48);
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return true;
            else
                editCPF.setFocusable(true);
            editCPF.requestFocus();
            editCPF.setError("CPF Inválido");
            return false;
        } catch (Exception erro) {
            return false;
        }
    }

    public final static boolean validateEmail(EditText editEmail) {
        String txtEmail = editEmail.getText().toString();
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches()) {
            editEmail.setFocusable(true);
            editEmail.requestFocus();
            editEmail.setError("Email Inválido");
            return false;
        } else return true;
    }

    public final static boolean validateSenha(ArrayList<ArrayFormEdit> senhaForm) {
        EditText new_senha = null;
        EditText new_repitasenha = null;

        for (int i = 0; i < senhaForm.size(); i++) {
            EditText editTxt = senhaForm.get(i).editTxt;
            String passCmp = senhaForm.get(i).editNme;
            if (passCmp.equals("Senha")) {
                new_senha = editTxt;
            } else if (passCmp.equals("Confirmar Senha")) {
                new_repitasenha = editTxt;
            }
        }

        if (new_senha.getText().toString().equals(new_repitasenha.getText().toString())) {
            return true;
        } else {
            new_repitasenha.setFocusable(true);
            new_repitasenha.requestFocus();
            new_repitasenha.setError("As Senhas Devem ser Iguais!");
            return false;
        }
    }
}
