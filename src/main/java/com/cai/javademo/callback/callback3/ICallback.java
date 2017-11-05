package com.cai.javademo.callback.callback3;

/**
 * Created by reason on 17/11/5.
 */
public interface ICallback {
    void onSuccess(Object context);
    void onError(Object context);
    void execute(Object context) throws Exception;
}
