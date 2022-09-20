import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UrunSayfasi extends BasePage {

    By kategoriDogrulama = By.xpath("//ol[@class='breadcrumb']//a[contains(.,'Dizaltı Çorap')]");
    By urunIsmi = By.xpath("//h3[contains(.,'Penti Kadın 50 Denye Pantolon Çorabı Siyah')]");
    //div[@class='message']/span[@class='text']
    By sepetIciUrunIsmi = By.cssSelector(".js-basket-sum span");
    public UrunSayfasi(WebDriver driver) {
        super(driver);
    }

    public boolean UrunSayfasiDogrulama() {
        return isDisplayed(kategoriDogrulama);
    }
    public void UrunuSec() {
        tikla(urunIsmi);
        waitBySeconds(2);
    }
    public boolean UrunEklemeKontrol() {
        return isDisplayed(sepetIciUrunIsmi);
    }
}
