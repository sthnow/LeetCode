package DesignMode;

/**
 * 单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。这个类称为单例类
 */
public class SingletonPattern {

    //定义一个静态变量singleton
    private volatile static SingletonPattern singleton;

    //定义一个私有的构造器
    private SingletonPattern(){}

    //得到实例的方法
    public static SingletonPattern getInstance(){
        //首先判断实例是否存在,如果不存在再创建实例
        if(singleton == null){
            //同步代码块
            synchronized(SingletonPattern.class){
                //防止多线程环境下引起的问题，再判断一次实例是否存在
            if(singleton == null){
                singleton = new SingletonPattern();
            }
            }
        }
        return singleton;
    }
}
