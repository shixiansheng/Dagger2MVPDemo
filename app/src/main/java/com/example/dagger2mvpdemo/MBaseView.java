package com.example.dagger2mvpdemo;

import com.example.dagger2mvpdemo.base.BaseEntity;
import com.example.dagger2mvpdemo.base.BaseResponse;
import com.example.dagger2mvpdemo.base.BaseView;
import com.example.dagger2mvpdemo.entity.User;

import java.util.List;

/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */
public interface MBaseView extends BaseView {
    void showData(BaseEntity<List<User>> t);
}
