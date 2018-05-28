import clean.*;
import dirty.BadEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        badEmployee();
        goodEmployee();
    }

    private static void badEmployee() {
        List<BadEmployee> employees = new ArrayList<BadEmployee>();
        employees.add(new BadEmployee(BadEmployee.Type.TECH));
        employees.add(new BadEmployee(BadEmployee.Type.PM));
        employees.add(new BadEmployee(BadEmployee.Type.QM));

        for (BadEmployee employee : employees) {
            System.out.println("Bad: "+employee.getPaycheck());
        }
    }

    private static void goodEmployee() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new EmployeeTech());
        employees.add(new EmployeePM());
        employees.add(new EmployeeQM());

        JsonApi api = new MockJsonApi();
        Map apiData = api.getObject();

        for (Employee employee : employees) {
            System.out.println("Good: "+employee.calculatePaycheck(apiData));
        }
    }
}
