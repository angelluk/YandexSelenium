import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Test_Actions {
	
	public static  WebDriver driver;
	 
	@BeforeClass
	public static void setUp() throws Exception {
		
		// create anonymous class WebDriverManager and get driver for chooses browser
		driver = new WebDriverManager(driver).getWebDriverFor(WebDriverManager.Browser.CHROME);
	 	// set time for wait driver
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

 
	 /*
	  *  test method for main actions
	  */
	 @Test
	 public void testUserSearch() throws Exception{
		 
		 String searchQuery		= "selenium";
			 
		 // load main page
		 driver.get("http://www.yandex.ru/");
	 	
		 // create Search Page Object 
		 Search currSrch = new  Search(driver); 
		 
		 // create Search Result Page Object 
		 SearchResult searchResults = new  SearchResult(driver); 
		 
		 // search query
		 currSrch.searchQuery(searchQuery);
		 
		 Thread.sleep(3000);
		 
		 // ASSERT for correct title of results
		 assertTrue(searchResults.isTitleCorrect(searchQuery)); 
		
		 
		 // ASSERT for each item in results set
		 assertTrue(searchResults.isEachResultIsCorrect(searchQuery));		 
	 }
	 
	
	 /*
	  *  test authorization in mail
	  */
	 @Test
	 public void testUsermainLogin() throws Exception{
		 
		 String userLogin		= "aleksei.lukjanenko";
		 String userPassword	= "angelluk";
			 
		 // load main page
		 driver.get("http://www.yandex.ru/");
	 	
		 // create Search Page Object 
		 Search currSrch = new  Search(driver); 
		 
		 // create User mail Page Object 
		 UserMail userLoginMail = new  UserMail(driver); 
		 
		 // login to email account
		 currSrch.userLoginMailAs(userLogin,userPassword);

		 // ASSERT for user is logged
		 assertTrue(userLoginMail.isLogged(userLogin));		 
	 }
		
	@AfterClass
     public static void tearDown()
     { 
          driver.quit(); 
     } 
	
}

