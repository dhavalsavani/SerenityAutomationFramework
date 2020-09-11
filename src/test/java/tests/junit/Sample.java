package tests.junit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.junit.annotations.TestData;
import pages.HomePage;

@RunWith(SerenityParameterizedRunner.class)
public class Sample {
	
	private EnvironmentVariables environmentVariables;
	
	private String url;
	private String title;
	
	public Sample(String url, String title) {
		this.url = url;
		this.title = title;
	}

	@TestData
	public static Collection<Object[]> getWebsites() {
		return Arrays.asList(
				new Object[] {"http://www.automationpractice.com/", "My Store"}, 
				new Object[] {"https://www.phptravels.com/demo/", "Demo Script Test drive - PHPTRAVELS"});
	}
	
	@Before
	public void initializeBrowseDriver() {
		WebDriverManager.getInstance(DriverManagerType.valueOf(environmentVariables.getProperty("webdriver.driver").toUpperCase())).setup();
	}
	
	@Managed
	WebDriver driver;
	
	//Page objects
	private HomePage homePage;

	@Test
	public void toExploreDifferentFeaturesOfSerenity() {
		driver.manage().window().maximize();
		driver.get(url);
		Assert.assertEquals("Ooops landed on different page!", title, homePage.getPageTitle());
	}
}