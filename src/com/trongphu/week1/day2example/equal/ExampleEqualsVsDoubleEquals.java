package com.trongphu.week1.day2example.equal;

import java.util.Objects;

/**
 * Created by Trong Phu on 07/08/2024 10:34:53
 *
 * @author Trong Phu
 */

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class ExampleEqualsVsDoubleEquals {

    /**
     * Trong java `equals` và `==` đều được dùng để so sánh các giá trị, nhưng chúng có các cách hoạt động và mục đích
     * khác nhau.
     *
     *  - (== Toán tử so sánh)
     *  Dùng để so sánh từ địa chỉ bộ nhớ: Toán tử `==` so sánh xem hai biến có tham chiếu đến cùng một đối tượng trong bộ nhớ hay không
     *
     *  Áp dụng cho các kiểu dữ liệu nguyên thủy: Khi so sánh các kiểu dữ liệu nguyên thủy (int, float, char, v.v.) so sánh các giá trị thực tế của chúng;
     *
     *  - `equals` (Phương thức so sánh)
     *  - Đùng dể so sánh giá trị nội dùng của đối tượng: Phương thức `equals` được sử dụng để so sánh xem 2 đối tượng có cùng
     *  giá trị nội dung hay không.
     *  - Phải được ghi đè (Override):  Để có thể so sánh đúng giá trị nội dung, phương thức `equals` phải được ghi đè trong lớp của đối tượng
     *  */
    public static void main(String[] args) {
        // ==
        int a = 10;
        int b = 10;
        Integer c = new Integer(10);
        Integer d = new Integer(10);

        // So sánh các giá trị nguyên thủy
        System.out.println(a == b); // true, vì giá trị của a và b đều là 10

        // So sánh các đối tượng
        System.out.println(c == d); // false, vì c và d là hai đối tượng khác nhau trong bộ nhớ

        // So sánh các đối tượng với equals
        System.out.println(c.equals(d)); // true, vì giá trị nội dung của c và d đều là 10

        /////////
        //equals
        Person person1 = new Person("Phú");
        Person person2 = new Person("Phú");
        Person person3 = new Person("Vân");

        // So sánh địa chỉ bộ nhớ
        System.out.println(person1 == person2); // false, vì person1 và person2 là hai đối tượng khác nhau trong bộ nhớ

        // So sánh giá trị nội dung
        System.out.println(person1.equals(person2)); // true, vì giá trị nội dung của person1 và person2 đều là "John"
        System.out.println(person1.equals(person3)); // false, vì giá trị nội dung của person1 và person3 khác nhau
    }
}
