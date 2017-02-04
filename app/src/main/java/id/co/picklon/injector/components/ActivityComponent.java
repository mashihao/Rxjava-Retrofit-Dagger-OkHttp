package id.co.picklon.injector.components;

import dagger.Component;
import id.co.picklon.MainActivity;
import id.co.picklon.injector.Activity;
import id.co.picklon.injector.modules.ActivityModule;
import id.co.picklon.ui.activities.LoginActivity;

@Activity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
}
