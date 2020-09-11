package tests.junit;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import pages.DressesPage;
import pages.HomePage;

@RunWith(SerenityRunner.class)
public class CartVerification {
	
	private EnvironmentVariables environmentVariables;
	
	@Managed
	WebDriver driver;
	
	private HomePage homePage;
	private DressesPage dressesPage;
	
	@Before
	public void initializeBrowseDriver() {
		WebDriverManager.getInstance(DriverManagerType.valueOf(environmentVariables.getProperty("webdriver.driver").toUpperCase())).setup();
	}

	@Test
	public void userShouldBeAbleToAddItemsToCart() {
		driver.manage().window().maximize();
		homePage.open();
		homePage.clickOnDressesLink();
		List<String> dresses = Arrays.asList("Printed Dress", "Printed Chiffon Dress");
		for (String d : dresses) {
			dressesPage.hoverTheProduct(d);
			dressesPage.clickOnAddToCartLink();
			dressesPage.clickOnContinueShoppingButton();
		}
		Assert.assertTrue("Cart item count mismatch!!", dressesPage.getCartText().contains(String.valueOf(dresses.size())));
	}
}