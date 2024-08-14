package week1.weakend1example.thread;

/**
 * Created by Trong Phu on 12/08/2024 16:18:44
 *
 * @author Trong Phu
 */
public class ThreadSyn implements Runnable {
    int a = 1000;


    @Override
    public synchronized void run() { // đồng bộ hóa truy cập vào tài nguyên chung giữa các luồng        a = a - 1000;        try {
        try {
            a = a - 1000;
            Thread.sleep(1000);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
        if (a < 0) {
            System.out.println("nhỏ hơn 0");
        } else {
            System.out.println("ok");
        }

    }


    public static void main(String[] args) {
        ThreadSyn threadSynchronization = new ThreadSyn();
        Thread t1 = new Thread(threadSynchronization);
        Thread t2 = new Thread(threadSynchronization);
        t1.start();
        t2.start();
    }
}

