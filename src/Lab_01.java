import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab_01 {

	WebDriver driver = new ChromeDriver();
	String url = "https://global.almosafer.com/ar";
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest()
	public void beforeTest() {
		
		driver.manage().window().maximize();
	}
		
	@Test()
	public void test() {
		
		driver.get(url);
		driver.findElement(By.className("cta__saudi")).click();
		
		// check the language
		String expectedLanguage = "English";
		String actualLanguage = driver.findElement(By.className("sc-gkFcWv")).getText();
		softAssert.assertEquals(actualLanguage, expectedLanguage);
		
		// check the currency
		String expectedCurrency = "SAR";
		String actualCurrency = driver.findElement(By.className("sc-dRFtgE")).getText();
		softAssert.assertEquals(actualCurrency, expectedCurrency);
		
		// check if the flight tab selected by default
		boolean isFlightSelected = driver.findElement(By.id("uncontrolled-tab-example-tab-flights")).getAttribute("class").contains("active"); 
		softAssert.assertTrue(isFlightSelected);
		
		softAssert.assertAll();
		
	}

	@AfterTest()
	public void afterTest() {
		
		driver.close();
	}
	
}
