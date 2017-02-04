package id.co.picklon.model.rest.utils;

import java.util.ArrayList;
import java.util.List;

import id.co.picklon.model.entities.Response;
import rx.functions.Func1;

//对Func1 进行封装  只让返回 当前的处理结果的 返回数据,
public class HttpResultFunc<T> implements Func1<Response<T>, List<Response<T>.Data<T>>> {

    @Override
    public List<Response<T>.Data<T>> call(Response<T> response) {
        if (response == null) {
            throw new NullPointerException();
        } else if (response.getDataList() == null) {
            return new ArrayList<>();
        } else if (response.getDataList().get(0).getCode() == -1) {
            String errMsg = response.getDataList().get(0).getMsg();
            throw new ErrorResponseException(errMsg);
        }

        return response.getDataList();
    }
}

//public class HttpResultFunc<T> implements Func1<Response<T>, Observable<Response.Data>> {
//
//    @Override
//    public Observable<Response.Data> call(Response<T> response) {
//        if (response == null) {
//            throw new NullPointerException();
//        }
//
//        return Observable.from(response.getDataList());
//    }
//}