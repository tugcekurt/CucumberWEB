package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductListPage {

    WebDriver driver;
    String filterName;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH, using = "//*[@id='boutique-detail-app']//div[@class='aggregations']//button")
    private List<WebElement> butons_FilterMenu;

    @FindBy(how = How.XPATH, using = "//div[@class='dd-list']/ul//li/i[@class='check']")
    private List<WebElement> chkboxes_FilterMenu;

    @FindBy(how = How.XPATH, using = "//div[@class='products']/div")
    private List<WebElement> filteredproducts;

    public  void ClickFilterMEnu(String filter)
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        int index=0;
        for (WebElement btn_FilterMenu : butons_FilterMenu) {

            List<WebElement> tabelement = driver.findElements(By.xpath("//*[@id='boutique-detail-app']//div[@class='aggregations']//button"));
            String text = tabelement.get(index).getText();
            System.out.println(text);

            if (text.equals(filter)) {
                tabelement.get(index).click();
                break;
            }
            wait = new WebDriverWait(driver, 3);
            index++;

        }
    }

    public  void  SelectAnyCheckboxOnFilterMenu()
    {
        for (WebElement chkbx_FilterMenu : chkboxes_FilterMenu) {
            filterName=chkbx_FilterMenu.getText();
            chkbx_FilterMenu.click();
            break;

        }
    }

    public void ClickAnyProduct()
    {

        WebDriverWait wait = new WebDriverWait(driver, 5);


        for (WebElement filteredproduct : filteredproducts) {

           filteredproduct.click();


        }
    }
}
