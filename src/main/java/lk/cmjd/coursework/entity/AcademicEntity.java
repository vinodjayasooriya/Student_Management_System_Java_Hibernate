package lk.cmjd.coursework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


@Entity
@Table(name = "academic")

public class AcademicEntity {
    @Id
    @Column(name = "arstudentId")
    private String ArstudentId;

    @Column(name = "arstudentName")
    private String ArstudentName;

    @Column(name = "arstudentprograme")
    private String Arstudentprograme;

    @Column(name = "arstudentyear")
    private String Aryear;

    @Column(name = "arstudentgpa")
    private String Argpa;
}
