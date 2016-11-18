package work_day3;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class windowHandleCheck extends Factory2 {
	public static void switchToWindow(int index){
		
		List<String> listOfWindows = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(listOfWindows.get(index));
	}

	public static void switchToRootWindowAndCloseCurrentBrowser(){
		List<String> listOfWindows = new ArrayList<String>(getDriver().getWindowHandles());
		
		for(int i = 1; i<listOfWindows.size(); i++)
		{
			getDriver().switchTo().window(listOfWindows.get(i));
			getDriver().close();
		}
		getDriver().switchTo().window(listOfWindows.get(0));
		
		
	}
	
/*	@Test
	public void sampleSwitchWindowCheckOptions()throws InterruptedException{
	getDriver().findElement(By.cssSelector("#privacy-link")).click();
	Thread.sleep(2000);
	switchToWindow(1);
	Thread.sleep(2000);
	getDriver().findElement(By.linkText("Sign Up")).click();
	Thread.sleep(2000);
	switchToRootWindowAndCloseCurrentBrowser();
	Thread.sleep(2000);
	}
	*/
	@Test
	public void switchWindowDataPolicy()throws InterruptedException{
		getDriver().findElement(By.cssSelector("#privacy-link")).click();
		Thread.sleep(2000);
		switchToWindow(1);
		Thread.sleep(2000);
		getDriver().findElement(By.xpath(".//*[@id='u_0_v']/div/div[1]/div/div[1]/a")).click();
		Thread.sleep(2000);
		String SS = getDriver().findElement(By.xpath(".//*[@class='_1z2h' and text()='Things you do and information you provide.']")).getText();
		String ourText="Things you do and information you provide.";
		Assert.assertEquals(SS,ourText);
	}
	
}
