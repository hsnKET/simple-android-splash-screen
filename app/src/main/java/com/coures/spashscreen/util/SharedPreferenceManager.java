package com.coures.spashscreen.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceManager {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static final String SHARED_PREFERENCE_NAME = "test";

    public SharedPreferenceManager(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void put(String key,String value){
        editor.putString(key,value);
        editor.commit();
    }
    public void put(String key,boolean value){
        editor.putBoolean(key,value);
        editor.commit();
    }
    public void put(String key,int value){
        editor.putInt(key,value);
        editor.commit();
    }
    public String getString(String key){
        return sharedPreferences.getString(key,"");
    }
    public int getInt(String key){
        return sharedPreferences.getInt(key,0);
    }
    public void remove(String key){
        editor.remove(key);
    }
}
