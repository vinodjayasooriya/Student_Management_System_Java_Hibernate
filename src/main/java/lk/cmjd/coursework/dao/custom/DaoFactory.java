package lk.cmjd.coursework.dao.custom;

import lk.cmjd.coursework.dao.SuperDao;
import lk.cmjd.coursework.dao.custom.impl.*;


public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoTypes type){
        switch (type) {
            case ITEM:
                return null;
            case ROLE:
                return new RoleDaoImpl();
            case OLRDER_DETAIL:
                return null;
            case COURSE:
                return new CourseDaoImpl();

            case USER:
                return new UserDaoImpl();
            case STUDENT:
                return new StudentDaoImpl();
            case ACADEMIC:
                return new AcademicDaoImpl();

            case STUREG:
                return new StudentRegDaoImpl();

            case STUCOURSEREG:
                return new StudentRegCourseDaoImpl();

            default:
                throw new AssertionError();
        }
    }

    public enum DaoTypes{
        ITEM, COURSE, ROLE, OLRDER_DETAIL,DEPARTMENT,USER,STUDENT,ACADEMIC,STUREG,STUCOURSEREG
    }
}
