package com.example.muril.e_commerce.util;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by muril on 05/04/2017.
 */

public class MensagemUtil {

    public static void addMsg(Activity activity, String msg){
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

}
