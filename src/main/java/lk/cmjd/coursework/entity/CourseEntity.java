package lk.cmjd.coursework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;


@AllArgsConstructor
@NoArgsConstructor
@Data


@Entity
@Table(name = "courses")
public class CourseEntity {
    @Id
    @Column(name = "CourseId")
    private String courseId;

    @Column(name = "CourseName")
    private String courseName;

    @Column(name = "CreditHours")
    private String creditHours;


    @Column(name = "department")
    private String department;

    @Column(name = "prerequisites")
    private String prerequisites;

    @Column(name = "MaximumCapacity")
    private String maximumCapacity;


}
