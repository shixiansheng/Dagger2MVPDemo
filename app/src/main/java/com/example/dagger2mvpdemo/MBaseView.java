package com.example.dagger2mvpdemo;

import com.example.dagger2mvpdemo.base.BaseResponse;
import com.example.dagger2mvpdemo.base.BaseView;

/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */
public interface MBaseView<T> extends BaseView {
    void showData(BaseResponse<T> t);
}
