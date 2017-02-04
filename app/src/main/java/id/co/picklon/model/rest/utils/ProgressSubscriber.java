package id.co.picklon.model.rest.utils;

import android.app.Dialog;
import android.content.Context;

import id.co.picklon.R;
import id.co.picklon.ui.view.LoadingDialog;
import id.co.picklon.utils.ViewUtils;
import rx.Subscriber;

//TODO 自定义 Subscriber, 默认的Subscriber 需要实现三个方法, 然而 我们只需要对 Call 方法 进行监听,  所以 封装一个Subscriber 只对call 方法来监听
public class ProgressSubscriber<T> extends Subscriber<T> {
    private SubscriberOnNextListener<T> mSubscriberOnNextListener;
    private Dialog loadDialog;
    private Context context;

    public ProgressSubscriber(Context context, SubscriberOnNextListener<T> mSubscriberOnNextListener) {
        this(context, mSubscriberOnNextListener, true);
    }

    public ProgressSubscriber(Context context, SubscriberOnNextListener<T> mSubscriberOnNextListener, boolean showProgress) {
        this.context = context;
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;

        if (showProgress) {
            loadDialog = new LoadingDialog(context);
            loadDialog.setOnCancelListener(dialogInterface -> dismissProgressDialog());
        }
    }

    //开启  bar
    private void showProgressDialog() {
        if (loadDialog != null && !loadDialog.isShowing()) {
            loadDialog.show();
        }
    }
    //关闭  progress bar
    private void dismissProgressDialog() {
        if (loadDialog != null && loadDialog.isShowing()) {
            loadDialog.cancel();
            loadDialog = null;
        }

        if (!isUnsubscribed()) {
            unsubscribe();
        }
    }

    @Override
    public void onStart() {
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ErrorResponseException) {
            ViewUtils.showDialog(context, e.getMessage());
        } else {
            ViewUtils.showDialog(context, R.string.network_error);
            e.printStackTrace();
        }

        dismissProgressDialog();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onNext(T t) {
        mSubscriberOnNextListener.onNext(t);
    }
}