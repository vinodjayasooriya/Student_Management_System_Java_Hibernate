package lk.cmjd.coursework.service.custom;

import lk.cmjd.coursework.dto.StudentregDto;
import lk.cmjd.coursework.dto.StudentregcourseDto;
import lk.cmjd.coursework.service.SuperService;

import java.util.ArrayList;

public interface StudentRegCourseService extends SuperService {
    String save(StudentregcourseDto studentregcourseDto)throws Exception;

    String update(StudentregcourseDto studentregcourseDto)throws Exception;

    String delete(String id) throws Exception;
    StudentregDto search(String id) throws Exception;
    ArrayList<StudentregcourseDto> getAll() throws Exception;
}

