package lk.cmjd.coursework.dao.custom.impl;

import lk.cmjd.coursework.dao.custom.AcademicDao;
import lk.cmjd.coursework.entity.AcademicEntity;
import lk.cmjd.coursework.entity.CourseEntity;
import lk.cmjd.coursework.entity.StudentEntity;
import lk.cmjd.coursework.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class AcademicDaoImpl implements AcademicDao {
    @Override
    public String Save(AcademicEntity academicEntity) throws Exception {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();  // Start Transaction

            session.save(academicEntity);  // Save entity

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
    public ArrayList<AcademicEntity> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (ArrayList<AcademicEntity>) session.createQuery("FROM AcademicEntity ", AcademicEntity.class).list();

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

            AcademicEntity academic = session.get(AcademicEntity.class, id);
            if (academic != null) {
                session.delete(academic);
                transaction.commit();
                System.out.println("academic deleted successfully");
            }

            return "ok";

        }
        catch (Exception e) {
            System.out.println("Error:"+e.getMessage());


            return null;
        }
    }

    @Override
    public String Update(AcademicEntity academicEntity) throws Exception {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();  // Start Transaction

            session.update(academicEntity);  // Save entity

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
