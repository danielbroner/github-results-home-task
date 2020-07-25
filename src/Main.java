import common.JsonUtil;
import file.handler.FileHandler;
import repos.browser.ReposBrowser;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        String directoryPath = getProgramPath();
        String time = new SimpleDateFormat("yyyy-MM-dd-HH").format(new Date());
        String jsonResultsDirectoryPath = directoryPath + "\\results_" + time;
        String jsonFilePath =  directoryPath + "\\SecurityResultGitHub-" + time + ".Json";

        // Gets all Security repositories from Git-Hub and saves to a Json file
        new ReposBrowser().browseSecRepos(jsonFilePath);

        // Splits all search results to different Json files in parallel
        new FileHandler(jsonResultsDirectoryPath).handle(jsonFilePath);

        System.out.println("Results saved to path: " + jsonResultsDirectoryPath);
    }

    // Gets the parent path of the code source
    private static String getProgramPath()
    {
        URL url = JsonUtil.class.getProtectionDomain().getCodeSource().getLocation();
        String jarPath = null;
        try {
            jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String parentPath = new File(jarPath).getParentFile().getPath();
        return parentPath;
    }
}
