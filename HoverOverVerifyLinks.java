package work_day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverOverVerifyLinks extends Factory2{
	@Test
	public void verifyLinks() throws InterruptedException{
		
		Thread.sleep(3000);
		getDriver().manage().window().maximize();
		WebElement ele1 = getDriver().findElement(By.xpath("html/body/div[1]/header/div[1]/div/div/div/div/nav/ul/li[1]/a"));

		Actions action = new Actions(getDriver());
		action.moveToElement(ele1).build().perform();
		Thread.sleep(2000);

		WebElement ele2 = getDriver().findElement(By.xpath("html/body/div[1]/header/div[1]/div/div/div/div/nav/ul/li[1]/ul/li[3]/a"));
		action.moveToElement(ele2).build().perform();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("html/body/div[1]/header/div[1]/div/div/div/div/nav/ul/li[1]/ul/li[3]/ul/li[6]/ul[2]/li[2]/a")).click();
		Thread.sleep(2000);
		JavascriptExecutor aaa=(JavascriptExecutor)getDriver();
		aaa.executeScript("scroll(0, 100000)");
		List<WebElement> actualList= getDriver().findElements(By.className("footer-col__link"));
		List<WebElement> expectedList= getDriver().findElements(By.className("footer-col__link"));
		for(int i=0;i<actualList.size();i++)
		{
			
			
			for(int j=0;j<expectedList.size();j++)
			{
			 
			if(actualList.get(i).getText().equals(expectedList.get(j).getText())){
				System.out.println(" verified"+"       "+actualList.get(i).getText());
			}
			 else
				Assert.assertFalse(false);
		}
			}
		}
	
	}


