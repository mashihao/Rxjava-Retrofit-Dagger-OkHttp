package id.co.picklon.ui.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import id.co.picklon.PicklonApplication;
import id.co.picklon.injector.components.ActivityComponent;
import id.co.picklon.injector.components.DaggerActivityComponent;
import id.co.picklon.injector.modules.ActivityModule;
import id.co.picklon.utils.L;
import rx.subscriptions.CompositeSubscription;

public class BaseActivity extends AppCompatActivity {
    public CompositeSubscription compositeSubscription;

    public ActivityComponent activityComponent() {
        PicklonApplication application = (PicklonApplication) getApplication();

        return DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(application.getAppComponent())
                .build();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        L.e(compositeSubscription.hasSubscriptions() + "");
        compositeSubscription.unsubscribe();
    }
}
