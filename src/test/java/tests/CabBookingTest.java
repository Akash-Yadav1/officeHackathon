package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CabBookingPages;

public class CabBookingTest extends Base {

    @Test
    public void bookSUVCab() throws InterruptedException {
        driver.get("https://www.goibibo.com");

        CabBookingPages cab=new CabBookingPages(driver);

        cab.popClose();
        cab.cabTagSelect();
        cab.outStationCheckBoxSelect();
        cab.fromCitySelect("Delhi");

        cab.toCitySelect("Manali");
        cab.timeSelect("6:30 AM");

        cab.clickSearch();

        cab.cabTypeCheckboxSelect();
        Thread.sleep(5000);

        String cost=cab.lowestCost();
        System.out.println("Lowest cost="+cost);
        Assert.assertNotNull(cost);

    }

}
