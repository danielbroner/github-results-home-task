package stepDefintions;

import repos.browser.DriverController;

public class GeneralStepDefinitions {

    public static void navigateToWebsite(String url) {

        DriverController.getDriver().navigate().to(url);
    }
}
