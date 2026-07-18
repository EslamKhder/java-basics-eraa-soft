package main.dp911;


import main.dp911.helper.EmployeeHelper;

public class main {
    public static void main(String[] args) throws IllegalAccessException {

        // place 1
        // DBConnection dbConnection = new DBConnection();   connection false ---> true
        EmployeeHelper employeeHelper1 = new EmployeeHelper();
        employeeHelper1.getAllEmployees("HR", "HR");

        // place 2
        // DBConnection dbConnection = new DBConnection();   connection false ---> true
        EmployeeHelper employeeHelper2 = new EmployeeHelper();
        employeeHelper2.getAllEmployees("HR", "HR");

        // place 3
        EmployeeHelper employeeHelper3 = new EmployeeHelper();
        employeeHelper3.getAllEmployees("HR", "HR");

        // place 4
        EmployeeHelper employeeHelper4 = new EmployeeHelper();
        employeeHelper4.getAllEmployees("HR", "HR");

        // place 5
        EmployeeHelper employeeHelper5 = new EmployeeHelper();
        employeeHelper5.getAllEmployees("HR", "HR");

    }



}
