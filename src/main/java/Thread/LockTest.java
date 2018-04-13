package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	public static void main(String[] args) {
		new LockTest().init();
	}
	
	private void init(){
		final Outputer outputer = new Outputer();
		Thread thread1 = new Thread(new Runnable(){
			public void run() {
				String name = "zhangxiaoxiang";
				try {
					Thread.sleep(10);
					outputer.output(name);
				} catch (InterruptedException e) {
					System.out.println(name + "被中断");
				}


			}
		});
		thread1.start();

		Thread thread2 = new Thread(new Runnable(){
			public void run() {
				String name = "lihuoming";
				try {
					Thread.sleep(10);
					outputer.output(name);
				} catch (InterruptedException e) {
					System.out.println(name + "被中断");
				}

			}
		});
		thread2.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.interrupt();
		
	}

	static class Outputer{
		Lock lock = new ReentrantLock();
		//将InterruptedException抛出
		public void output(String name) throws InterruptedException {
			System.out.println(name + "试图执行output方法");
			lock.lockInterruptibly();
			try{
				System.out.println(name + "得到锁");
				long startTime = System.currentTimeMillis();
				for(    ;     ;) {
					if(System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
						break;
				}
			}finally{
				System.out.println(name + "执行了finally");
				lock.unlock();
				System.out.println(name + "释放锁");

			}
		}
	}
}
