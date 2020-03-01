package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pageObject.HomePage;
import pageObject.LoginPopUp;
import pageObject.ProductListPage;

public class LoginSteps {

    TestContext testContext;
    HomePage homePage;
    LoginPopUp loginpopup;
    ProductListPage productlist;

    public LoginSteps(TestContext context) {

        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        loginpopup=testContext.getPageObjectManager().getLoginPopUp();
        productlist=testContext.getPageObjectManager().getProductListPage();
    }

    @Given("^user is on HomePage$")
    public void NavigateHomePage()
    {
        homePage.NavigateHomePage();

    }

    @When("^user click Login button$")
    public  void  ClickLogin()
    {
        homePage.ClickLoginButton();
    }

    @And("user enter email {string} and enter  password {string}")
    public void EnterEmailAndPassword(String email,String password)
    {
               loginpopup.EnterEmailAndPAssWord(email,password);
    }

    @And("click GirisYap button")
    public void ClickGirisYApButton()
    {
        loginpopup.ClickGirisYapButton();

        homePage.CheckIndirimleriKacirmaPopUp();

    }

    @Then("check user is login with {string}")
    public  void  CheckIsUserLoggin(String email)
    {
        homePage.CheckIsUserLogin(email);
    }


    @And("^user click every each Tab Buttons and user check every each tabs images loaded$")
    public void ClickTabButtons$()
    {


        homePage.ClickTabButons();
    }


}
