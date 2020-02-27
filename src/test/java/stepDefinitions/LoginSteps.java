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

    @And("click GirisYap button and check user is login with {string}")
    public void ClickGirisYApButton(String email)
    {
        loginpopup.ClickGirisYapButton();

        homePage.CheckIsUserLogin(email);

    }

    @Then("^user click Tab Buttons and user check images loaded$")
    public void ClickTabButtons$()
    {

        homePage.CheckIndirimleriKacirmaPopUp();
        homePage.ClickTabButons();

    }

    @Then("^user click any productlist image$")
    public void Clickproductlist$()
    {

       homePage.Clickproductlist();

    }
    @Then("user select filter {string}")
    public void SelectFilter(String filter)
    {

        productlist.ClickFilterMEnu(filter);

    }

    @Then("user select any checkbox")
    public void SelectCheckbox()
    {

        productlist.SelectAnyCheckboxOnFilterMenu();

    }

    @And("user click any product")
    public  void ClickAnyProduct()
    {
        productlist.ClickAnyProduct();
    }
}
