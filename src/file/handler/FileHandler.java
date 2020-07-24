package file.handler;

import common.JsonUtil;
import common.RepoExtendedResult;
import common.RepoResult;
import common.ReposSearchResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler {

    private String resultsFolderPath;

    public FileHandler(String resultFolderPath){
        this.resultsFolderPath = resultFolderPath;
        createNewDir(resultFolderPath);
    }

    public void handle(String pathToJsonFile) {

        ReposSearchResult searchResults = JsonUtil.loadFromJson(pathToJsonFile);
        searchResults.results.parallelStream().forEach(res -> SaveResultToFile(res));
    }

    public void SaveResultToFile(RepoExtendedResult res) {
        String fileTimeAsString = new SimpleDateFormat("yyyy-MM-dd-HH-ss").format(new Date());
        String fileName = "SecurityResultGitHub_" + res.index + "_" + fileTimeAsString + ".json";
        String jsonFilePath = resultsFolderPath + "/" + fileName;

        RepoResult rep = new RepoResult();
        rep.language = res.language;
        rep.tags = res.tags;
        rep.title = res.title;

        JsonUtil.saveToJson(jsonFilePath, rep);
    }

    private void createNewDir(String pathToOutput) {

        try {
            Files.createDirectories(Paths.get(pathToOutput));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
