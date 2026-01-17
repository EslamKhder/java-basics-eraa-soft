package main.dp907.ex3;

import main.dp907.ex3.Dao;
import main.dp907.ex3.XMLDeptDao;
import main.dp907.ex3.XMLEmpDao;

public class XmlFactory implements AbstractDaoFactory {

    @Override
    public Dao createFactory(String type){
        Dao dao = null;
        if (type.equalsIgnoreCase("emp")) {
            dao = new XMLEmpDao();
        } else if (type.equalsIgnoreCase("dep")) {
            dao = new XMLDeptDao();
        } else {
            throw new RuntimeException("invalid type " + type);
        }

        return dao;
    }
}
