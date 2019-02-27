###RXJAVA入门

RXJAVA 2.X
api:http://reactivex.io/RxJava/2.x/javadoc/  
背压官方解释： https://github.com/ReactiveX/RxJava/wiki/Backpressure

RXJAVA里的两个核心部分：观察者(Subscriber)和被观察者(Observable)  顾名思义，observable负责发出事件，subscriber负责接收并处理事件。

RXJAVA 2.X中 四个核心的方法类：
FLOWABLE : 支持背压，在创建时需要指定背压策略
OBSERVABLE ：不支持背压
除此外使用方法类似
