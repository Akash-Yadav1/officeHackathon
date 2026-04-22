package ScreenshotUtilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtil {

    public static boolean captureShot(WebDriver driver) throws IOException {
        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File src=screenshot.getScreenshotAs(OutputType.FILE);
        File dest=new File(System.getProperty("user.dir")+"//Screenshot//screenshot.png");

        FileHandler.copy(src,dest);
        return true;
    }

}
