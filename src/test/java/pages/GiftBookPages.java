package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GiftBookPages {
    WebDriver driver;
    WebDriverWait wait;

    public GiftBookPages(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(xpath = "//div[contains(@class,'nav-left')]/a[@role='button']")
    WebElement hamburger;

    @FindBy(xpath = "//div[contains(normalize-space(),'Gift Cards')]/parent::a")
    WebElement giftCardsBtn;

    @FindBy(partialLinkText = "All Gift Cards")
    WebElement allGiftLinkText;

    @FindBy(xpath = "//a[normalize-space()='Gift Cards & Gift Vouchers']")
    WebElement giftCardLinkText;

    @FindBy( xpath = "//div[contains(@class,'SearchResultItem')]/descendant::img")
    WebElement searchEmt;

    @FindBy(xpath = "//textarea[contains(@placeholder,'e-mail')]")
    WebElement emailSelect;

    @FindBy(xpath = "//span[contains(normalize-space(),'From')]")
    WebElement fromSelect;

    //Actions
    public void clickHamburgur(){
        wait.until(ExpectedConditions.visibilityOf(hamburger));
        hamburger.click();
    }

    public void clickGiftCardsBtn() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(giftCardsBtn));
        giftCardsBtn.click();
    }

    public void clickAllGiftLink() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(allGiftLinkText));
        Actions action=new Actions(driver);
        action.click(allGiftLinkText).perform();
    }

    public void clickGiftVoucher(){
        wait.until(ExpectedConditions.elementToBeClickable(giftCardLinkText));
        giftCardLinkText.click();
    }

    public void clickSearchElmt(){
        searchEmt.click();
    }

    public void emailArea(String email){
        emailSelect.sendKeys(email);
    }

    public void giftFrom(){
        fromSelect.click();
    }

}
