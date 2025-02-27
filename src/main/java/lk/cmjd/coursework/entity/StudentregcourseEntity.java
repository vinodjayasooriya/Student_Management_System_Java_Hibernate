package lk.cmjd.coursework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data


@Entity
@Table(name = "studentregcourse")

public class StudentregcourseEntity {
    @Id
    @Column(name = "rcstudentid")
    private String rcstudentid;

    @Column(name = "rccourseid1")
    private String rccourseid1;

    @Column(name = "rccourseid2")
    private String rccourseid2;

    @Column(name = "rccourseid3")
    private String rccourseid3;
}
