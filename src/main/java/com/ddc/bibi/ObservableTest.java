package com.ddc.bibi;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/***
 * @author renxueyi
 */
public class ObservableTest {

    public static void main(String[] args) {

        Observable<Integer> observable =  Observable.create(emitter -> {
        emitter.onNext(1);
        System.out.println("Hello world");
        emitter.onNext(2);
        System.out.println("Hello world");

        emitter.onComplete();
        });

        observable.subscribe(new Observer<Integer>() {
            private Integer a;
            private Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
                System.out.println("onSubscribe" + d);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext" + integer + " " + disposable.isDisposed());
                disposable.dispose();
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");

            }
        });
    }


}
