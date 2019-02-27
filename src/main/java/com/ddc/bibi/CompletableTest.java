package com.ddc.bibi;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;


public class CompletableTest {

    public static void main(String[] args) {
        Completable completable = Completable.create(emitter -> {
            emitter.onError(new Throwable("completable test  on error"));
            // 并不发射数据
            emitter.onComplete();
        });
        completable.subscribe(new CompletableObserver() {
            private Disposable disposable;

            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
                System.out.println("onSubscribe");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");

            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError : " + e.getMessage());

            }
        });
    }
}
