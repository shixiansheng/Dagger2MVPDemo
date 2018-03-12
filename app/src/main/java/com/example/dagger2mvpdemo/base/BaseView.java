package com.example.dagger2mvpdemo.base;

/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */

public interface BaseView {
    void showProgress();
    void hideProgress();
    void showError(String error);

}
