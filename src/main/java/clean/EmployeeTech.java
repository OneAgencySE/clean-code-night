package clean;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class EmployeeTech implements Employee {

    public int calculatePaycheck(Map<String, Integer> allJobs) {
        int salary = 0;
        for (int jobTotal : allJobs.values()) {
            salary =+ (jobTotal/2) * 180;
        }
        return salary;
    }
}
