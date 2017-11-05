package com.cai.javademo.callback.callback2;

/**
 * Created by reason on 17/11/5.
 */
public class CallbackImpl implements ICallback {
    @Override
    public void onSuccess(String s) {
        System.out.println("回调成功3");
    }

    @Override
    public void onError() {
        System.out.println("处理失败3");
    }
}
