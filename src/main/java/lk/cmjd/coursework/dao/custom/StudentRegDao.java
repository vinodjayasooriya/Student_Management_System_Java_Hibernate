package lk.cmjd.coursework.dao.custom;

import lk.cmjd.coursework.dao.SuperDao;
import lk.cmjd.coursework.entity.CourseEntity;
import lk.cmjd.coursework.entity.StudentregEntity;

import java.util.ArrayList;

public interface StudentRegDao extends SuperDao {
    String Save(StudentregEntity studentregEntity) throws Exception;
    ArrayList<StudentregEntity> getAll();

    String delete(String id);
    String Update(StudentregEntity studentregEntity) throws Exception;

}
