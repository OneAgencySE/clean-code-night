package clean;

import java.util.Map;

public class EmployeeQM implements Employee {

    public int calculatePaycheck(Map<String, Integer>  allJobs) {
        int salary = 0;
        for (int jobTotal : allJobs.values()) {
            salary =+ jobTotal * 160;
        }
        return salary;
    }
}