package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private String URL = "https://www.saucedemo.com";
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By pageName = By.className("product_label");
    private By loginErrorMessage = By.cssSelector("h3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getURL() {
        return URL;
    }

    public ProductsPage login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }

    public String getPageName() {
        return driver.findElement(pageName).getText();
    }

    public String getLoginErrorMessage() {
        return driver.findElement(loginErrorMessage).getText();
    }
}
