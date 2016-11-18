package work_day3;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class screenshotTimeStamp extends Factory2 {
	static void takeScreenShot(String FileName) {
		try {
			File src2 = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("mm_dd_yyyy_HH_mm_ss").format(Calendar.getInstance().getTime());
			FileUtils.copyFile(src2, new File("C:\\Selenium" + timeStamp + "_"+FileName+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public static void screenshot()throws Exception {
		try {
			getDriver().findElement(By.id("vinod")).click();
		} catch (Exception e) {
			takeScreenShot("VINOD_ScreenShot");
			e.printStackTrace();
			throw new NoSuchElementException("no such element:");
		}
	}
}
