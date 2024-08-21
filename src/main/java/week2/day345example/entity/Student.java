package week2.day345example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week2.day345example.util.EnumStatus;

/**
 * Created by Trong Phu on 14/08/2024 10:46:14
 *
 * @author Trong Phu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "student_iden")
//@Table(name = "student_auto")
//@Table(name = "student_sequence")
@Table(
        name = "student"
        ,uniqueConstraints = @UniqueConstraint(columnNames = {"name_student"}) // chỉ định name là giá trị duy nhất
)
public class Student {
    /**
     * Chiến lược sinh với identity
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_seq")
//    @SequenceGenerator(name = "student_id_seq", sequenceName = "student_sequence_id_seq", allocationSize = 1)

//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "student_id_table")
//    @TableGenerator(
//            name = "student_id_table",
//            table = "id_generator",          // Tên bảng sinh ID
//            pkColumnName = "seq_name",       // Tên cột lưu tên chuỗi
//            valueColumnName = "seq_value",   // Tên cột lưu giá trị ID
//            pkColumnValue = "student_id_seq",// Giá trị của chuỗi cho đối tượng này
//            allocationSize = 1               // Bước nhảy
//    )

//    @GeneratedValue(strategy = GenerationType.AUTO)
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

}

