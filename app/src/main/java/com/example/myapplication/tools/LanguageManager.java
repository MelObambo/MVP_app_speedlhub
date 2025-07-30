package com.example.myapplication.tools;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

public class LanguageManager {
    private final Context context;

    public void updateResources(String code) {
        String[] localeParts = code.split("_");
        Locale locale;
        if (localeParts.length == 2) {
            locale = new Locale(localeParts[0], localeParts[1]);
        } else {
            locale = new Locale(code);
        }
        Locale.setDefault(locale);

        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }
    public LanguageManager(Context ct){
        this.context = ct;
    }
}