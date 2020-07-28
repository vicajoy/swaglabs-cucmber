package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;
    private By addToCartButton = By.xpath("//button[contains(text(),'ADD TO CART')]");
    private By removeButton = By.xpath("//button[contains(text(),'REMOVE')]");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Adds a product to the cart by given index
     * @param index    int - index of the item
     */
    public void addProductToCart(int index) {
        driver.findElements(addToCartButton).get(index - 1).click();
    }

    /**
     * Removes a product from the cart by given index on the Products page
     * @param index    int - index of the item
     */
    public void removeProductFromCart(int index) {
        driver.findElements(removeButton).get(index - 1).click();
    }

    /**
     * Gets the count of the cart badge
     * @return    String - the badge count
     */
    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }

    /**
     * Checks whether the cart badge is present
     * @return    boolean - true if the badge is present, false if not
     */
    public boolean isCartBadgePresent() {
        try {
            driver.findElement(cartBadge);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Clicks on the cart icon to go to the cart page
     * @return    CartPage
     */
    public CartPage goToCart() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }
}
