package lk.cmjd.coursework.dao.custom;

import lk.cmjd.coursework.dao.SuperDao;
import lk.cmjd.coursework.entity.AcademicEntity;
import lk.cmjd.coursework.entity.CourseEntity;

import java.util.ArrayList;

public interface AcademicDao extends SuperDao {
    String Save(AcademicEntity academicEntity) throws Exception;
    ArrayList<AcademicEntity> getAll();

    String delete(String id);
    String Update(AcademicEntity academicEntity) throws Exception;
}
