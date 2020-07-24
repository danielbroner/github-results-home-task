package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubPaginationPage {

    @FindBy(xpath = "//*[@class='next_page']")
    private WebElement nextPaeElement;


    public void clickNextPage() {
        nextPaeElement.click();
    }
}
