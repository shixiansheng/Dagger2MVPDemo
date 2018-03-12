package com.example.dagger2mvpdemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import javax.inject.Inject;



public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    @Inject
    protected P mPresenter;

    public abstract void inject();
    public abstract void initView();
    public abstract void initData();
    public abstract int initLayout();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        inject();
        initView();
        initData();
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null)
            mPresenter.detach();
    }

    /**
     * 无参跳转
     * @param clz
     */
    public void startActivity(Class<?> clz){
        Intent intent = new Intent(this,clz);
        startActivity(intent);
    }
    /**
     * 显示toast
     * @param msg
     */
    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 有参跳转
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle){
        Intent intent = new Intent(this,clz);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void startActivityForResult(Class<?> clz, Bundle bundle, int requestCode){
        Intent intent = new Intent(this,clz);
        intent.putExtras(bundle);
        startActivityForResult(intent,requestCode);
    }

}
