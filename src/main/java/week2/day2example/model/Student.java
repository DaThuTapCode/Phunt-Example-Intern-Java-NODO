package week2.day2example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import week2.day2example.enumexample.StatusStudent;

import java.util.Date;

/**
 * Created by Trong Phu on 13/08/2024 10:13:16
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(
        value = {"address"}, // Bỏ qua thuộc tính 'address' khi serialize/deserialize JSON
        ignoreUnknown = true // Bỏ qua các thuộc tính không xác định trong JSON
)
public class Student {

    @JsonProperty(
            value = "student_id", // Đổi tên thuộc tính 'id' thành 'student_id' trong JSON
            access = JsonProperty.Access.READ_WRITE, // Cho phép cả đọc và ghi (serialize/deserialize)
            required = true // Thuộc tính này là bắt buộc trong JSON
    )
    private Long id;

    @JsonProperty(
            value = "student_name", // Đổi tên thuộc tính 'name' thành 'student_name' trong JSON
            access = JsonProperty.Access.READ_WRITE // Cho phép cả đọc và ghi
    )
    private String name;

    @JsonFormat(
            pattern = "dd-MM-yyyy", // Định dạng ngày tháng theo kiểu 'dd-MM-yyyy'
            shape = JsonFormat.Shape.STRING, // Chuyển đổi thành chuỗi khi serialize
            timezone = "Asia/Ho_Chi_Minh", // Đặt múi giờ
//            timezone = "America/New_York", // Đặt múi giờ
            locale = "vi_VN" // Đặt ngôn ngữ địa phương
    )
    private Date dayOfBirth;

    @JsonProperty(
            access = JsonProperty.Access.WRITE_ONLY // Chỉ cho phép ghi (deserialize) thuộc tính 'address'
    )
    private String address;

    @JsonProperty(
            access = JsonProperty.Access.READ_ONLY // Chỉ cho phép đọc (serialize) thuộc tính 'age'
    )
    private int age;

    @JsonProperty(
            value = "student_status", // Đổi tên thuộc tính 'status' thành 'student_status' trong JSON
            access = JsonProperty.Access.READ_WRITE // Cho phép cả đọc và ghi
    )
    private StatusStudent status;

}
