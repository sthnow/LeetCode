package designMode.producerandconsumer;


/**
 * 重新编写生产者-消费者模型，使用wait()和notify()方法实现
 */
public class CustomerTest1 {
    //先定义变量
    //两个静态变量用于统计数据
    private static Integer count = 0;
    private static final Integer FULL = 10;
    //一个静态常量用于执行同步。
    //对静态变量，静态常量的同步，都相当于对类加锁。因为不同的线程在操作这些静态量的时候，因为一个类的静态量只初始化一次，只有一份，
    // 因此操作的对象只有一个，相当于是对类加锁
    private static String LOCK = "lock";

    public static void main(String[] args) {
        //创建customerTest对象
        CustomerTest1 test1 = new CustomerTest1();
        //创建多个线程运行
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Customer()).start();
        new Thread(test1.new Producer()).start();
//        new Thread(test1.new Customer()).start();
//        new Thread(test1.new Producer()).start();
//        new Thread(test1.new Customer()).start();
//        new Thread(test1.new Producer()).start();
//        new Thread(test1.new Customer()).start();
//        new Thread(test1.new Producer()).start();
//        new Thread(test1.new Customer()).start();
    }


    /**
     * 生产者类
     * 创建线程的方式，
     *      继承Thread类，重写run方法
     *      实现Runnable接口，重写run方法
     */
    class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    //让线程睡眠从而进入阻塞状态，睡眠的目的是为了实现让多个线程交叉执行的目的
                    //执行该方法需要处理异常
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //对静态变量进行同步，相当于就是对类加锁
                synchronized (LOCK) {
                    //如果生产已满，该生产线程进入wait状态
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                    //如果生产不满，则继续生产
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    //唤醒所有的线程
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Customer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前共有" + count);
                    LOCK.notifyAll();
                }

            }
        }
    }

}