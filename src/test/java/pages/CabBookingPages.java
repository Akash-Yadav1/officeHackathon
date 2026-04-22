package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CabBookingPages {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//span[contains(@class,'icClose')]/parent::span")
    WebElement popUpCloseBtn;

    //Locators
    @FindBy(xpath = "//a[contains(normalize-space(),'Cabs')]")
    WebElement cabTag;
    @FindBy(xpath = "//label[@id='Outstation-One-way']//div[contains(@class,'CustomRadioButton')]")
    WebElement oneOutStation;
    @FindBy(xpath = "//label[contains(normalize-space(),'From')]/following-sibling::input")
    WebElement fromInp;
    @FindBy(xpath = "//label[contains(normalize-space(),'To')]/following-sibling::input")
    WebElement toInp;
    @FindBy(xpath = "//label[contains(normalize-space(),'Pickup Time')]")
    WebElement timeDropDown;
    @FindBy(xpath = "//button[contains(normalize-space(),'SEARCH CABS')]")
    WebElement searchBtn;
    @FindBy(xpath = "//div[@role='checkbox'][contains(normalize-space(),'SUV')]/div[1]")
    WebElement cabTypeCheckbox;
    @FindBy(xpath = "//div[contains(@data-testid,'CAB_CARD')]/descendant::span[contains(@class,'-WoeTq__price')]")
    WebElement lowestPrice;

    public CabBookingPages(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    //Actions
    public void popClose() {
        wait.until(ExpectedConditions.visibilityOf(popUpCloseBtn));
        popUpCloseBtn.click();
    }

    public void cabTagSelect() {
        cabTag.click();
    }

    public void outStationCheckBoxSelect() {
        oneOutStation.click();
    }

    public void fromCitySelect(String city) {
        fromInp.click();
        fromInp.sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option'][contains(normalize-space(),'" + city + "')]"))).click();
    }

    public void toCitySelect(String city) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(toInp));
        toInp.click();
        Thread.sleep(3000);
        toInp.sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option'][contains(normalize-space(),'" + city + "')]"))).click();
    }

    public void timeSelect(String time) {
        timeDropDown.click();
        driver.findElement(By.xpath("//label[contains(normalize-space(),'Pickup Time')]/following::li[contains(normalize-space(),'" + time + "')]")).click();
    }

    public void clickSearch(){
        searchBtn.click();
    }

    public void cabTypeCheckboxSelect(){
        wait.until(ExpectedConditions.elementToBeClickable(cabTypeCheckbox));
        cabTypeCheckbox.click();
    }

    public String lowestCost(){
        return lowestPrice.getText();
    }


}
