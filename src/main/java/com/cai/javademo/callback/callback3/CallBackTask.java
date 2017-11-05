package com.cai.javademo.callback.callback3;

/**
 * Created by reason on 17/11/5.
 */
public class CallBackTask {
    private ICallback iCallback;
    public CallBackTask(ICallback iCallback){
        this.iCallback = iCallback;
    }
    protected void start(final Object context){
        final Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    iCallback.execute(context);
                } catch (Exception e) {
                    e.printStackTrace();
                    iCallback.onError(context);
                }
                iCallback.onSuccess(context);
            }
        });
        t.start();
    }
}
