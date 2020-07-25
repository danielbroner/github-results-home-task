package common;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class JsonUtil {

    // Use third party called Jackson to map any object to Json string to be saved to file
    public static void saveToJson(String pathToFile, Object obj){

        ObjectMapper mapper = new ObjectMapper();

        try {
            String objString = mapper.writeValueAsString(obj);
            objString = objString.replace("},{", "},\n\n{");
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

    // Loading repo search results object from json file
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
