package id.co.picklon.model.rest.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

@SuppressWarnings("unchecked")
public class RxUtil {
    private static Observable.Transformer ioToMainThreadSchedulerTransformer;
    private static Observable.Transformer ioToMainThreadSchedulerTransformerWithMap;

    static {
        ioToMainThreadSchedulerTransformer = createIOToMainThreadScheduler();
        ioToMainThreadSchedulerTransformerWithMap = createIOToMainThreadSchedulerWithMap();
    }

    private static <T> Observable.Transformer<T, T> createIOToMainThreadScheduler() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private static <T> Observable.Transformer<T, T> createIOToMainThreadSchedulerWithMap() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap((Func1) new HttpResultFunc<>());
    }

    public static <T> Observable.Transformer<T, T> applyIOToMainThreadSchedulers() {
        return ioToMainThreadSchedulerTransformer;
    }

    public static <T> Observable.Transformer<T, T> applyIOToMainThreadSchedulersWithMap() {
        return ioToMainThreadSchedulerTransformerWithMap;
    }
}
