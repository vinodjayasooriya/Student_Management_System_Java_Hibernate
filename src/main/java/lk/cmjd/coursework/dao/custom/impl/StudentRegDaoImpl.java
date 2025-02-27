package lk.cmjd.coursework.dao.custom.impl;

import lk.cmjd.coursework.dao.custom.StudentRegDao;
import lk.cmjd.coursework.dto.AcademicDto;
import lk.cmjd.coursework.entity.AcademicEntity;
import lk.cmjd.coursework.entity.CourseEntity;
import lk.cmjd.coursework.entity.StudentregEntity;
import lk.cmjd.coursework.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class StudentRegDaoImpl implements StudentRegDao {

    @Override
    public String Save(StudentregEntity studentregEntity) throws Exception {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();  // Start Transaction

            session.save(studentregEntity);  // Save entity

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
    public ArrayList<StudentregEntity> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (ArrayList<StudentregEntity>) session.createQuery("FROM StudentregEntity ", StudentregEntity.class).list();

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());


            return null;
        }
    }

    @Override
    public String delete(String id) {

        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();  // Start Transaction

            StudentregEntity student = session.get(StudentregEntity.class, id);
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

    @Override
    public String Update(StudentregEntity studentregEntity) throws Exception {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();  // Start Transaction

            session.update(studentregEntity);  // Save entity

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
    }

