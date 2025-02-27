package lk.cmjd.coursework.dao.custom;

import lk.cmjd.coursework.dao.SuperDao;
import lk.cmjd.coursework.entity.CourseEntity;

import java.util.ArrayList;

public interface CourseDao extends SuperDao {
    String Save(CourseEntity courseEntity) throws Exception;
    ArrayList<CourseEntity> getAll();

    String delete(String id);
    String Update(CourseEntity courseEntity) throws Exception;
}
