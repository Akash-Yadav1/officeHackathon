package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GiftBookPages;
import ScreenshotUtilities.ScreenShotUtil;

import java.io.IOException;


public class GiftBookingTest extends Base {
    @Test
    public void giftBook() throws IOException, InterruptedException {
        driver.get("https://www.amazon.in/");

        GiftBookPages giftBook=new GiftBookPages(driver);

        giftBook.clickHamburgur();
        giftBook.clickGiftCardsBtn();
        giftBook.clickAllGiftLink();
        giftBook.clickGiftVoucher();
        giftBook.clickSearchElmt();
        giftBook.emailArea("abc@123");
        giftBook.giftFrom();

        boolean capture=ScreenShotUtil.captureShot(driver);
        Assert.assertTrue(capture);


    }
}
