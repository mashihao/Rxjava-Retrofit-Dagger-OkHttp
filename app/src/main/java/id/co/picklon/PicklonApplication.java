package id.co.picklon;

import android.app.Application;

import id.co.picklon.injector.components.AppComponent;
import id.co.picklon.injector.components.DaggerAppComponent;
import id.co.picklon.injector.modules.AppModule;
import id.co.picklon.utils.L;

public class PicklonApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        L.init();
        initializeInjector();
    }

    private void initializeInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
