package TestCrew.Demo1;

import static org.testng.Assert.fail;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class InitTest {

	public ChromeDriver driver;

	@BeforeTest()
	public void OpenGure99Website() {
		String ChromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("http://demo.guru99.com/v4/");
	}

	@AfterTest
	public void tearDown() {
		try {
			driver.close();
			driver.quit();
		} catch (Exception e) {
			fail("Can't tear down");
		}
	}
}
