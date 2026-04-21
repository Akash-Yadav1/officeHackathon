package oneSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class giftCard {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //new window for gift
        driver.get("https://www.amazon.in/");
        try {
            //Click the hamburgur
            driver.findElement(By.xpath("//div[contains(@class,'nav-left')]/a[@role='button']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[contains(normalize-space(),'Gift Cards')]/parent::a")).click();
            Thread.sleep(3000);

            WebElement elmt = driver.findElement(By.partialLinkText("All Gift Cards"));
            Actions action = new Actions(driver);
            action.click(elmt).perform();

            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[normalize-space()='Gift Cards & Gift Vouchers']")).click();
            driver.findElement(By.xpath("//div[contains(@class,'SearchResultItem')]/descendant::img")).click();

            WebElement emailArea = driver.findElement(By.xpath("//textarea[contains(@placeholder,'e-mail')]"));
            emailArea.sendKeys("abc@123");
            driver.findElement(By.xpath("//span[contains(normalize-space(),'From')]")).click();
            Thread.sleep(5000);

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File(System.getProperty("user.dir") + "\\screenshot.png"));

            
        } catch (RuntimeException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
