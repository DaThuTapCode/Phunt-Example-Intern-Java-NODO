package week1.weakend1example.readiofileexample;

import java.io.*;

/**
 * Created by Trong Phu on 11/08/2024 18:56:02
 *
 * @author Trong Phu
 */
public class ReadAndWriteFileExample {
    /**Đọc và ghi file trong java
     * 1. Luồng byte và luồng ký tự
     * - Luồng byte (Byte Stream): Được sử dụng để đọc và ghi dữ liệu dưới dạng
     * byte (8-bit), thường dùng cho dữ liệu nhị phân như hình ảnh âm thanh.
     *
     * - Luồng ký tự (Character Stream): Được sử dụng để đọc và ghi dữ liệu dưới
     * dạng ký tự (16-bit Unicode), thường được sử dụng cho dữ liệu văn bản.
     *
     * */

}


//Ghi dữ liệu vào file sử dụng FileWriter à BufferedWriter

 class FileWriteExample {

    public static void main(String[] args) {
        String filePath = "example.txt";
        String content = "Hello, World!\nWelcome to Java File IO.\nNguyễn Trọng Phú";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}


// FileInputStream
// Sử dụng để đọc dữ liệu file dưới dạng byte
class FileInputStreamExample{
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("input.txt");
        int data;
        while ((data = fis.read()) != -1) {
            System.out.print((char) data);
        }
        fis.close();

    }
}


 class FileReadExample {
    public static void main(String[] args) {
        String filePath = "example.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
