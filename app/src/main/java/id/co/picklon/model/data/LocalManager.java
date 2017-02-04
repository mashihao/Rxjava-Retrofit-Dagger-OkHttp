package id.co.picklon.model.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Inject;

import id.co.picklon.model.entities.Address;
import id.co.picklon.utils.SP;

public class LocalManager {
    private Context mContext;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Inject
    LocalManager(Context context, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        this.mContext = context;
        this.sharedPreferences = sharedPreferences;
        this.editor = editor;
    }

    public void saveDefaultAddress(Address address) {
        editor.putString(SP.DEFAULT_ADDRESS, new Gson().toJson(address));
        editor.apply();
    }

    public String getDefaultAddress() {
        return sharedPreferences.getString(SP.DEFAULT_ADDRESS, null);
    }

    public void removeDefaultAddress() {
        editor.putString(SP.DEFAULT_ADDRESS, null);
        editor.apply();
    }
}
