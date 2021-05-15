package TestCrew.Demo1;

import static org.testng.Assert.fail;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutomationTask extends InitTest {

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		// Verify login is successfully
		driver.findElement(By.xpath("//td//input[@name='uid']")).sendKeys("mngr325739");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td//input[@name='password']")).sendKeys("YmYqubu");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td//input[@name='btnLogin']")).click();
		// Validate title of login page
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td//marquee[@class='heading3']")));
		} catch (Exception e) {
			fail("Failed to Find Title");
		}
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void VerifyManagerId() throws InterruptedException {
		// Verify the manager id is shown on the login page
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Manger Id : mngr325739')]")));
		} catch (Exception e) {
			fail("Failed to Find Manager ID");
		}
		Assert.assertEquals("//td[contains(text(),'Manger Id : mngr325739')]",
				"//td[contains(text(),'Manger Id : mngr325739')]");
		System.out.println(driver.findElement(By.xpath("//td[contains(text(),'Manger Id : mngr325739')]")).getText());
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void AddNewCustomer() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.findElement(By.xpath("//li//a[contains(text(),'New Customer')]")).click();
		// Wait Add New Customer appears in page
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//td//p[contains(text(),'Add New Customer')]")));
		} catch (Exception e) {
			fail("Failed to Find Add New Customer in Page");
		}
		driver.findElement(By.xpath("//td//input[@name='name']")).sendKeys("Mostafa Heiba");
		driver.findElement(By.xpath("(//td//input[@name='rad1'])[1]")).click();
		driver.findElement(By.xpath("//td//input[@id='dob']")).sendKeys("07/13/1991");
		driver.findElement(By.xpath("//td//textarea[@name='addr']")).sendKeys("Egypt");
		driver.findElement(By.xpath("//td//input[@name='city']")).sendKeys("Cairo");
		driver.findElement(By.xpath("//td//input[@name='state']")).sendKeys("Married");
		driver.findElement(By.xpath("//td//input[@name='pinno']")).sendKeys("369248");
		driver.findElement(By.xpath("//td//input[@name='telephoneno']")).sendKeys("01273224635");
		driver.findElement(By.xpath("//td//input[@name='emailid']")).sendKeys("mabdelqader@testcrew.sa");
		driver.findElement(By.xpath("//td//input[@name='password']")).sendKeys("Asd123!@#");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td//input[@name='sub']")).click();

		// Verify Customer Registered Successfully
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//td//p[contains(text(),'Customer Registered Successfully!!!')]")));
		} catch (Exception e) {
			fail("Failed to Customer Registered Successfully");
		}
		Assert.assertEquals("//td//p[contains(text(),'Customer Registered Successfully!!!')]",
				"//td//p[contains(text(),'Customer Registered Successfully!!!')]");
		System.out.println(driver
				.findElement(By.xpath("//td//p[contains(text(),'Customer Registered Successfully!!!')]")).getText());
	}
}
