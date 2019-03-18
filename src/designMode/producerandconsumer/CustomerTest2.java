package designMode.producerandconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者-消费者模型——使用可重入锁ReentrantLock实现
 *
 * 内置锁的条件队列存在两个问题
 *  1.过早唤醒
 *  2.信号丢失
 *
 *  而lock锁的条件队列能够解决这两个问题，每个lock对象对应多个条件队列
 *      例如本例中，当缓冲区满了以后，会调用notFull的wait方法将当前线程阻塞，唤醒等待在notEmpty上的线程，不存在过早唤醒和信号丢失的问题
 */
public class CustomerTest2 {
    //定义计数器
    private static Integer count = 0;
    private static final Integer FULL = 10;
    //创建一个锁对象
    private Lock lock = new ReentrantLock();
    //创建两个条件变量，一个是缓冲区非满，一个是缓冲区非空
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        CustomerTest2 test2 = new CustomerTest2();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();
        new Thread(test2.new Producer()).start();
        new Thread(test2.new Consumer()).start();

    }

    class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //获得锁
                lock.lock();
                try {
                    while (count == FULL) {
                        try {
                            notFull.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    //唤醒消费者
                    notEmpty.signal();
                } finally {
                    //释放锁
                    lock.unlock();
                }

            }
        }
    }

    class Consumer implements Runnable{
        public void run(){
            for(int i = 0; i < 10; i++){
                try{
                    Thread.sleep(3000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                //获取锁对象
                lock.lock();
                try{
                    while(count == 0){
                        try {
                            notEmpty.await();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前共有" + count);
                }finally{
                    lock.unlock();
                }
            }
        }
    }

}
