package main.dp910.afp.factory;

import main.dp910.afp.Dao;
import main.dp910.afp.XMLEmpDao;
import main.dp910.afp.XMLTeatEmpDao;

public class XmlDaoAbstractFactory  implements DaoAbstractFactory{
    @Override
    public Dao createDaoFactory(String type) {
        Dao dao = null;
        if (type == "emp") {
            dao = new XMLEmpDao();
        }else if (type == "teat") {
            dao = new XMLTeatEmpDao();
        } else {
            throw new RuntimeException("invalid type");
        }

        return dao;
    }
}
