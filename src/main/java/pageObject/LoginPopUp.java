package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPopUp {

    WebDriver driver;

    public LoginPopUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "email")
    private WebElement input_Email;

    @FindBy(how = How.ID, using = "password")
    private WebElement input_password;

    @FindBy(how = How.ID, using = "loginSubmit")
    private WebElement btn_GirisYap;




    public  void EnterEmailAndPAssWord(String email,String password)
    {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        input_Email.sendKeys(email);
        input_password.sendKeys(password);

         wait = new WebDriverWait(driver, 3);
    }

    public  void ClickGirisYapButton()
    {
        btn_GirisYap.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
    }


}
