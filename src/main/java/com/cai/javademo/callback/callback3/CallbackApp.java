package com.cai.javademo.callback.callback3;

/**
 * 异步回调（起线程处理）
 * Created by reason on 17/11/5.
 */
public class CallbackApp {
    public static void main(String[] args) {
        System.out.println("准备开始执行异步任务。。。");
        final Object context = "上下文信息";
        new CallBackTask(new ICallback() {
            @Override
            public void onSuccess(Object context) {
                System.out.println("\n成功后的回调函数...");
                System.out.println(context);

            }

            @Override
            public void onError(Object context) {
                System.out.println("\n失败后的回调函数...");
                System.out.println(context);

            }

            @Override
            public void execute(Object context) throws Exception {
                System.out.println("\n正在执行耗时操作...");
                System.out.println(context);
                Thread.sleep(5000);
                System.out.println("\n执行完成！");
            }
        }).start(context);

        System.out.println("\n异步任务已经开始，请等待完成...");
    }
}
