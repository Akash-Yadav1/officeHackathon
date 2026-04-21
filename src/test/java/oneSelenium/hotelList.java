package oneSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class hotelList {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ArrayList<Integer> numAdults = new ArrayList<>();
        try {
            driver.get("https://www.goibibo.com");

            //Handle popup
            driver.findElement(By.xpath("//span[contains(@class,'icClose')]/parent::span")).click();
            Thread.sleep(3000);

            //click hotel
            driver.findElement(By.xpath("https://www.goibibo.com/hotels/")).click();

            //Select Adults
            driver.findElement(By.xpath("//span[contains(normalize-space(),'Guests & Rooms')]")).click();
            WebElement slider=driver.findElement(By.xpath("//span[contains(normalize-space(),'Adults')]/following-sibling::div"));
            WebElement decre=slider.findElement(By.xpath("//span"));
            while(decre.isEnabled()){
                decre.click();
            }
            Alert alert=(Alert)driver;
            alert.accept();

            int minVal=Integer.parseInt(slider.findElement(By.tagName("h4")).getText());

            WebElement incre=slider.findElement(By.xpath("//span[2]"));
            while (incre.isEnabled()){
                incre.click();
            }
            alert=(Alert) driver;
            alert.accept();
            int maxVal=Integer.parseInt(slider.findElement(By.tagName("h4")).getText());
            for(int i=minVal;i<=maxVal;i++){
                numAdults.add(i);
            }
            System.out.println(numAdults);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
//            driver.quit();
        }
    }

    public static void hotelNum(WebDriver driver, WebDriverWait wait, ArrayList<Integer> numAdults) {
        driver.findElement(By.xpath("//button[contains(@data-testid,'occupancy-config')]")).click();


        WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(normalize-space(),'Adults')]/following::div")));
        WebElement decre = slider.findElement(By.xpath("//button[1]"));
        while (decre.isEnabled()) {
            decre.click();
        }
        String valStr = slider.findElement(By.tagName("span")).getText();
        int minVal = Integer.parseInt(valStr);

        WebElement incre = slider.findElement(By.xpath("//button[2]"));
        while (incre.isEnabled()) {
            incre.click();
        }
        valStr = slider.findElement(By.tagName("span")).getText();
        int maxVal = Integer.parseInt(valStr);
        for (int i = minVal; i <= maxVal; i++) {
            numAdults.add(i);
        }

        System.out.println(numAdults);

    }
}
