package managers;

import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPopUp;
import pageObject.ProductDetailPage;

public class PageObjectManager {


    private WebDriver driver;
    private HomePage homePage;
    private LoginPopUp loginPopUp;
    private ProductDetailPage productDetailPage;

    public PageObjectManager(WebDriver  driver) {

        this.driver = driver;

    }


    public HomePage getHomePage(){

        return (homePage == null) ? homePage = new HomePage(driver) : homePage;

    }

    public LoginPopUp getLoginPopUp(){

        return (loginPopUp == null) ? loginPopUp = new LoginPopUp(driver) : loginPopUp;

    }

    public ProductDetailPage getProductDetailPage(){

        return (productDetailPage == null) ? productDetailPage = new ProductDetailPage(driver) : productDetailPage;

    }
}
