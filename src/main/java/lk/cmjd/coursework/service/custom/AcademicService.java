package lk.cmjd.coursework.service.custom;

import lk.cmjd.coursework.dto.AcademicDto;
import lk.cmjd.coursework.dto.StudentDto;
import lk.cmjd.coursework.service.SuperService;

import java.util.ArrayList;

public interface AcademicService extends SuperService {
    String save(AcademicDto academicDto) throws Exception;

    ArrayList<AcademicDto> getAll() throws Exception;

    String update(AcademicDto academicDto) throws Exception;

    String delete(String id) throws Exception;

}
