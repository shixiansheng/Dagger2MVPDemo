package com.example.dagger2mvpdemo.base;

import android.text.TextUtils;

import com.example.dagger2mvpdemo.utils.GsonUtils;
import com.google.gson.internal.$Gson$Types;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.Call;

/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */

public class BaseResponse extends ResponseData {


    public BaseResponse(String json) {
        super(json);
    }

    public void  getData(ResultCallback resultCallback)
    {
        resultCallback.onResponse(GsonUtils.getInstance().fromJson(mData, resultCallback.mType));
    }

    public static abstract class ResultCallback<T>
    {
        Type mType;

        public ResultCallback()
        {
            mType = getSuperclassTypeParameter(getClass());
        }

        static Type getSuperclassTypeParameter(Class<?> subclass)
        {
            //通过反射得到泛型参数
            //Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
            Type superclass = subclass.getGenericSuperclass();
            if (superclass instanceof Class)
            {
                throw new RuntimeException("Missing type parameter.");
            }
            //ParameterizedType参数化类型，即泛型
            ParameterizedType parameterized = (ParameterizedType) superclass;
            //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
            //将Java 中的Type实现,转化为自己内部的数据实现,得到gson解析需要的泛型
            return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
        }

        public abstract void onResponse(T response);
    }
}
