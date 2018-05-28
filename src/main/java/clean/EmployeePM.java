package clean;

import java.util.Map;

public class EmployeePM implements Employee {
    public int calculatePaycheck(Map<String, Integer> allJobs) {
        int salary = 0;
        for (int jobTotal : allJobs.values()) {
            salary =+ jobTotal * 170;
        }
        return salary;
    }
}