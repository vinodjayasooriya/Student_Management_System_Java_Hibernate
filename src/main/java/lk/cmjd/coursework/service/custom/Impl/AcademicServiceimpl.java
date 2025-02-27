package lk.cmjd.coursework.service.custom.Impl;

import lk.cmjd.coursework.dao.custom.AcademicDao;
import lk.cmjd.coursework.dao.custom.CourseDao;
import lk.cmjd.coursework.dao.custom.DaoFactory;
import lk.cmjd.coursework.dto.AcademicDto;
import lk.cmjd.coursework.dto.CourseDto;
import lk.cmjd.coursework.dto.StudentDto;
import lk.cmjd.coursework.entity.AcademicEntity;
import lk.cmjd.coursework.entity.CourseEntity;
import lk.cmjd.coursework.entity.StudentEntity;
import lk.cmjd.coursework.entity.UserEntity;
import lk.cmjd.coursework.service.custom.AcademicService;

import java.util.ArrayList;

import static lk.cmjd.coursework.dao.custom.DaoFactory.DaoTypes.ACADEMIC;


public class AcademicServiceimpl implements AcademicService {
    private AcademicDao academicDao = (AcademicDao)  DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ACADEMIC);


    @Override
    public String save(AcademicDto academicDto) throws Exception {
        AcademicEntity academicEntity = new AcademicEntity(
                academicDto.getArstudentid(),
                academicDto.getArstudentName(),
                academicDto.getArstudentProgram(),
                academicDto.getArstudentyear(),
                academicDto.getArstudentgpa()


        );
        return academicDao.Save(academicEntity);
    }



    @Override
    public String update(AcademicDto academicDto) throws Exception {

        AcademicEntity academicEntity = new AcademicEntity(
                academicDto.getArstudentid(),
                academicDto.getArstudentName(),
                academicDto.getArstudentProgram(),
                academicDto.getArstudentyear(),
                academicDto.getArstudentgpa()


        );
        return academicDao.Update(academicEntity);
    }

    @Override
    public String delete(String id) throws Exception {
        return academicDao.delete(id);
    }

    @Override
    public ArrayList<AcademicDto> getAll() throws Exception {

        ArrayList<AcademicEntity> academicEntities = academicDao.getAll();
        ArrayList<AcademicDto> academics = new ArrayList<>();

        for(AcademicEntity academic : academicEntities)
        {
            academics.add(new AcademicDto(academic.getArstudentId(),
                    academic.getArstudentName(),
                    academic.getArstudentprograme(),
                    academic.getAryear(),
                    academic.getArgpa()));
        }

        return academics;



        }



}
