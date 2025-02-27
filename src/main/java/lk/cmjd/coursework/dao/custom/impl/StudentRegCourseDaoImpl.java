package lk.cmjd.coursework.dao.custom.impl;

import lk.cmjd.coursework.dao.custom.StudentregcourseDao;
import lk.cmjd.coursework.entity.StudentregEntity;
import lk.cmjd.coursework.entity.StudentregcourseEntity;
import lk.cmjd.coursework.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class StudentRegCourseDaoImpl implements StudentregcourseDao {
    @Override
    public String Save(StudentregcourseEntity studentregcourseEntity) throws Exception {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();  // Start Transaction

            session.save(studentregcourseEntity);  // Save entity

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
    public ArrayList<StudentregcourseEntity> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (ArrayList<StudentregcourseEntity>) session.createQuery("FROM StudentregcourseEntity ", StudentregcourseEntity.class).list();

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

            StudentregcourseEntity student = session.get(StudentregcourseEntity.class, id);
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
    public String Update(StudentregcourseEntity studentregcourseEntity) throws Exception {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();  // Start Transaction

            session.update(studentregcourseEntity);  // Save entity

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

