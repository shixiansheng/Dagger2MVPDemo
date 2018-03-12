package com.example.dagger2mvpdemo.base;

import javax.inject.Inject;

/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */

public class BasePresenter<P> {

    public  P mView;

    public BasePresenter(P mView) {
        this.mView = mView;
    }

    public void detach()
    {
        mView=null;
    }
}
