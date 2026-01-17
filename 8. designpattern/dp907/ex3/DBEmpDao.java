package main.dp907.ex3;

public class DBEmpDao implements Dao {
    @Override
    public void save() {
        System.out.println("Saving Employee to DB");
    }
}
