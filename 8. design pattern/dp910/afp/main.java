package main.dp910.afp;


import main.dp910.afp.factory.DaoAbstractFactory;
import main.dp910.afp.factory.DaoFactory;

public class main {
    public static void main(String[] args) {

        DaoAbstractFactory daoFactory = DaoFactory.createDaoFactory("db");
        Dao dao = daoFactory.createDaoFactory("dept");

        dao.save();


//        Dao dao = new XMLDeptDao();
//        dao.save();
//        dao = new XMLEmpDao();
//        dao.save();

//        Dao dao = new DBDeptDao();
//        dao.save();
//        dao = new DBEmpDao();
//        dao.save();

//        Dao dao = new XMLDeptDao();
//        dao.save();
//        dao = new DBDeptDao();
//        dao.save();

//        Dao dao = new XMLEmpDao();
//        dao.save();
//        dao = new DBEmpDao();
//        dao.save();
    }

}
