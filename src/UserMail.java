import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Represent  main search page
 */
public class UserMail {
  
	private  WebDriver driver;

   
	/*
     *  default constructor
     */
	public  UserMail(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        if (!"яндекс".equals(driver.getTitle())) {
           
            throw new IllegalStateException("This is not the main Yandex page");
        }
    }

	  /*
	   * MAIL OBJECT PAGE LOCATORS 
	   */
    
        By userName 		= By.cssSelector(".header-user-name.js-header-user-name");

        
        /*
        *  Check title for logged user
        */
       public boolean isLogged(String userLogin) throws Exception{
       	
    	String  actualUserName = driver.findElement(userName).getText();
       
    	return actualUserName.contains(userLogin);

       }
        
   
 
}