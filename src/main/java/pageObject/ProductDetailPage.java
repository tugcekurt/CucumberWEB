package pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductDetailPage {

    WebDriver driver;
    String productName;

    public  ProductDetailPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id='product-detail-app']//button[@class='pr-in-btn add-to-bs']")
    private WebElement btn_SepeteEkle;


    @FindBy(how = How.ID, using = "myBasketListItem")
    private WebElement btn_Sepetim;

    @FindBy(how = How.XPATH, using = "//span[@class='pr-in-nm']")
    private WebElement txt_ProductNameInDetailPage;


    @FindBy(how = How.XPATH, using = "//span[@class='title basketlist-productinfo-title']")
    private WebElement txt_ProductNameInBasket;

    public  void ClickSepeteEkleButon()
    {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        productName=txt_ProductNameInDetailPage.getText();
        btn_SepeteEkle.click();

         wait = new WebDriverWait(driver, 3);
    }

    public  void  ClickSepetimButton()
    {
        btn_Sepetim.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
    }

    public  void CheckIsProductAdded()
    {
        Assert.assertTrue(productName.contains(txt_ProductNameInBasket.getText()));
    }
}
