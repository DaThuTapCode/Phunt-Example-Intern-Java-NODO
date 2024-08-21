package week3.day2345example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import week2.day345example.util.EnumStatus;

/**
 * Created by Trong Phu on 20/08/2024 09:45:04
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "name_student")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EnumStatus status;

    @ManyToOne(
//            cascade = CascadeType.REMOVE, // nếu để như này khi xóa đối tượng này thì sẽ xóa luôn cả bảng ghi ở bảng cha, nếu bảng cha chứa nhiều hơn 1 đối tượng student thì sẽ báo lỗi xóa khóa ngoại
//            cascade = CascadeType.MERGE, // Nếu để như này khi update student, thuộc tính classes mà có id khác so với các lớp ở trong bảng classes thì sẽ thực hiện thêm 1 bản ghi mới vào bảng classes
//            cascade = CascadeType.DETACH //
//            cascade = CascadeType.PERSIST // 1 là không để id của classes 2 là không để cả thuộc tính classes thì mới thêm được
//            fetch = FetchType.LAZY,
//            optional = false,
//             targetEntity = Classes.class
    )
    @JsonBackReference
    @JoinColumn(name = "class_id")
    private Classes classes;
}
