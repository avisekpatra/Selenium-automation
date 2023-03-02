package testPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class testDemo {

	public static void main(String[] args) throws InterruptedException {
		//setting the property to chrome driver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\paav3001\\Downloads\\chromedriver_win32\\chromedriver.exe");
        
		WebDriver driver = new ChromeDriver();                 //it will open the driver
		//launching flipkart
		driver.get("https://www.flipkart.com/");               //launch the website
		driver.manage().window().maximize();                   //make the chrome window maximize
		
		//Thread.sleep(50000);                                    //it will wait for 5 sec
		
		//validation of the title page
		String actualTitle = driver.getTitle();
		//System.out.println("My Title is : "+driver.getTitle());
		String expectedTitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!" ;
		Assert.assertEquals(actualTitle,expectedTitle,"Title didn't match"); //this will throw a msg if not macthed
		System.out.println("Flipkart page validation");
		
		
		//close login
	    driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
			
	    
		//searching in searchbar and clicking it
		WebElement searchbox=driver.findElement(By.xpath("//input[@class='_3704LK']")); 
		searchbox.sendKeys("iphone");
	    driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click(); //click
	    
	    
	    
	    //click the 1st iphone
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    List<WebElement> res = driver.findElements(By.xpath("//div[@class='_13oc-S']"));
	    res.get(0).click();
	    
	    
	    //this is used to switch the driver to the next page
	    ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wid.get(1));
		
		
	    //validate
	    String actualTitle2 = driver.getTitle();
	    System.out.print(actualTitle2);
	    String Title2="APPLE iPhone 11 ( 128 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com" ;	  
		Assert.assertEquals(actualTitle2,Title2,"Title didn't match");        //this will throw exceptions if not macthed
		System.out.println("iphone 11 validation");
		
		
		//cliclicking 64 gb varient
		driver.findElement(By.xpath("//li[@id='swatch-0-storage']")).click();
		
		
		//add to cart
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		
		
		//place order button click 
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[4]/div/form/button/span")).click();
		
		//go to the cart
		//driver.findElement(By.xpath("//a[@class='_3SkBxJ']")).click();
		
		//place order validation
		Assert.assertEquals(driver.getTitle(), "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order");
		System.out.println("Place order page validation ");
	    
		
	      
	   
	    Thread.sleep(50000);                                    //it will wait for 5 sec
				
		
		driver.close();                                        // then it will close automatically
		
		
	}

}
