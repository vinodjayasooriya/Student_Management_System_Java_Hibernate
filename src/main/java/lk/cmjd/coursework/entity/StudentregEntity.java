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
@Table(name = "regstudent")

public class StudentregEntity {
    @Id
    @Column(name = "rstudentid")
    private String rstudentid;

    @Column(name = "rname")
    private String rname;

    @Column(name = "remail")
    private String remail;

    @Column(name = "rdepartment")
    private String rdepartment;

    @Column(name = "rdob")
    private LocalDate rdob;

    @Column(name = "ryear")
    private String ryear;

    @Column(name = "rcontack")
    private String rcontack;

    @Column(name = "rnid")
    private String rnid;

    @Column(name = "rhcontack")
    private String rhcontack;

    @Column(name = "rschool")
    private String rschool;

    @Column(name = "rol")
    private String rol;

    @Column(name = "ral")
    private String ral;

    @Column(name = "rprograme")
    private String rprograme;

    @Column(name = "raddress")
    private String raddress;
}
