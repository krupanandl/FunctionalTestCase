package dealsDray;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTestingMachineTest {

	public static void main(String[] args) throws InterruptedException, IOException {
			
			WebDriver driver = new ChromeDriver();
			
			//Maximizes the browser
			driver.manage().window().maximize();
			
			//Enters the URL in the browser
			driver.get("https://demo.dealsdray.com/");
			
			//Polling Period
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//Enters the USERNAME
			driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
			
			//Enters the PASSWORD
			driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
			
			//Clicks on LOGIN Button
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			
			//Clicks on Order
			driver.findElement(By.xpath("//button[@class='MuiButtonBase-root has-submenu compactNavItem css-46up3a']")).click();
			
			//Clicks on Orders
			driver.findElement(By.xpath("(//button[@class='MuiButtonBase-root css-1hytwp4'])[2]")).click();
			
			//Clicks on Add Bulk Orders
			driver.findElement(By.xpath("//button[contains(@class,'css-vwfva9')]")).click();
			
			//Clicks on Choose file Button
			driver.findElement(By.xpath("//div[contains(@class,'css-uodm64')]")).click();
			
			//Enters the Path in the Window popup and demo-data.xlsx File gets Uploaded
			Runtime.getRuntime().exec("C:\\Users\\krupa\\Desktop\\DemoAppDealsDrayProgram\\DemoAppDealsDray.au4.exe");
			
			//Clicks on Import
			driver.findElement(By.xpath("//button[contains(@class,'css-6aomwy')]")).click();
			
			//Delay 
			Thread.sleep(8000);
			
			//Handles the Alert Popup
			driver.switchTo().alert().accept();
			
			//Clicks on Import
			driver.findElement(By.xpath("(//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-6aomwy'])")).click();
			
			//Clicks on Validate Data
			driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
			
			//Delay
			Thread.sleep(5000);
			
			//Handles the Alert Popup
			driver.switchTo().alert().accept();
			
			//Typecasting of TakeScreenShot
			TakesScreenshot ts = (TakesScreenshot)driver;
			
	        //capture screenshot as output type FILE
			File file = ts.getScreenshotAs(OutputType.FILE);
			try {
			//Saves the screenshot taken in destination path
			FileUtils.copyFile(file, new File("./FunctionalTest/Output.png"));
			} catch (IOException e) {
			e.printStackTrace();
			}
			//Displays the Text in Console After taking the Output of Screenshot
			System.out.println("Output Screenshot is taken");
			driver.close();
			}
}

