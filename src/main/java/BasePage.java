import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class BasePage {

    WebDriver driver;

    public  BasePage(WebDriver driver){
        this.driver= driver;

    }

    public WebElement bul(By locator){
        return driver.findElement(locator);
    }


    public void tikla(By locator){
        bul(locator).click();
    }

    public  void yaz (By locator,String text){
        bul(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator){
        return bul(locator).isDisplayed();
    }

    public void waitBySeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
