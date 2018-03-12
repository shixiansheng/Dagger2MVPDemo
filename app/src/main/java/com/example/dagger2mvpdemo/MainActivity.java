package com.example.dagger2mvpdemo;
import com.example.dagger2mvpdemo.base.BaseActivity;
import com.example.dagger2mvpdemo.base.BaseResponse;
import com.example.dagger2mvpdemo.entity.User;

public class MainActivity extends BaseActivity<APresenter> implements MBaseView<User> {

    @Override
    public void inject() {
        DaggerAComponent.builder().aModule(new AModule(this)).build().inject(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        mPresenter.<BaseResponse<User>>relevance();
        System.out.println(mPresenter+"mPresenter");
        System.out.println(mPresenter.mView);

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
    public void showData(BaseResponse<User> t) {
        System.out.println(t.mMsg);
    }
}
