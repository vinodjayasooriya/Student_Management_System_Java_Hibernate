package lk.cmjd.coursework.service.custom.Impl;

import lk.cmjd.coursework.dao.custom.AcademicDao;
import lk.cmjd.coursework.dao.custom.DaoFactory;
import lk.cmjd.coursework.dao.custom.StudentRegDao;
import lk.cmjd.coursework.dto.AcademicDto;
import lk.cmjd.coursework.dto.StudentregDto;
import lk.cmjd.coursework.entity.AcademicEntity;
import lk.cmjd.coursework.entity.StudentregEntity;
import lk.cmjd.coursework.service.custom.StudentRegService;

import java.util.ArrayList;

public class StudentRegServiceImpl implements StudentRegService {
    private StudentRegDao studentregdao = (StudentRegDao)  DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.STUREG);


    @Override
    public String save(StudentregDto studentregDto) throws Exception {
        StudentregEntity studentregEntity = new StudentregEntity(
                studentregDto.getRstudentid(),
                studentregDto.getRname(),
                studentregDto.getRemail(),
                studentregDto.getRdepartment(),
                studentregDto.getRdob(),
                studentregDto.getRyear(),
                studentregDto.getRcontack(),
                studentregDto.getRnid(),
                studentregDto.getRhcontack(),
                studentregDto.getRschool(),
                studentregDto.getRol(),
                studentregDto.getRal(),
                studentregDto.getRprograme(),
                studentregDto.getRaddress()

        );
        return studentregdao.Save(studentregEntity);
    }

    @Override
    public String update(StudentregDto studentregDto) throws Exception {
        StudentregEntity studentregEntity = new StudentregEntity(
                studentregDto.getRstudentid(),
                studentregDto.getRname(),
                studentregDto.getRemail(),
                studentregDto.getRdepartment(),
                studentregDto.getRdob(),
                studentregDto.getRyear(),
                studentregDto.getRcontack(),
                studentregDto.getRnid(),
                studentregDto.getRhcontack(),
                studentregDto.getRschool(),
                studentregDto.getRol(),
                studentregDto.getRal(),
                studentregDto.getRprograme(),
                studentregDto.getRaddress()

        );
        return studentregdao.Update(studentregEntity);
    }

    @Override
    public String delete(String id) throws Exception {
        return studentregdao.delete(id);
    }

    @Override
    public StudentregDto search(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<StudentregDto> getAll() throws Exception {
        ArrayList<StudentregEntity> studentregEntities = studentregdao.getAll();
        ArrayList<StudentregDto> studentregs = new ArrayList<>();

        for(StudentregEntity studentreg : studentregEntities)
        {
            studentregs.add(new StudentregDto(studentreg.getRstudentid(),
                    studentreg.getRname(),
                    studentreg.getRemail(),
                    studentreg.getRdepartment(),
                    studentreg.getRdob(),
                    studentreg.getRyear(),
                    studentreg.getRcontack(),
                    studentreg.getRnid(),
                    studentreg.getRhcontack(),
                    studentreg.getRschool(),
                    studentreg.getRol(),
                    studentreg.getRal(),
                    studentreg.getRprograme(),
                    studentreg.getRaddress()));
        }

        return studentregs;
    }
}
