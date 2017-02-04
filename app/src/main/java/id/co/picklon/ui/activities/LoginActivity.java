package id.co.picklon.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.picklon.R;
import id.co.picklon.model.data.AccountManager;
import id.co.picklon.model.entities.Token;
import id.co.picklon.model.rest.utils.ProgressSubscriber;
import id.co.picklon.model.rest.utils.SubscriberOnNextListener;
import id.co.picklon.utils.ViewUtils;

public class LoginActivity extends BaseActivity implements SubscriberOnNextListener {
    @BindView(R.id.login_in)
    Button loginInView;
    @BindView(R.id.login_forgot_password)
    TextView forgotPassView;
    @BindView(R.id.login_phone_number)
    EditText phoneNumberView;
    @BindView(R.id.login_password)
    EditText passwordView;

    @Inject
    AccountManager accountManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        activityComponent().inject(this);

        forgotPassView.setOnClickListener(view -> Toast.makeText(this, "ResetPasswordActivity", Toast.LENGTH_SHORT).show());

        loginInView.setOnClickListener(view -> {
            String phoneNumber = phoneNumberView.getText().toString().trim();
            String password = passwordView.getText().toString().trim();

            if (TextUtils.isEmpty(phoneNumber) || TextUtils.isEmpty(password)) {
                ViewUtils.showDialog(this, R.string.field_tips);
                return;
            }
            accountManager.newLogin(phoneNumber, password)
                    .subscribe(new ProgressSubscriber<>(LoginActivity.this, this::doSuccess));
        });
    }

    private void doSuccess(Token token) {
        setResult(RESULT_OK, null);
        finish();
    }

    @Override
    public void onNext(Object o) {
        setResult(RESULT_OK, null);
        finish();
    }
}
