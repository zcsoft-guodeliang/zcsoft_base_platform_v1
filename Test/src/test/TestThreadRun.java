package test;

public class TestThreadRun {
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest("t1");
		synchronized (t1) {
			// 启动“线程1”
			System.out.println(Thread.currentThread().getName() + " start t1");
			t1.start();
			// 主线程等待t1通过notify() 唤醒
			System.out.println(Thread.currentThread().getName() + " wait");
			try {
				t1.wait();
				System.out.println(Thread.currentThread().getName()
						+ " continue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
