package main.dp907.ex3;

import main.abstractfactoryPattern.factory.DBDaoFactory;

public class DaoAbstractFactory {

    public static AbstractDaoFactory createAbstractDaoFactory(String type){
        AbstractDaoFactory abstractDaoFactory = null;

        if (type.equalsIgnoreCase("xml")) {
            abstractDaoFactory = new XmlFactory();
        } else if (type.equalsIgnoreCase("db")) {
            abstractDaoFactory = new DBFactory();
        } else {
            throw new RuntimeException("invalid type");
        }
        return abstractDaoFactory;
    }
}
