package week3.day2345example.dto.classes.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Trong Phu on 21/08/2024 08:48:19
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassesResponseDTO {
    private Long id;

    private String classesName;
}
