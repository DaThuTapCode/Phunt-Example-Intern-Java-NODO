package week1.weakend1example.customexceptionexample;

/**
 * Created by Trong Phu on 09/08/2024 13:48:47
 *
 * @author Trong Phu
 */
public class CustomExceptionExample {

    public static void main(String[] args) {
        CustomExceptionExample example = new CustomExceptionExample();

        // Ví dụ về Unchecked Exception
        try {
            example.performUncheckedOperation(false);
        } catch (MyUncheckedException e) {
            System.out.println("Caught an unchecked exception: " + e.getMessage());
        }

        // Ví dụ về Checked Exception
        try {
            example.performCheckedOperation(false);
        } catch (MyCheckedExeption e) {
            System.out.println("Caught a checked exception: " + e.getMessage());
        }
    }

    // Ví dụ về Unchecked Exception
    public void performUncheckedOperation(boolean flag) {
        if (!flag) {
            throw new MyUncheckedException("This is an unchecked exception.");
        }
        System.out.println("Unchecked operation performed successfully.");
    }

    // Ví dụ về Checked Exception
    public void performCheckedOperation(boolean flag) throws MyCheckedExeption {
        if (!flag) {
            throw new MyCheckedExeption("This is a checked exception.");
        }
        System.out.println("Checked operation performed successfully.");
    }

}

// Định nghĩa Custom Unchecked Exception
class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
    }
}

// Định nghĩa Custom Checked Exception
class MyCheckedExeption extends Exception {
    public MyCheckedExeption(String message) {
        super(message);
    }
}
