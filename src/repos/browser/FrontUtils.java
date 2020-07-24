package repos.browser;

import org.openqa.selenium.WebElement;
import java.util.List;

public class FrontUtils {

    public static WebElement waitForElementDisplay(WebElement element) {

        int counter = 0;

        while (counter < 10) {

            try {
                element.isDisplayed();

                break;
            } catch (Exception e) {
                counter++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }

        return element;
    }
}
