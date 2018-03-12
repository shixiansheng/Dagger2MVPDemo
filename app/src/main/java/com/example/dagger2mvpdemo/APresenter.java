package com.example.dagger2mvpdemo;

import android.text.TextUtils;

import com.example.dagger2mvpdemo.base.BaseModel;
import com.example.dagger2mvpdemo.base.BasePresenter;
import com.example.dagger2mvpdemo.base.BaseResponse;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;

/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */

public class APresenter extends BasePresenter<MBaseView> {

    @Inject
    BaseModel<String,String> baseModel;


    @Inject
    public APresenter(MBaseView mView) {
        super(mView);
    }


    public <P> void relevance(){//http://baobab.kaiyanapp.com/api/v2/ ?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
        baseModel.getResponse().subscribe(new Consumer<ResponseBody>() {
            @Override
            public void accept(ResponseBody responseBody) throws Exception {
                String json = responseBody.string();
                if (TextUtils.isEmpty(json))return;
                BaseResponse<P> objectBaseResponse = new BaseResponse<>(json);
               mView.showData(objectBaseResponse);
            }
        });
    };
}
