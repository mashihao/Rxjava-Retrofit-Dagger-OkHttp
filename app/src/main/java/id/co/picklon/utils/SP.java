package id.co.picklon.utils;

import android.content.SharedPreferences;

public class SP {
    public static final String TK = "token";
    public static final String MOBILE = "mobile";
    public static final String PASSWORD = "password";
    public static final String DEFAULT_ADDRESS = "default_address";

    public static void saveToken(SharedPreferences.Editor editor, String token) {
        Picklon.TOKEN = token;
        editor.putString(TK, token).apply();
    }
}
