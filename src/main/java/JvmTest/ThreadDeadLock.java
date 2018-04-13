package JvmTest;

/**
 * Created by jialin5 on 2016/11/30.
 */
public class ThreadDeadLock {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock1) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("线程1执行....");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock2) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("线程2执行...");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
