package com.example.dagger2mvpdemo.common;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */

public  interface APIService {

    @FormUrlEncoded
    @POST()
    Observable<ResponseBody> request(@Url String path, @FieldMap Map<String, String> map);

    @POST()
    Observable<ResponseBody> upLoad(@Url String path, @Body RequestBody requestBody);

    @GET()
    Observable<ResponseBody> request(@Url String path);
}
