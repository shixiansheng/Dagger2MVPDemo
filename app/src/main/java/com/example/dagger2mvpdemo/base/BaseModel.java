package com.example.dagger2mvpdemo.base;


import com.example.dagger2mvpdemo.utils.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;


/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */

public  class BaseModel<K,V> {

    private Map map=new HashMap();

    @Inject
    public BaseModel() {
    }


    public BaseModel<K,V> setKeyMap(K key, V value)
    {
        map.put(key,value);
        return this;
    }

    public BaseModel<K, V> clearMap()
    {
        map.clear();
        return this;
    }
    public Observable<ResponseBody> getResponse() {
        return  RetrofitManager.getInstance().execute("quarter/getJokes",map);
    }
}
