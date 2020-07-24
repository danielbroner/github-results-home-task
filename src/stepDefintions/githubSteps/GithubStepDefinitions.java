package stepDefintions.githubSteps;

import PageObject.GithubNavbarPage;
import PageObject.GithubPaginationPage;
import PageObject.GithubResultItemPage;
import common.RepoExtendedResult;
import org.json.simple.JSONObject;
import org.openqa.selenium.support.PageFactory;
import repos.browser.DriverController;
import stepDefintions.GeneralStepDefinitions;

import java.util.ArrayList;

public class GithubStepDefinitions {

    final String githubUrl = "https://github.com/";
    GithubPaginationPage githubPaginationPage = PageFactory.initElements(DriverController.getDriver(), GithubPaginationPage.class);

    public GithubStepDefinitions() {
        GeneralStepDefinitions.navigateToWebsite(githubUrl);
    }

    public void navbarSearch(String keyword) {

        GithubNavbarPage githubNavbarPage = PageFactory.initElements(DriverController.getDriver(), GithubNavbarPage.class);
        githubNavbarPage.getSearchBoxElement().sendKeys(keyword);
        githubNavbarPage.getSearchBoxElement().submit();
    }

    public ArrayList<RepoExtendedResult> getAllResults(int numberOfResults) {

        ArrayList<RepoExtendedResult> allItems = new ArrayList<>();
        GithubResultItemPage githubResultItemPage = null;

        for (int i = 1; i <= numberOfResults; i+=10) {

            for (int c = 1; c <= 10 && c <= (numberOfResults + 1 - i); c++) {
                githubResultItemPage = new GithubResultItemPage(c);
                allItems.add(githubResultItemPage.getItemDataAsJson(allItems.size() + 1));
            }

            if(allItems.size() < numberOfResults) {
                githubPaginationPage.clickNextPage();
            }

            //TO DO custom wait
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return allItems;
    }
}
