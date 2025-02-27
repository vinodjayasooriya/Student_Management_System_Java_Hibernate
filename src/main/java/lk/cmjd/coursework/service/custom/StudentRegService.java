package lk.cmjd.coursework.service.custom;

import lk.cmjd.coursework.dto.CourseDto;
import lk.cmjd.coursework.dto.StudentregDto;
import lk.cmjd.coursework.service.SuperService;

import java.util.ArrayList;

public interface StudentRegService extends SuperService {
    String save(StudentregDto studentregDto) throws Exception;
    String update(StudentregDto studentregDto) throws Exception;
    String delete(String id) throws Exception;
    StudentregDto search(String id) throws Exception;
    ArrayList<StudentregDto> getAll() throws Exception;
}
