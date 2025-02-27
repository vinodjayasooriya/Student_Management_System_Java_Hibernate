package lk.cmjd.coursework.service.custom.Impl;

import lk.cmjd.coursework.dao.custom.DaoFactory;
import lk.cmjd.coursework.dao.custom.RoleDao;
import lk.cmjd.coursework.dao.custom.StudentDao;
import lk.cmjd.coursework.dao.custom.UserDao;
import lk.cmjd.coursework.dto.StudentDto;
import lk.cmjd.coursework.entity.StudentEntity;
import lk.cmjd.coursework.entity.UserEntity;
import lk.cmjd.coursework.service.custom.StudentService;
import lk.cmjd.coursework.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class StudentserviceImpl implements StudentService {
    private UserDao userDao = (UserDao)  DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.USER);
    private RoleDao roleDao = (RoleDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ROLE);

    private StudentDao studentDao = (StudentDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.STUDENT);

    @Override
    public String save(StudentDto studentDto) throws Exception {

        String role = "Student";
        var roleEntity = roleDao.search(role);
        System.out.println(roleEntity.getId());
        int userId = userDao.Save(new UserEntity(studentDto.getStudentName(),
                studentDto.getEmail(),
                studentDto.getPassword(),
                roleEntity));
        var User = userDao.Search(String.valueOf(userId));
        System.out.println(userId);

        String output =studentDao.Save(new StudentEntity(studentDto.getStudentId(),studentDto.getStudentName(),studentDto.getEmail(),studentDto.getDob(),studentDto.getProgram(),studentDto.getYear(),studentDto.getContactNumber(),User));


        return output;
    }

    @Override
    public ArrayList<StudentDto> getAll() throws Exception {
        ArrayList<StudentEntity> studentEntities = studentDao.getAll();
        ArrayList<StudentDto> students = new ArrayList<>();

        for(StudentEntity student : studentEntities)
        {
            students.add(new StudentDto(student.getStudentId(),student.getStudentName(),student.getProgram(),student.getStudentemail(),student.getStudentDob(),student.getYear(),student.getContactNumber()));
        }

        return students;
    }

    @Override
    public String update(StudentDto studentDto) throws Exception {
//        var StudentEntity = studentDao.getStudent(studentDto.getStudentId());
//        String Useroutput = userDao.Update(new UserEntity(StudentEntity.getUser().getUserId(),studentDto.getStudentName(),studentDto.getEmail(),StudentEntity.getUser().getPassword(),StudentEntity.getUser().getRole()));
//        String studentOutPut = studentDao.Update(new StudentEntity(studentDto.getStudentId(),studentDto.getStudentName(),studentDto.getEmail(),studentDto.getDob(),studentDto.getProgram(),studentDto.getYear(),studentDto.getContactNumber(),StudentEntity.getUser()));
//        System.out.println(StudentEntity.getUser().toString());
//        return "ok";

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Fetch the student using the current session
            StudentEntity studentEntity = studentDao.getStudent(studentDto.getStudentId(), session);
            if (studentEntity == null) {
                throw new Exception("Student not found");
            }


            userDao.Update(new UserEntity(studentEntity.getUser().getUserId(),studentDto.getStudentName(),studentDto.getEmail(),studentEntity.getUser().getPassword(),studentEntity.getUser().getRole()), session); // Assume update uses session.merge() or similar

            // Update StudentEntity (modify the managed entity)

            studentDao.Update(new StudentEntity(studentDto.getStudentId(),studentDto.getStudentName(),studentDto.getEmail(),studentDto.getDob(),studentDto.getProgram(),studentDto.getYear(),studentDto.getContactNumber(),studentEntity.getUser()), session);

            transaction.commit();
            return "ok";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e; // Or return "error" based on your error handling
        } finally {
            session.close();
        }
    }

    @Override
    public String delete(String id) throws Exception {
        return studentDao.delete(id);
    }


}
