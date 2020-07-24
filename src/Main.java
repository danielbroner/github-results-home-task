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
        String jsonResultsDirectoryPath = directoryPath + "\\results_"+ new SimpleDateFormat("yyyy-MM-dd-HH-ss")
                .format(new Date());
        String jsonFilePath =  directoryPath + "\\SecReposSearchResults.Json";

        new ReposBrowser().browseSecRepos(jsonFilePath);
        new FileHandler(jsonResultsDirectoryPath).handle(jsonFilePath);

        System.out.println("Results saved to path: " + jsonResultsDirectoryPath);
    }

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
