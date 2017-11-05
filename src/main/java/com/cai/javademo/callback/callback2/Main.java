package com.cai.javademo.callback.callback2;

/**
 * 同步回调
 * Created by reason on 17/11/5.
 */
public class Main {
    public static void main(String[] args) {
        Caller caller = new Caller();
        //方式1.
        caller.call(new ICallback() {
            @Override
            public void onSuccess(String s) {
                System.out.println("终于回调成功"+s);
            }

            @Override
            public void onError() {
                System.out.println("处理失败");
            }
        });
        System.out.println("fnagshi1");
        //方式2.
        ICallback callbackb = new ICallback() {
            @Override
            public void onSuccess(String s) {
                System.out.println("终于回调成功2"+s);
            }

            @Override
            public void onError() {
                System.out.println("处理失败2");
            }
        };
        caller.call(callbackb);

        //方式3.
        CallbackImpl callback = new CallbackImpl();
        caller.call(callback);
    }
}
