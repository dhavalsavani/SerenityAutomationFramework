package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.pages.PageObject;
import utilities.string.StringUtil;

public class DressesPage extends PageObject {

	private String productName = "//a[@class='product-name' and @title='?']";
	private By addToCartLink = By.xpath("//li[contains(@class, 'hovered')]//a[@title='Add to cart']");
	private By continueShoppingButton = By.xpath("//span[@title='Continue shopping']");
	private By cartElement = By.xpath("//a[@title='View my shopping cart']");
	
	public void hoverTheProduct(String productName) {
		waitOnPage().until(ExpectedConditions.jsReturnsValue("return (document.readyState == 'complete')"));
		withTimeoutOf(Duration.ofSeconds(30)).waitForPresenceOf(By.xpath(StringUtil.getString(this.productName, productName)));
		moveTo(By.xpath(StringUtil.getString(this.productName, productName)));
	}
	
	public void clickOnAddToCartLink() {
		$(addToCartLink).withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
	}
	
	public void clickOnContinueShoppingButton() {
		find(continueShoppingButton).withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable().click();
	}
	
	public String getCartText() {
		return $(cartElement).withTimeoutOf(Duration.ofSeconds(10)).waitUntilPresent().getText().trim();
	}
}