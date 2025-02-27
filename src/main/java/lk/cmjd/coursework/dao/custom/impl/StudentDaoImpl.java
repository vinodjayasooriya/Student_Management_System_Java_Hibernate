package lk.cmjd.coursework.dao.custom.impl;

import lk.cmjd.coursework.dao.custom.StudentDao;
import lk.cmjd.coursework.entity.CourseEntity;
import lk.cmjd.coursework.entity.StudentEntity;
import lk.cmjd.coursework.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {
    @Override
    public String Save(StudentEntity student) throws Exception {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();  // Start Transaction

            session.save(student);  // Save entity

            transaction.commit();  // Commit Transaction
            return "ok";

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // Rollback only if active
            }
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public ArrayList<StudentEntity> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (ArrayList<StudentEntity>) session.createQuery("FROM StudentEntity ", StudentEntity.class).list();

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());


            return null;
        }
    }

    @Override
    public String Update(StudentEntity student,Session session) throws Exception {
        try {
            StudentEntity managedStudent = session.merge(student);
            session.update(managedStudent);
            return "ok";
        } catch (Exception e) {
            throw new RuntimeException("Student update failed", e);
        }
    }

    @Override
    public StudentEntity getStudent(String id,Session session) {
        return session.get(StudentEntity.class, id);
    }

    @Override
    public String delete(String id) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();  // Start Transaction

            StudentEntity student = session.get(StudentEntity.class, id);
            if (student != null) {
                session.delete(student);
                transaction.commit();
                System.out.println("student deleted successfully");
            }

            return "ok";

        }
        catch (Exception e) {
            System.out.println("Error:"+e.getMessage());


            return null;
        }
    }
}
