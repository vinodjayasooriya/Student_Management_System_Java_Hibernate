package lk.cmjd.coursework.dao.custom;

import lk.cmjd.coursework.dao.SuperDao;
import lk.cmjd.coursework.entity.StudentregEntity;
import lk.cmjd.coursework.entity.StudentregcourseEntity;

import java.util.ArrayList;

public interface StudentregcourseDao extends SuperDao {
    String Save(StudentregcourseEntity studentregcourseEntity) throws Exception;
    ArrayList<StudentregcourseEntity> getAll();

    String delete(String id);
    String Update(StudentregcourseEntity studentregcourseEntity) throws Exception;
}
