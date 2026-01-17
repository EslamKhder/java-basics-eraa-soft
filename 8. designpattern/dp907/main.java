package main.dp907;

import main.dp907.ex2.NotificationServiceImpl;
import main.dp907.ex3.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        AbstractDaoFactory abstractDaoFactory = DaoAbstractFactory.createAbstractDaoFactory("db");

        Dao dao = abstractDaoFactory.createFactory("dep");

        dao.save();
    }
}
