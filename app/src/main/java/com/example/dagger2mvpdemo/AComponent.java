package com.example.dagger2mvpdemo;

import dagger.Component;

/**
 * @author 时志邦
        * @Description: ${TODO}(用一句话描述该文件做什么)
        */
@Component(modules = AModule.class)
public interface AComponent {
    void inject(MainActivity mainActivity);
}
