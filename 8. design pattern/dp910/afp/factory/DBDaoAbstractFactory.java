package main.dp910.afp.factory;

import main.dp910.afp.*;

public class DBDaoAbstractFactory implements DaoAbstractFactory{
    @Override
    public Dao createDaoFactory(String type) {
        Dao dao = null;
        if (type == "emp") {
            dao = new DBEmpDao();
        } else if (type == "teat") {
            dao = new DBTeatDao();
        } else {
            throw new RuntimeException("invalid type");
        }

        return dao;
    }
}
