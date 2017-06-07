package com.example.muril.e_commerce.util;

import android.app.Application;
import com.firebase.client.Firebase;


/**
 * Created by Murilo on 06/06/2017.
 */

public class CustomApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
