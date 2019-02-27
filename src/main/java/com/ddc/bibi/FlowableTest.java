package com.ddc.bibi;

import io.reactivex.*;
import org.reactivestreams.Subscription;

/***
 * @author renxueyi
 */
public class FlowableTest {

    public static void main(String[] args) {

        Flowable<String> flowable =  Flowable.create(emitter -> {
            emitter.onNext("flowable 1");
            System.out.println("~~~~~~~~~~~~");
            emitter.onNext("flowable 2");
            System.out.println("~~~~~~~~~~~~");
        },BackpressureStrategy.BUFFER);

        flowable.subscribe(new FlowableSubscriber<String>() {

            private Subscription subscription ;

            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe");
                subscription = s;
                s.request(100);

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext" + s);

            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError");
                subscription.cancel();

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete" );
                subscription.cancel();

            }
        });
    }
}
