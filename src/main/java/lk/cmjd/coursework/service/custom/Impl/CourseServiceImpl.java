package lk.cmjd.coursework.service.custom.Impl;

import java.util.ArrayList;

import lk.cmjd.coursework.dao.custom.CourseDao;
import lk.cmjd.coursework.dao.custom.DaoFactory;
import lk.cmjd.coursework.dto.CourseDto;
import lk.cmjd.coursework.entity.CourseEntity;
import lk.cmjd.coursework.service.custom.CourseService;


public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = (CourseDao)  DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.COURSE);

    @Override
    public String save(CourseDto courseDto) throws Exception {

        CourseEntity courseEntity = new CourseEntity(
                courseDto.getCourseId(),
                courseDto.getCourseName(),
                courseDto.getCreditHours(),
                courseDto.getDepartment(),
                courseDto.getPrerequisites(),
                courseDto.getMaximumCapacity());
        return courseDao.Save(courseEntity);
    }

    @Override
    public String update(CourseDto courseDto) throws Exception {

        CourseEntity courseEntity = new CourseEntity(
                courseDto.getCourseId(),
                courseDto.getCourseName(),
                courseDto.getCreditHours(),
                courseDto.getDepartment(),
                courseDto.getPrerequisites(),
                courseDto.getMaximumCapacity());
        return courseDao.Update(courseEntity);
    }

    @Override
    public String delete(String id) throws Exception {
         return courseDao.delete(id);
    }

    @Override
    public CourseDto search(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public ArrayList<CourseDto> getAll() throws Exception {
        ArrayList<CourseDto> courses = new ArrayList<>();
        var courseEntities = courseDao.getAll();
        for(CourseEntity courseEntity : courseEntities){
            courses.add(new CourseDto(courseEntity.getCourseId(),
                    courseEntity.getCourseName(),
                    courseEntity.getCreditHours(),
                    courseEntity.getDepartment(),
                    courseEntity.getPrerequisites(),
                    courseEntity.getMaximumCapacity()));
        }
       return courses;
    }

   
    
}
