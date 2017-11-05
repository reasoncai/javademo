package com.cai.javademo.callback;

/**
 * Created by reason on 17/11/5.
 */
public class Jack implements Student {
    @Override
    public void resolveQuestion(Callback callback) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.tellAnswer(6);
    }
}
