package lk.cmjd.coursework.service.custom.Impl;

import lk.cmjd.coursework.dao.custom.DaoFactory;

import lk.cmjd.coursework.dao.custom.StudentregcourseDao;
import lk.cmjd.coursework.dto.StudentregDto;
import lk.cmjd.coursework.dto.StudentregcourseDto;

import lk.cmjd.coursework.entity.StudentregcourseEntity;
import lk.cmjd.coursework.service.custom.StudentRegCourseService;

import java.util.ArrayList;

public class StudentRegCourseServiceImpl implements StudentRegCourseService {
    private StudentregcourseDao studentregcourseDao = (StudentregcourseDao)  DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.STUCOURSEREG);



    @Override
    public String save(StudentregcourseDto studentregcourseDto) throws Exception {
        StudentregcourseEntity studentregcourseEntity = new StudentregcourseEntity(
                studentregcourseDto.getRcstudentid(),
                studentregcourseDto.getRccourseid1(),
                studentregcourseDto.getRccourseid2(),
                studentregcourseDto.getRccourseid3()

        );
        return studentregcourseDao.Save(studentregcourseEntity) ;
    }

    @Override
    public String update(StudentregcourseDto studentregcourseDto) throws Exception {
        StudentregcourseEntity studentregcourseEntity = new StudentregcourseEntity(
                studentregcourseDto.getRcstudentid(),
                studentregcourseDto.getRccourseid1(),
                studentregcourseDto.getRccourseid2(),
                studentregcourseDto.getRccourseid3()

        );
        return studentregcourseDao.Update(studentregcourseEntity) ;
    }

    @Override
    public String delete(String id) throws Exception {
        return studentregcourseDao.delete(id);
    }

    @Override
    public StudentregDto search(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<StudentregcourseDto> getAll() throws Exception {
        ArrayList<StudentregcourseEntity> studentregcourseEntities = studentregcourseDao.getAll();
        ArrayList<StudentregcourseDto> studentregEntities = new ArrayList<>();

        for(StudentregcourseEntity studentregcourse : studentregcourseEntities)
        {
            studentregEntities.add(new StudentregcourseDto(studentregcourse.getRcstudentid(),
                    studentregcourse.getRccourseid1(),
                    studentregcourse.getRccourseid2(),
                    studentregcourse.getRccourseid3()));

        }
        return studentregEntities;
    }
}
