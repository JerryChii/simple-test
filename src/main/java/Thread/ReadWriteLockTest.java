package Thread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
	public static void main(String[] args) {
		final Queue3 q3 = new Queue3();
		for(int i=0;i<3;i++)
		{
			final Thread readThread = new Thread() {
				public void run() {
					while (true) {
						q3.get();
					}
				}
			};
			readThread.setName("read-"+i);
			readThread.start();


			final Thread writeThread = new Thread(){
				public void run(){
					while(true){
						q3.put(new Random().nextInt(10000));
					}
				}			
				
			};
			writeThread.setName("write-"+i);
			writeThread.start();
		}
		
	}
}

class Queue3{
	private Object data = null;
	ReadWriteLock rwl = new ReentrantReadWriteLock();
	public void get(){
		rwl.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " be ready to read data!");
			Thread.sleep((long)(Math.random()*1000));
			System.out.println(Thread.currentThread().getName() + " have read data :" + data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			rwl.readLock().unlock();
		}
	}
	
	public void put(Object data){

		rwl.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + " be ready to write data!");					
			Thread.sleep((long)(Math.random()*1000));
			this.data = data;		
			System.out.println(Thread.currentThread().getName() + " have write data: " + data);					
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			rwl.writeLock().unlock();
		}
	}
}
