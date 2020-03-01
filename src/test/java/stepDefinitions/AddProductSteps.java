package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
import pageObject.LoginPopUp;
import pageObject.ProductDetailPage;
import pageObject.ProductListPage;

public class AddProductSteps {

    TestContext testContext;
    HomePage homePage;
    LoginPopUp loginpopup;
    ProductListPage productlist;
    ProductDetailPage productDetailPage;

    public  AddProductSteps(TestContext context)
    {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
        loginpopup=testContext.getPageObjectManager().getLoginPopUp();
        productlist=testContext.getPageObjectManager().getProductListPage();
        productDetailPage=testContext.getPageObjectManager().getProductDetailPage();
    }


    @Then("^user click any productlist image$")
    public void Clickproductlist$()
    {

        homePage.Clickproductlist();

    }

    @And("user click any product")
    public  void ClickAnyProduct()
    {
        productlist.ClickAnyProduct();
    }

    @When("user add product in basket")
    public  void AddProduct()
    {
        productDetailPage.ClickSepeteEkleButon();
    }

    @Then("user seen added product")
    public  void CheckIsProductAdded()
    {
        productDetailPage.ClickSepetimButton();
        productDetailPage.CheckIsProductAdded();
    }
}
