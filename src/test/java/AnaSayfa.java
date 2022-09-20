import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AnaSayfa extends BasePage{

    By giyimVeAksesur =By.xpath("//a[contains(.,'Giyim & aksesuar')]");
    By kadinIcGiyim = By.xpath("//div[@class='categories']//a[contains(.,'Kadın İç Giyim')]");
    By  dizAltCorp = By.xpath("//div[@class='categories']//a[contains(.,'Dizaltı Çorap')]");
    By cerezleriKabulEt= By.xpath("//button[@id =\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]");
    WebElement cerezleriKabulEtt = driver.findElement(By.xpath("//button[@id =\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]"));

    public AnaSayfa(WebDriver driver) {
        super(driver);
    }

    public void duraksa() {
        tikla(giyimVeAksesur);
        waitBySeconds(2);
        tikla(kadinIcGiyim);
        waitBySeconds(2);
        tikla(dizAltCorp);
    }


    public void setCerezleriKabulEt(){
        if (isDisplayed(cerezleriKabulEt)){
            Actions actions = new Actions(driver);
            actions.click(cerezleriKabulEtt).perform();
        }
    }
}
