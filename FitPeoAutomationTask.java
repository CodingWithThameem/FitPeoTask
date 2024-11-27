package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class FitPeoAutomationTask {

public static void main(String[] args) throws InterruptedException {
WebDriver driver =new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://fitpeo.com/home");

driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]")).click();
//Thread.sleep(5000);
WebElement calculator = driver.findElement(By.xpath("//h5[normalize-space()='Total Gross Revenue Per Year']"));
JavascriptExecutor js=(JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView();", calculator);

Actions act=new Actions(driver);
WebElement value = driver.findElement(By.xpath("//input[@id=':r0:']"));
        act.keyDown(Keys.CONTROL).click(value).sendKeys("A").keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyUp(Keys.CONTROL).perform();
   value.clear();
Thread.sleep(2000);
value.sendKeys("560");

WebElement slider = driver.findElement(By.xpath("//span[contains(@class, 'MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh') or contains(@style, 'left')]//input"));
System.out.println("Location of slider:"+slider.getLocation()); 



WebElement cpt_99091 = driver.findElement(By.xpath("//p[normalize-space()='CPT-99091']"));
js.executeScript("arguments[0].scrollIntoView();", cpt_99091);
driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[1]/label[1]/span[1]/input[1]")).click();
Thread.sleep(2000);

driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/label[1]/span[1]/input[1]")).click();
Thread.sleep(2000);

driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[3]/label[1]/span[1]/input[1]")).click();
Thread.sleep(2000);

WebElement cpt_99474 = driver.findElement(By.xpath("//p[normalize-space()='CPT-99474']"));
js.executeScript("arguments[0].scrollIntoView();", cpt_99474);
driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[8]/label[1]/span[1]/input[1]")).click();
Thread.sleep(2000);

WebElement lastHeaderValue = driver.findElement(By.xpath("//p[contains(text(), 'Total Recurring Reimbursement for all Patients Per Month')]/following-sibling::p"));

String actualValue = lastHeaderValue.getText();
System.out.println("Last header value: " + actualValue);


String expectedValue = "$75600";


Assert.assertEquals(actualValue, expectedValue, "Last header value does not match the expected value!");

System.out.println("Last header value is displayed correctly: " + actualValue);




}
}