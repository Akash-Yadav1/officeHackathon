package oneSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class oneSelenium {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.goibibo.com");

        try {
            //popup Handle
            driver.findElement(By.xpath("//span[contains(@class,'icClose')]/parent::span")).click();

            //Cabs tab select
            driver.findElement(By.xpath("//a[contains(normalize-space(),'Cabs')]")).click();

            //Outstation One-Way select
            WebElement oneOutStaion = driver.findElement(By.xpath("//label[@id='Outstation-One-way']"));
            oneOutStaion.findElement(By.xpath("//div[contains(@class,'CustomRadioButton')]")).click();

            //From selection
            driver.findElement(By.xpath("//label[contains(normalize-space(),'From')]")).click();
            WebElement fromSearch = driver.findElement(By.xpath("//label[contains(normalize-space(),'From')]/following-sibling::input"));
            fromSearch.sendKeys("Delhi");
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@role='option'][contains(normalize-space(),'Delhi')]"), "Delhi"));
            driver.findElement(By.xpath("//div[@role='option'][contains(normalize-space(),'Delhi')]")).click();

            //To Selection
            driver.findElement(By.xpath("//label[contains(normalize-space(),'To')]")).click();
            WebElement toSearch = driver.findElement(By.xpath("//label[contains(normalize-space(),'To')]/following-sibling::input"));
            toSearch.sendKeys("Manali");
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@role='option'][contains(normalize-space(),'Manali')]"), "Manali"));
            driver.findElement(By.xpath("//div[@role='option'][contains(normalize-space(),'Manali')]")).click();

            //Time of Pickup
            driver.findElement(By.xpath("//label[contains(normalize-space(),'Pickup Time')]")).click();//open drop-down
            driver.findElement(By.xpath("//label[contains(normalize-space(),'Pickup Time')]/following::li[contains(normalize-space(),'6:30 AM')]")).click();
            Thread.sleep(2000);

            //Click search button
            driver.findElement(By.xpath("//button[contains(normalize-space(),'SEARCH CABS')]")).click();

            Thread.sleep(5000);
            //Select SUV car checkbox
            WebElement carType = driver.findElement(By.xpath("//div[@role='checkbox'][contains(normalize-space(),'SUV')]"));
            carType.findElement(By.tagName("div")).click();

            String priceStr = driver.findElement(By.xpath("//div[contains(@data-testid,'CAB_CARD')]/descendant::span[contains(@class,'-WoeTq__price')]")).getText();
            System.out.println("The lowest price SUV car=" + priceStr);

            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
