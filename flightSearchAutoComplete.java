package work_day3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class flightSearchAutoComplete extends Factory2 {
	
	@Test
	public static void formAutoFill() throws InterruptedException {

		getDriver().findElement(By.xpath(".//*[@id='tab-flight-tab']")).click();
		getDriver().findElement(By.xpath(".//*[@id='flight-origin']")).sendKeys("New york");
		Thread.sleep(2000);

		// storing all suggested airports into a list *********** ORGIN Suggestions******************************
		List<WebElement> orginSuggestionList = getDriver().findElements(By.className("results-item"));
		// selecting required airport from suggestion list
		
		for (WebElement el : orginSuggestionList) {
			if (el.getText().contains("LaGaurdia")) {
				el.click();
				break;
			}
		}
		getDriver().findElement(By.xpath(".//*[@id='package-destination']']")).sendKeys("Las");
		
		// storing all suggestions into a list ************** DESTINATION Suggestions *****************************
		List<WebElement> myList2 = getDriver().findElements(By.className("icon icon-flights"));
		// selecting required airport from suggestion list
		
		for (WebElement el : myList2) {
			if (el.getText().contains("LAS")) {
				el.click();
				break;
			}
		}

		// Getting Todays Date into integer from calendar class

		Calendar cal = Calendar.getInstance();
		int todayDate = cal.get(Calendar.DAY_OF_MONTH);

		int tomorrowDate = todayDate + 1;
		int dayAfterTomorrowDate = todayDate + 2;

		// convert dates into String format to check with web element date
		String todayStr = String.valueOf(todayDate);
		String tomorrowStr = String.valueOf(tomorrowDate);
		String dayAfterTomorrowStr = String.valueOf(dayAfterTomorrowDate);

		// **************************Origin Date PICKING from Calendar*****************

		// selecting the required next day date by selecting available all dates
		// from month box

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

		// ********************** Destitaion Date PICKING from Calendar
		// **************
		List<WebElement> myList4 = getDriver().findElements(
				By.xpath(".//*[@id='package-returning-wrapper']/div/div/div[2]/table/tbody/tr/td/button"));
		int total2 = myList4.size();
		for (int i = 0; i < total2; i++) {
			String date = myList4.get(i).getText();
			if (date.equals(dayAfterTomorrowStr)) {
				myList4.get(i).click();
				Thread.sleep(4000);
			}
		}

		// ******************************** 4 Adults & 1 child and age selection
		
		WebElement NumOfAdults = getDriver().findElement(By.cssSelector("#flight-adults"));
		Select dropdownAdults = new Select(NumOfAdults);
		dropdownAdults.selectByVisibleText("3");
		Thread.sleep(3000);

		WebElement NumOfChilds = getDriver().findElement(By.cssSelector("#flight-children"));
		Select dropdownchild = new Select(NumOfChilds);
		dropdownchild.selectByVisibleText("1");
		Thread.sleep(3000);

		WebElement NumOfChildage = getDriver().findElement(By.cssSelector("#flight-age-select-1"));
		Select dropdownchildage = new Select(NumOfChildage);
		dropdownchildage.selectByVisibleText("12");
		Thread.sleep(3000);

		getDriver().findElement(By.id("search-button")).click();

		String S = getDriver().findElement(By.xpath(".//*[@class='title-city-text']")).getText();
		String actual = "Select your departure to Las Vegas";

		Assert.assertEquals(S, actual);

	}

}
