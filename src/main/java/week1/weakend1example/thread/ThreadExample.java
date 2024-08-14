package week1.weakend1example.thread;

/**
 * Created by Trong Phu on 11/08/2024 19:14:50
 *
 * @author Trong Phu
 */
public class ThreadExample {
    /**
     * `Thread` trong Java là một đơn vị xử lý độc lập bên trong 1 chương trình.
     * Một chương trình Java có thể chạy nhiều luồng (threads) song song để thực
     * hiện nhiều nhiệm vụ đồng thời, như đọc dữ liệu từ 1 file khi vẫn chờ phản hồi
     * từ người dùng.*/
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start(); // Bắt đầu luồng


        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();  // Bắt đầu luồng

    }

}

//Cách tạo Thread
// Có 2 cách để tạo Thread trong Java

//1. Kế thừa từ lớp Thread;
// Tạo 1 lớp mới kế thừa từ Thread và override phương thức run() để định nghĩa lại  công việc mà luồng sẽ thực hiện
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread đang chạy");
    }
}

//2. Triển khai Runable interface
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running: " + i);
            try {
                // Tạm dừng thread trong 1 giây
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " has finished running.");
    }
}

 class Main {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();  // Bắt đầu thread đầu tiên
        thread2.start();  // Bắt đầu thread thứ hai
    }
}



/*
* Các phương thức chính của Thread:
start(): Bắt đầu thực thi một luồng, gọi phương thức run().
run(): Chứa logic mà luồng sẽ thực hiện. Bạn không gọi trực tiếp phương thức này mà gọi start().
sleep(long millis): Tạm dừng luồng trong một khoảng thời gian xác định (tính bằng mili giây).
join(): Đợi cho đến khi luồng kết thúc.
interrupt(): Đưa ra tín hiệu để ngắt luồng.
isAlive(): Kiểm tra xem luồng có đang hoạt động hay không.
getName() / setName(String name): Lấy/tạo tên của luồng.
getPriority() / setPriority(int priority): Lấy/đặt mức độ ưu tiên của luồng.
* */


/*
* Thread Synchronization (Đồng bộ hóa luồng):
Khi nhiều luồng truy cập vào cùng một tài nguyên dùng chung, điều quan trọng là phải đảm bảo rằng tài nguyên đó không bị truy cập đồng thời bởi nhiều luồng cùng một lúc, điều này có thể gây ra các vấn đề như tình trạng đọc/ghi không nhất quán.
Java cung cấp từ khóa synchronized để đồng bộ hóa các phương thức hoặc các khối mã, đảm bảo rằng chỉ một luồng có thể truy cập vào tài nguyên tại một thời điểm.
Ví dụ về synchronized block:

*/
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

 class Mainc {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());  // Kết quả mong muốn là 2000
    }
}
