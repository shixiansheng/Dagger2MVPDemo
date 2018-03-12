package com.example.dagger2mvpdemo.utils;

import com.google.gson.Gson;
/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */
public class GsonUtils {
    private volatile static Gson mGson = null;

    public static Gson getInstance()
    {
        if (mGson==null)
        {
            synchronized (RetrofitManager.class){
                if (mGson==null)
                {
                    mGson=new Gson();
                    return mGson;
                }
            }
        }
        return mGson;
    }
}