package managers;

import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPopUp;

public class PageObjectManager {


    private WebDriver driver;
    private HomePage homePage;
    private LoginPopUp loginPopUp;
    public PageObjectManager(WebDriver  driver) {

        this.driver = driver;

    }


    public HomePage getHomePage(){

        return (homePage == null) ? homePage = new HomePage(driver) : homePage;

    }

    public LoginPopUp getLoginPopUp(){

        return (loginPopUp == null) ? loginPopUp = new LoginPopUp(driver) : loginPopUp;

    }
}
