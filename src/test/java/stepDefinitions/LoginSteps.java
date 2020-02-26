package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pageObject.HomePage;
import pageObject.LoginPopUp;

public class LoginSteps {

    TestContext testContext;
    HomePage homePage;
    LoginPopUp loginpopup;
    public LoginSteps(TestContext context) {

        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        loginpopup=testContext.getPageObjectManager().getLoginPopUp();
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

    @And("^click GirisYap button$")
    public void ClickGirisYApButton()
    {
        loginpopup.ClickGirisYapButton();

        homePage.CheckIndirimleriKacirmaPopUp();
        homePage.ClickTabButons();

    }

    @Then("^user click Tab Buttons and user check images loaded$")
    public void ClickTabButtons$()
    {

        homePage.CheckIndirimleriKacirmaPopUp();
        homePage.ClickTabButons();

    }




    
}
