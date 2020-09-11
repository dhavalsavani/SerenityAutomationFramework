package pages;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://www.automationpractice.com/")
public class HomePage extends PageObject {

	@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/a")
	private WebElementFacade dressesLink;
	
	public void clickOnDressesLink() {
		dressesLink.waitUntilClickable();
		dressesLink.click();
	}
	
	public String getPageTitle() {
		return getTitle();
	}
}