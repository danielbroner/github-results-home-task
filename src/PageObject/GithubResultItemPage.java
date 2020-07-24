package PageObject;

import common.RepoExtendedResult;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import repos.browser.DriverController;
import repos.browser.FrontUtils;

import java.util.ArrayList;
import java.util.List;

public class GithubResultItemPage {

    String title = "";
    String description = "";
    ArrayList<String> tags = new ArrayList<>();
    String time = "";
    String language = "";
    String stars = "";

    public GithubResultItemPage(int numberOfItem) {

        WebElement item = FrontUtils.waitForElementDisplay(DriverController.getDriver()
                .findElement(By.xpath("(//*[@class='mt-n1'])[" + numberOfItem + "]")));

        initItem(item);
    }

    private void initItem(WebElement item) {

        this.title = item.
                findElements(By.xpath(".//*[@class='v-align-middle']")).size() > 0
                ? item.findElement(By.xpath(".//*[@class='v-align-middle']")).getText()
                : "";

        this.description = item.
                findElements(By.xpath(".//*[@class='mb-1']")).size() > 0
                ? item.findElement(By.xpath(".//*[@class='mb-1']")).getText()
                : "";


        if (item.findElements(By.xpath(".//*[@class='topic-tag topic-tag-link f6 px-2 mx-0']")).size() > 0) {
            for (WebElement e : item.findElements(By.xpath(".//*[@class='topic-tag topic-tag-link f6 px-2 mx-0']"))) {

                this.tags.add(e.getText());
            }
        }



        this.time = item.
                findElements(By.xpath(".//*[@class='no-wrap']")).size() > 0
                ? item.findElement(By.xpath(".//*[@class='no-wrap']")).getText()
                : "";

        this.language = item.
                findElements(By.xpath(".//*[@itemprop='programmingLanguage']")).size() > 0
                ? item.findElement(By.xpath(".//*[@itemprop='programmingLanguage']")).getText()
                : "";

        this.stars = item.
                findElements(By.xpath(".//*[@class='muted-link']")).size() > 0
                ? item.findElement(By.xpath(".//*[@class='muted-link']")).getText()
                : "";
    }


    public RepoExtendedResult getItemDataAsJson(int index) {

        RepoExtendedResult item = new RepoExtendedResult();

        item.title = this.title;
        item.description = this.description;
        item.tags = this.tags;
        item.time = this.time;
        item.language = this.language;
        item.stars = this.stars;
        item.index = index;

        return item;
    }
}
