package lk.cmjd.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentregDto {
    private String rstudentid;
    private String rname;
    private String remail;
    private String rdepartment;
    private LocalDate rdob;
    private String ryear;
    private String rcontack;
    private String rnid;
    private String rhcontack;
    private String rschool;
    private String rol;
    private String ral;
    private String rprograme;
    private String raddress;

}
