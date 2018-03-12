package com.example.dagger2mvpdemo.base;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */
public class ResponseData {
    public static String CODE_OK = "1";
    public static String CODE_FAIL = "0";
    public static String CODE_FROZEN = "3";
    public static String CODE_NULL_DATA = "-1";
    public static String CODE_NO_USER = "4";
    public static String CODE_NOT_LOGIN = "2";
    public String mData;
    public String mCode;
    public String mMsg;
    private JSONObject mObject;

    public ResponseData(String data) {
            if (TextUtils.isEmpty(data))return;
        try {
            mObject = new JSONObject(data);//应该是response
            mCode = mObject.optString("code","");
            mMsg = mObject.optString("msg","");
            mData = mObject.optString("data","");
        } catch (JSONException e) {
            e.printStackTrace();
        }




    }
}
