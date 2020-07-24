package repos.browser;

import common.JsonUtil;
import common.ReposSearchResult;

public class ReposBrowser {

    public void browseSecRepos(String pathToOutput) {

        SecReposBrowser secReposBrowser = new SecReposBrowser();
        ReposSearchResult searchResults = secReposBrowser.getFirstResultsFromGitHub();

        JsonUtil.saveToJson(pathToOutput, searchResults);
    }
}
