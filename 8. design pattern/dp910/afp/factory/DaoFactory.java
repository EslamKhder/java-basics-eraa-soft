package main.dp910.afp.factory;

public class DaoFactory {

    public static DaoAbstractFactory createDaoFactory(String type) {
        DaoAbstractFactory dao = null;
        if (type == "xml") {
            dao = new XmlDaoAbstractFactory();
        } else if (type == "db") {
            dao = new DBDaoAbstractFactory();
        } else {
            throw new RuntimeException("invalid type");
        }
        return dao;
    }
}
