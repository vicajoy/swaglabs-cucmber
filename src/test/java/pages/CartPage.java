package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private By addToCartButton = By.xpath("//button[contains(text(),'ADD TO CART')]");
    private By removeButton = By.xpath("//button[contains(text(),'REMOVE')]");
    private By cartBadge = By.className("shopping_cart_badge");
    private By itemTitle = By.className("inventory_item_name");
    private By item = By.className("cart_item");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Gets the count of items in the cart
     * @return		   int - the count of items in the cart
     */
    public int getItemsCount() {
        return driver.findElements(item).size();
    }

    /**
     * Gets the title of an item by given index
     * @param index    int - index of the item
     * @return		   int - the count of items in the cart
     */
    public String getItemTitle(int index) {
        return driver.findElements(itemTitle).get(index - 1).getText();
    }
}
