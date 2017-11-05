package com.cai.javademo.callback.callback2;

import java.util.Random;

/**
 * Created by reason on 17/11/5.
 */
public class Caller {
    public void call(ICallback callback){
        System.out.println("start...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        if(random.nextBoolean()){
            String s = "success";
        callback.onSuccess(s);}else {
            callback.onError();
        }
        System.out.println("end...");
    }
}
