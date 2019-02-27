package com.ddc.bibi;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class SingleTest {

    public static void main(String[] args) {
        Single<String> single = Single.create(emitter -> {
            //single只发射一个元素
//            emitter.onSuccess("single  test  success");
            emitter.onError(new Throwable("onError"));

        });

        single.subscribe(new SingleObserver<String>() {
            private Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
                System.out.println("onSubscribe");
            }

            @Override
            public void onSuccess(String s) {

                System.out.println("onSuccess");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");

            }
        });
    }
}
