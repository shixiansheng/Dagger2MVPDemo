package com.example.dagger2mvpdemo;

import com.example.dagger2mvpdemo.base.BaseEntity;
import com.example.dagger2mvpdemo.base.BaseModel;
import com.example.dagger2mvpdemo.base.BasePresenter;
import com.example.dagger2mvpdemo.base.ResultCallback;
import com.example.dagger2mvpdemo.entity.User;

import java.util.List;

import javax.inject.Inject;

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


    public  void getUser(String path){//http://baobab.kaiyanapp.com/api/v2/ ?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
        baseModel.getResponse(path, new ResultCallback<BaseEntity<List<User>>>() {
            @Override
            public void onResponse(BaseEntity<List<User>> response, String json) {
                mView.showData(response);
            }
        });
    };
}
