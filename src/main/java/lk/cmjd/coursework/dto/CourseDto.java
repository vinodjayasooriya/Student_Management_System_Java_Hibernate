package lk.cmjd.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto {
    private String CourseId;
    private String CourseName;
    private String CreditHours;
    private String department;
    private String prerequisites;
    private String MaximumCapacity;


}
