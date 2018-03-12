package com.example.dagger2mvpdemo;

import com.example.dagger2mvpdemo.base.BaseModule;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * @author 时志邦
 * @Description: ${TODO}(用一句话描述该文件做什么)
 */
@Module
public class AModule extends BaseModule<MBaseView> {


    @Inject
    public AModule(MBaseView view) {
        super(view);
    }

    @Provides
    public MBaseView provideTempLateView() {
        return view;
    }


}
