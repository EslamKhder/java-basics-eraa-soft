package main.dp907.ex3;

public class DBFactory implements AbstractDaoFactory{

    @Override
    public  Dao createFactory(String type){
        Dao dao = null;
        if (type.equalsIgnoreCase("emp")) {
            dao = new DBEmpDao();
        } else if (type.equalsIgnoreCase("dep")) {
            dao = new DBDeptDao();
        } else {
            throw new RuntimeException("invalid type " + type);
        }

        return dao;
    }
}
