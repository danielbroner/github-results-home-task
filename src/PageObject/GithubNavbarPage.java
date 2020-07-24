package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GithubNavbarPage {

    @FindBy(xpath = "//*[contains(@class,'form-control input-sm header-search-input jump-to-field js-jump-to-field js-site-search-focus')]")
    private WebElement searchBoxElement;

    public WebElement getSearchBoxElement() {
        return searchBoxElement;
    }
}
