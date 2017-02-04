package id.co.picklon.injector.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import id.co.picklon.injector.Activity;

@Module
public class ActivityModule {
    private final Context mContext;

    public ActivityModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Activity
    Context provideActivityContext() {
        return mContext;
    }
}
