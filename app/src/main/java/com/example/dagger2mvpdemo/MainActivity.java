package com.example.dagger2mvpdemo;

import android.widget.TextView;

import com.example.dagger2mvpdemo.base.BaseActivity;
import com.example.dagger2mvpdemo.base.BaseEntity;
import com.example.dagger2mvpdemo.base.BaseResponse;
import com.example.dagger2mvpdemo.entity.User;

import java.util.List;

public class MainActivity extends BaseActivity<APresenter> implements MBaseView {

    /**
     * Hello World!
     */
    private TextView mTv;

    @Override
    public void inject() {
        DaggerAComponent.builder().aModule(new AModule(this)).build().inject(this);
    }

    @Override
    public void initView() {

        mTv = (TextView) findViewById(R.id.tv);
    }

    @Override
    public void initData() {
        mPresenter.getUser("home/getTop");
    }

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String error) {

    }


    @Override
    public void showData(BaseEntity<List<User>> t) {
        mTv.setText(t.Data.get(0).title);
    }
}
