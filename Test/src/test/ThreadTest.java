package test;

public class ThreadTest extends Thread{
	public ThreadTest(String name) {
		super(name);
	}

	public void run() {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " run");
			// 唤醒当前的wait线程
			notify();
		}
	}
}
