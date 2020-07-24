package common;

//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class JsonUtil {

    public static void saveToJson(String pathToFile, Object obj){

        ObjectMapper mapper = new ObjectMapper();

        try {
            String objString = mapper.writeValueAsString(obj);
            try (PrintWriter out = new PrintWriter(pathToFile, "UTF-8")) {
                out.println(objString);
            }
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReposSearchResult loadFromJson(String pathToFile) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(new File(pathToFile), ReposSearchResult.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
