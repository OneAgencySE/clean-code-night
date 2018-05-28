package dirty;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class BadEmployee {


    public Type employeeType;

    String urlForSalary = "http://oneagency.se/salaries/gustaveiman";
    ObjectMapper objectMapper = new ObjectMapper();
    int pay = 0;

    public enum Type {
        PM, QM, TECH
    }

    public BadEmployee(Type employeeType) {
        this.employeeType = employeeType;
    }

    public int getPaycheck() {
        return calculatePaycheck(getRequest());
    }

    public int calculatePaycheck(Map<String, Integer> allJobs) {
        int salary = 0;
        for (int jobTotal : allJobs.values()) {
            switch (employeeType) {
                case PM:
                    salary =+ jobTotal * 170;
                    break;
                case QM:
                    salary =+ jobTotal * 160;
                    break;
                case TECH:
                    salary =+ (jobTotal/2) * 180;
                    break;
            }
        }

        return salary;
    }

    public Map<String, Integer> getRequest(){
        String workData = null;
        try {
            //workData = Request.Get(urlForSalary).execute().returnContent().toString();
            return objectMapper.readValue(mockJson(), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


    private String mockJson() {
        return "{ \"SEB\" : 80, \"GETTY\" : 60 }";
    }

}
