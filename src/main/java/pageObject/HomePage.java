package pageObject;

import managers.FileReadManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;


public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    String url= FileReadManager.getInstance().getConfigReader().getApplicationUrl();

    @FindBy(how = How.ID, using = "accountBtn")
    private WebElement btn_Login;

    @FindBy(how = How.XPATH, using = "//a[contains(@title,'Close')]")
    private WebElement btn_x;

    @FindBy(how = How.XPATH, using = "//div[@id='navigation-wrapper']/nav/ul/li/a")
    private List<WebElement> btn_tabs;

    @FindBy(how = How.XPATH, using = "//*[@id='browsing-gw-homepage']//article[@class='component-item']//img")
    private WebElement images;

    @FindBy(how = How.XPATH, using = "//div[@id='modal-root']//..//div[contains(@title,'Kapat')]")
    private WebElement btn_CloseIndirimleriKacırmaPopUp;

    @FindBy(how = How.XPATH, using = " //*[@id='browsing-gw-homepage']//article[@class='component-item']/a")
    private List<WebElement> detail_images;

    public  void NavigateHomePage()
    {

        driver.navigate().to(url);
        WebDriverWait wait = new WebDriverWait(driver, 3);
    }

    public void ClickLoginButton()
    {
        PassAlertPopUp();
        btn_Login.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);

    }

    public  void PassAlertPopUp()
    {
        btn_x.click();
    }

    public  void CheckIndirimleriKacirmaPopUp()
    {
        try {
            if (btn_CloseIndirimleriKacırmaPopUp.isDisplayed())
            {
                btn_CloseIndirimleriKacırmaPopUp.click();
            }
        }
        catch(Exception ignore)
        {

        }

    }

    public  void CheckIsImagesLoaded()
    {

        try {
            Object result = ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].complete && " +
                            "typeof arguments[0].naturalWidth != \"undefined\" && " +
                            "arguments[0].naturalWidth > 0", images);

            System.out.println(result);


        }
        catch (Exception ignore)
        {
            Logger logger =Logger.getLogger(HomePage.class);

           logger.info("Images not loaded");
        }


    }


    public  void ClickTabButons()
    {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.switchTo().defaultContent();

       int index=0;

        for (WebElement btn_tab : btn_tabs) {

            List<WebElement> tabelement = driver.findElements(By.xpath("//div[@id='navigation-wrapper']/nav/ul/li/a"));
            String text = tabelement.get(index).getText();
            System.out.println(text);
            tabelement.get(index).click();
            wait = new WebDriverWait(driver, 5);
            index++;
            CheckIsImagesLoaded();
        }


    }

    public  void ClickProductDetail()
    {
        for (WebElement detail_img:detail_images) {

            detail_img.click();
            break;

        }
    }

}
