package com.example.projectnhatro;

import android.content.Context;
import android.content.SharedPreferences;

public class _logedUser {

    public static void clearLoggedInUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("username");
        editor.remove("loggedIn");
        editor.apply();
    }
}
