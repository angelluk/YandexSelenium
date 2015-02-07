import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Represent  main search page
 */
public class Search {
  
	private  WebDriver driver;

   
	/*
     *  default constructor
     */
	public  Search(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        if (!"яндекс".equals(driver.getTitle())) {
           
            throw new IllegalStateException("This is not the main Yandex page");
        }
    }

	  /*
	   * SEARCH OBJECT PAGE LOCATORS 
	   */
    
    	//By searchQuery 			= By.cssSelector(".login>span>a");
    	By searchQuery 			= By.id("text");
        By searchButton 		= By.cssSelector(".button.suggest2-form__button");
        By searchResults 		= By.id("pwd");
        
        By restoreFocus 		= By.cssSelector(".b-page.b-page_blink-exp.b-page_noskin.b-page_domik_old.css3-transition-off");
       
        By userLogin			= By.cssSelector(".auth__username .input__box .input__control");
        By userPassword			= By.cssSelector(".auth__password .input__box .input__control");
        By loginButton			= By.cssSelector(".button.auth__login-button");
        
    /*
     *  Search User 
     */
    public  void searchQuery(String userQuery) throws InterruptedException {
       
    	// input query and searching
    	driver.findElement(searchQuery).click();
    	driver.findElement(searchQuery).clear();
    	driver.findElement(searchQuery).sendKeys(userQuery);
    	
    	//return focus from search helper
    	driver.findElement(restoreFocus).click();
    	
    	// start search
    	driver.findElement(searchButton).click();
          
    }
  
    /*
     *  SignIn User to email
     */
    public  void userLoginMailAs(String Login, String Password) throws InterruptedException {
       
    	// input login
    	driver.findElement(userLogin).click();
    	driver.findElement(userLogin).clear();
    	driver.findElement(userLogin).sendKeys(Login);
    	
    	// input password
    	driver.findElement(userPassword).click();
    	driver.findElement(userPassword).clear();
    	driver.findElement(userPassword).sendKeys(Password);
    	
    	
    	// start login
    	driver.findElement(loginButton).click();
          
    }
 
}