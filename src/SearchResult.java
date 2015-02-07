import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Represent  search result page
 */
public class SearchResult {
  
	private  WebDriver driver;

   
	/*
     *  default constructor
     */
	public  SearchResult(WebDriver driver) {
        this.driver = driver;

        // Check that we're on the right page.
        if (!"яндекс".contains(driver.getTitle())) {
           
            throw new IllegalStateException("This is not the search Yandex page");
        }
    }

	  /*
	   * SEARCH RESULT OBJECT PAGE LOCATORS 
	   */
    
       By searchResults 		= By.cssSelector(".b-link.serp-item__title-link");
        
      
        /*
        *  Check title for include query string
        */
       public boolean isTitleCorrect(String userQuery) throws Exception{
       	
    	String  actualTitle = driver.getTitle().toLowerCase();
       
    	return actualTitle.contains(userQuery.toLowerCase());

       }
       
       
       /*
        *  Check for items in search results is contain search query
        */
       public boolean isEachResultIsCorrect(String userQuery) throws Exception{
       
    	   boolean result = true;
    	   
    	   // find result set
           List<WebElement> allResults = driver.findElements(searchResults);
           
           for (WebElement curResult : allResults) {
              
        	   String  actualTitle = curResult.getText().toLowerCase();
        	   System.out.println(actualTitle);
               
               result = result && curResult.getText().toLowerCase().contains(userQuery);
               
               System.out.println("Contain query? - " + curResult.getText().toLowerCase().contains(userQuery));
           }
       	   
       	return result;

       }

}