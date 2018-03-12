package com.example.dagger2mvpdemo.utils;


import com.example.dagger2mvpdemo.common.APIService;
import com.example.dagger2mvpdemo.common.Api;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */

public class RetrofitManager {
    private volatile static  RetrofitManager retrofitManager;
    private final Retrofit retrofit;
    private RetrofitManager() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(8000, TimeUnit.SECONDS)  //设置连接超时时间
                .readTimeout(5000, TimeUnit.SECONDS)  //设置读取超时时间
                .writeTimeout(5000, TimeUnit.SECONDS)  //设置写入超时时间
                //.addInterceptor(new ParamInterceptor())//添加其他拦截器
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder().baseUrl(Api.baseUrl).client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitManager getInstance()
    {
        if (retrofitManager==null)
        {
            synchronized (RetrofitManager.class){
                if (retrofitManager==null)
                {
                    retrofitManager=new RetrofitManager();
                    return retrofitManager;
                }
            }
        }
        return retrofitManager;
    }
    public  Observable<ResponseBody> execute(String path, Map<String,String> map)
    {
        APIService apiService = retrofit.create(APIService.class);
            Observable<ResponseBody> request;
        if (map!=null&&map.size()>0) {
            request = apiService.request(path, map);
        }else
        {
            request = apiService.request(path);
        }
            return  request.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
    }
}
