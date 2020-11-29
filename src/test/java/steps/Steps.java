package steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class Steps {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("I am on Login page")
    public void iAmOnLoginPage() {
        driver.get(loginPage.getURL());
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("I should be redirected to Products page")
    public void iShouldBeRedirectedToProductsPage() {
        Assert.assertEquals(loginPage.getPageName(), "Products");
    }

    @When("I enter invalid username and password")
    public void iEnterInvalidUsernameAndPassword() {
        loginPage.login("user", "user");
    }

    @Then("I should see error message")
    public void iShouldSeeErrorMessage() {
        Assert.assertTrue(loginPage.getLoginErrorMessage().contains("Username and password do not match any user in this service"));
    }

    @Given("I am on Products page")
    public void iAmOnProductsPage() {
        driver.get(loginPage.getURL());
        productsPage = loginPage.login("standard_user", "secret_sauce");
    }

    @When("I add an item to cart")
    public void iAddAnItemToCart() {
        productsPage.addProductToCart(1);
    }

    @When("I remove the item from cart")
    public void iRemoveTheItemFromCart() {
        productsPage.removeProductFromCart(1);
    }

    @Then("cart badge count disappears")
    public void cartBadgeCountDisappears() {
        Assert.assertFalse(productsPage.isCartBadgePresent());
    }

    @Then("I can see it in the cart")
    public void iCanSeeItInTheCart() {
        cartPage = productsPage.goToCart();
        Assert.assertEquals(cartPage.getItemsCount(), 1);
        Assert.assertEquals(cartPage.getItemTitle(1), "Sauce Labs Backpack");
    }

    @Then("cart badge count is {string}")
    public void cartBadgeCountIs(String count) {
        Assert.assertEquals(productsPage.getCartBadgeCount(), count);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
