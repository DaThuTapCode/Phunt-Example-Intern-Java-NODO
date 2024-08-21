package week3.day2345example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Created by Trong Phu on 20/08/2024 09:45:13
 *
 * @author Trong Phu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classes_id")
    private Long id;

    private String classesName;

    /*
      *   Sử dụng @JsonIgnore hoặc @JsonBackReference và @JsonManagedReference trong các mối quan hệ đệ quy
      * - Cần ngăn việc Jackson cố gắng tuần hoàn giữa các dối tượng liên kết qua các quan hệ @ManyToOne và @OneToMany
      *
      * - Sử dụng @JsonIgnore: Để ngăn một thuộc tính cụ thể không bị serialize thành JSON.
        - Sử dụng @JsonBackReference và @JsonManagedReference: Để quản lý mối quan hệ tuần hoàn giữa hai đối tượng.
        *
        *  @JsonBackReference: Được sử dụng ở phía ngược lại của mối quan hệ, tức là phía con `Trong trường hợp này là Student. Nó ngăn vòng lặp tuần hoàn khi serialize JSON`
        *  @JsonManagedReference: Được sử dụng ở phía quản lý mối quan hệ, tức là phía cha `Trong trường hợp này là Classes`. Jackson sec bắt đầu serialization từ đây
       * */
    @OneToMany(
            cascade = {
//      CascadeType.ALL, // Thực hiện tất cả các hành động cascade bao gồm PERSIST, MERGE, REMOVE, DETACH, REFRESH.
//      CascadeType.DETACH, // Khi detach một đối tượng Classes khỏi entityManager, tất cả các Student liên quan cũng sẽ bị detach.
//      CascadeType.MERGE, // Khi cập nhật một đối tượng Classes, các Student liên quan cũng sẽ được cập nhật nếu có sự thay đổi.
                    CascadeType.PERSIST, // Khi thêm một đối tượng Classes mới, nếu đối tượng này không có ID, thì cả bảng cha (Classes) và bảng con (Student) đều sẽ được thêm mới vào cơ sở dữ liệu.
//      CascadeType.REMOVE, // Khi xóa một đối tượng Classes, tất cả các đối tượng Student liên quan sẽ bị xóa theo.
//      CascadeType.REFRESH // Cập nhật lại trạng thái của đối tượng Classes từ cơ sở dữ liệu, đồng thời các Student liên quan cũng sẽ được cập nhật lại.
            },
            fetch = FetchType.LAZY, // Dữ liệu của Student sẽ được tải chậm, chỉ khi được yêu cầu.
//  fetch = FetchType.EAGER, // Tải dữ liệu của Student ngay lập tức cùng với Classes, không khuyến khích dùng cho quan hệ OneToMany.
//  orphanRemoval = true, // Nếu một đối tượng Student không còn được liên kết với bất kỳ Classes nào, đối tượng đó sẽ bị xóa khỏi cơ sở dữ liệu.
            mappedBy = "classes" // Khai báo rằng mối quan hệ này được quản lý bởi thuộc tính 'classes' ở bên Student.
    )
    @ToString.Exclude // Tránh vòng lặp đệ quy trong phương thức toString do quan hệ hai chiều giữa Classes và Student.
    @JsonManagedReference // Quản lý tuần tự hóa JSON để tránh vòng lặp khi sử dụng Jackson trong quan hệ hai chiều.
    private List<Student> students;

}
