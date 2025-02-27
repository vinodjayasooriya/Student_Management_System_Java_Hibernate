package lk.cmjd.coursework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AcademicDto {
    private String arstudentid;
    private String arstudentName;
    private String arstudentProgram;
    private String arstudentyear;
    private String arstudentgpa;
}
