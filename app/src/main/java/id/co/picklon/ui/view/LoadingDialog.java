package id.co.picklon.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import id.co.picklon.R;

public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_loading);

        setCanceledOnTouchOutside(false);
//        setCancelable(false);
    }
}
