package main.dp910.afp.factory;

import main.dp910.afp.Dao;

public interface DaoAbstractFactory {

    Dao createDaoFactory(String type);

}
