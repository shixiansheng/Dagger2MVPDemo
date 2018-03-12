package com.example.dagger2mvpdemo.base;

import com.example.dagger2mvpdemo.base.BaseView;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */


public  class BaseModule<T> {

    public T view;


    public BaseModule(T view) {
        this.view = view;
    }



}