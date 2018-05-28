package clean;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MockJsonApi implements JsonApi {
    ObjectMapper objectMapper = new ObjectMapper();

    public String getJson() {
        return "{ \"SEB\" : 80, \"GETTY\" : 60 }";
    }

    public Map getObject() {
        return toObject(getJson());
    }

    public Map toObject(String json) {
        try {
            return objectMapper.readValue(json, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap();
        }
    }
}
