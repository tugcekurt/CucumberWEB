package managers;

import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPopUp;
import pageObject.ProductListPage;

public class PageObjectManager {


    private WebDriver driver;
    private HomePage homePage;
    private LoginPopUp loginPopUp;
    private ProductListPage productListPage;

    public PageObjectManager(WebDriver  driver) {

        this.driver = driver;

    }


    public HomePage getHomePage(){

        return (homePage == null) ? homePage = new HomePage(driver) : homePage;

    }

    public LoginPopUp getLoginPopUp(){

        return (loginPopUp == null) ? loginPopUp = new LoginPopUp(driver) : loginPopUp;

    }

    public ProductListPage getProductListPage(){

        return (productListPage == null) ? productListPage = new ProductListPage(driver) : productListPage;

    }
}
