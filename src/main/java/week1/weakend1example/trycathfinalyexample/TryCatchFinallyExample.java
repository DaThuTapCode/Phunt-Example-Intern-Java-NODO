package week1.weakend1example.trycathfinalyexample;

/**
 * Created by Trong Phu on 11/08/2024 18:33:54
 *
 * @author Trong Phu
 */
public class TryCatchFinallyExample {

    public static void main(String[] args) {
        /**
         * Try được sử dụng để bao quanh 1 đoạn mã có khả năng gây ra ngoại lệ.
         * Khi 1 ngoại lệ xảy ra trong khối try, nó sẽ được ném để xử lý trong khối catch*/
        //Cú pháp
        try {
            //Code có thể gây ra ngoại lệ
        } catch (Exception e) {

        }
        /**
         * Catch
         * đươc sử dụng để bắt và xử lý ngoại lệ xảy ra trong khối try.
         * Có thể xác định 1 hoặc nhiều khối catch để xử lý các loại ngoại lệ
         * khác nhau*/

        //Cú pháp
        try {

        } catch (Exception e) {

        }
        //Có thể có nhiều khối catch trong khối xử lý ngoại lệ

        //Ví dụ
        try {
            int rs = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Lỗi chia cho 0: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Có lỗi: " + e.getMessage());
        }

        /**
         *Finally
         * Sử dụng để thực hiện các thao tác cuối cùng, bất kể ngoại lệ có xảy ra hay không
         * Thường được sử dụng để đóng tài nguyên như file, kết nối csdl....*/

        //Cú pháp

        finally {
            //Code được thực hiện sau cùng luôn chạy
        }


        // Try lồng nhau
        // Try lồng nhau được sử dụng khi một khối try catch bên trong 1 khối
        //try catch khác. Điều này hữu ích khi xử lý các ngoại lệ riêng lẻ ở các cấp
        // độ khác nhau

        //Ví dụ

        try {
            try {
                int rs = 10 / 0;

            } catch (ArithmeticException e) {
                System.out.println("Catch bên trong: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Catch bên ngoài: " + e.getMessage());
        }

    }
}