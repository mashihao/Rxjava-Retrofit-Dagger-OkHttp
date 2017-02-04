package id.co.picklon.injector.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import id.co.picklon.PicklonApplication;
import id.co.picklon.model.rest.PicklonService;
import id.co.picklon.utils.L;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    // 10 M 内存
    private static final int DISK_CACHE_SIZE = 10 * 1024 * 1024;

    private final PicklonApplication application;

    public AppModule(PicklonApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    PicklonApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(PicklonApplication app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides
    @Singleton
    SharedPreferences.Editor providesSharedPreferencesEdit(SharedPreferences sharedPreferences) {
        return sharedPreferences.edit();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> Log.w("okhttp", message));
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(PicklonApplication app, HttpLoggingInterceptor interceptor) {
        return createOkHttpClient(app, interceptor).build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(PicklonService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    PicklonService provideMeecaaService(Retrofit retrofit) {
        return retrofit.create(PicklonService.class);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Picasso providePicasso(PicklonApplication app, OkHttpClient client) {
        return new Picasso.Builder(app)
                .downloader(new OkHttp3Downloader(client))
                .listener((picasso, uri, e) -> L.e("Failed to load image: %s", uri))
                .build();
    }

    private static OkHttpClient.Builder createOkHttpClient(PicklonApplication app, HttpLoggingInterceptor interceptor) {
        File cacheDir = new File(app.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);

        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(cache);
    }
}
