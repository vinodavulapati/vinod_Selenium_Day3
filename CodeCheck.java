package work_day3;

import java.util.Calendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CodeCheck extends Factory2 {
	// Getting Todays Date into integer from calendar class
@Test	
 public void method() throws InterruptedException{
	 
			Calendar cal = Calendar.getInstance();
			int todayDate = cal.get(Calendar.DAY_OF_MONTH);
			System.out.println("Todays Date was: "+todayDate);
			
			int tomorrowDate = todayDate + 1;
			int dayAfterTomorrowDate = todayDate + 2;
	
			// convert dates into String format to check with web element date
			String todayStr = String.valueOf(todayDate);
			String tomorrowStr = String.valueOf(tomorrowDate);
			String dayAfterTomorrowStr = String.valueOf(dayAfterTomorrowDate);

			// **************************Origin Date PICKING from Calendar*****************

			// selecting the required next day date by selecting available all dates
			// from month box
			
			Select dropdown = new Select(getDriver().findElement(By.id("flight-departing-wrapper")));
			dropdown.selectByVisibleText(tomorrowStr);
			
			//getDriver().findElement(By.id("flight-departing-wrapper")).click();
			List<WebElement> myList3 = getDriver().findElements(
					By.xpath(".//*[@id='package-departing-wrapper']/div/div/div[2]/table/tbody/tr/td/button"));
			int total = myList3.size();
			for (int i = 0; i < total; i++) {
				String date = myList3.get(i).getText();
				if (date.equals(tomorrowStr)) {
					myList3.get(i).click();
					Thread.sleep(4000);
				}
			}


}
}