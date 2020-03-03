package pageObject;

import managers.FileReadManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(how = How.XPATH, using = "//span[@id='logged-in-container']/span")
    private WebElement btn_Hesabim;

    @FindBy(how = How.XPATH, using = "//div[@class='user-email']")
    private WebElement btn_userMail;

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


    @FindBy(how = How.XPATH, using = "//article[@class='component-item']/a")
    private List<WebElement> productImagesOnhomepage;

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
    public  void CheckIsUserLogin(String mail)
    {
        WebDriverWait wait = new WebDriverWait(driver, 3);

        wait.ignoring(StaleElementReferenceException.class).until((ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='logged-in-container']/span"))));
        driver.findElement(By.xpath("//span[@id='logged-in-container']/span")).click();
        //btn_Hesabim.click();
        String email=btn_userMail.getText();

        Assert.assertTrue(email.equals(mail));
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

    public  void Clickproductlist()
    {
        for (WebElement detail_img:detail_images) {

            detail_img.click();
            break;

        }

        System.out.println(FileReadManager.getInstance().getConfigReader().getReportConfigPath());
    }



}
