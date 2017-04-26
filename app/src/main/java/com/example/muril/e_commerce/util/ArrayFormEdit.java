package com.example.muril.e_commerce.util;

import android.widget.EditText;

import java.io.Serializable;

/**
 * Created by muril on 05/04/2017.
 */


public class ArrayFormEdit implements Serializable {

    public EditText editTxt;
    public String editNme;

    public ArrayFormEdit(EditText editTxt, String editNme) {
        this.editTxt = editTxt;
        this.editNme = editNme;
    }
}

