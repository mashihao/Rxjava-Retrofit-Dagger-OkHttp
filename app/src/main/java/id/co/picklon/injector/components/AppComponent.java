package id.co.picklon.injector.components;

import android.content.SharedPreferences;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;
import id.co.picklon.PicklonApplication;
import id.co.picklon.injector.modules.AppModule;
import id.co.picklon.model.rest.PicklonService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@Singleton
@Component(modules = AppModule.class)

public interface AppComponent {
    PicklonApplication app();
    HttpLoggingInterceptor httpLoggingInterceptor();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
    SharedPreferences.Editor sharedPreferencesEdit();
    PicklonService picklonService();
    Picasso picasso();
}