package main.dp911.helper;

import main.dp911.db.DBConnection;
import main.dp911.model.Employee;
import main.dp911.service.EmployeeService;
import main.dp911.service.EmployeeServiceImpl;

import java.util.List;

public class EmployeeHelper {


    public void getAllEmployees(String userName, String password){
        DBConnection dbConnection = DBConnection.createObject();
        boolean isConnectionSuccess = dbConnection.createConnection("HR", "HR");
        // isConnectionSuccess  true
        // isConnectionSuccess  false
        if (!isConnectionSuccess) {
            return;
        }

        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employees = employeeService.getAll();

        employees.stream().forEach(employee -> System.out.println(employee));
        System.out.println("----------------------");
    }
}
