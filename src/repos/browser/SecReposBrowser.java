package repos.browser;
import common.ReposSearchResult;
import stepDefintions.githubSteps.GithubStepDefinitions;

public class SecReposBrowser {

    public ReposSearchResult getFirstResultsFromGitHub() {

        ReposSearchResult firstResults = new ReposSearchResult();
        GithubStepDefinitions githubStepDefinitions = new GithubStepDefinitions();
        githubStepDefinitions.navbarSearch("security");

        firstResults.results = githubStepDefinitions.getAllResults(50);

        DriverController.getDriver().quit();

        return firstResults;
    }
}
