package id.co.picklon.model.data;

import android.content.Context;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import id.co.picklon.model.entities.AD;
import id.co.picklon.model.entities.Address;
import id.co.picklon.model.entities.Article;
import id.co.picklon.model.entities.Order;
import id.co.picklon.model.entities.Token;
import id.co.picklon.model.entities.WashService;
import id.co.picklon.model.rest.PicklonService;
import id.co.picklon.model.rest.utils.HttpResultFunc;
import id.co.picklon.model.rest.utils.RxUtil;
import id.co.picklon.utils.Picklon;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

@SuppressWarnings("unchecked")
public class DataSource {
    private Context mContext;
    private PicklonService service;

    @Inject
    public DataSource(Context context, PicklonService service) {
        this.mContext = context;
        this.service = service;
    }

    //返回 ptk 码 用于之后的一系列操作
    private Observable<String> getPtk() {
        return service.getPtk()
                .map(new HttpResultFunc<>())
                .map(datas -> datas.get(0).getData());
    }

    Subscription getVerifyCode(String phoneNumber, Action1 successListener, Action1<Throwable> errorListener) {
        Map<String, Object> map = new HashMap<>();
        map.put("m", phoneNumber);

        return service.getVerifyCode(new Gson().toJson(map))
                .compose(RxUtil.applyIOToMainThreadSchedulers())
                .subscribe(successListener, errorListener);
    }

    Observable<Token> register(String phoneNumber, String password, String verifyCode) {
        return getPtk().flatMap(ptk -> doRegister(ptk, phoneNumber, password, verifyCode))
                .compose(RxUtil.applyIOToMainThreadSchedulers());
    }

    private Observable doRegister(String ptk, String phoneNumber, String password, String verifyCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("ptk", ptk);
        map.put("c", verifyCode);
        map.put("m", phoneNumber);
        map.put("p", password);
        // 是否是商户端
        map.put("s", 0);

        return service.register(new Gson().toJson(map))
                .map(new HttpResultFunc<>())
                .map(datas -> datas.get(0).getData());
    }

    Observable<Token> login(String phoneNumber, String password) {
        return getPtk().flatMap(ptk -> doLogin(ptk, phoneNumber, password))
                .compose(RxUtil.applyIOToMainThreadSchedulers());
    }

    private Observable<Token> doLogin(String ptk, String phoneNumber, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("ptk", ptk);
        map.put("m", phoneNumber);
        map.put("p", password);
        map.put("s", 0);

        return service.login(new Gson().toJson(map))
                .map(new HttpResultFunc<>())
                .map(datas -> datas.get(0).getData());
    }

    Observable<Object> resetPassword(String phoneNumber, String password, String verifyCode) {
        return getPtk().flatMap(ptk -> doReset(ptk, phoneNumber, password, verifyCode))
                .compose(RxUtil.applyIOToMainThreadSchedulers());
    }

    private Observable doReset(String ptk, String phoneNumber, String password, String verifyCode) {
        Map<String, Object> map = Picklon.commonMap();
        map.put("ptk", ptk);
        map.put("c", verifyCode);
        map.put("m", phoneNumber);
        map.put("p", password);
        map.put("s", 0);

        // empty list, so not fetch first data
        return service.resetPasword(new Gson().toJson(map))
                .map(new HttpResultFunc<>());
    }

  
}
