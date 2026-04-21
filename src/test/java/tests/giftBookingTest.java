package tests;

import base.base;
import org.testng.annotations.Test;
import pages.giftBookPages;
import ScreenshotUtilities.ScreenShotUtil;

import java.io.IOException;


public class giftBookingTest extends base{
    @Test
    public void giftBook() throws IOException, InterruptedException {
        driver.get("https://www.amazon.in/");

        giftBookPages giftBook=new giftBookPages(driver);

        giftBook.clickHamburgur();
        giftBook.clickGiftCardsBtn();
        giftBook.clickAllGiftLink();
        giftBook.clickGiftVoucher();
        giftBook.clickSearchElmt();
        giftBook.emailArea("abc@123");
        giftBook.giftFrom();

        ScreenShotUtil.captureShot(driver);


    }
}
