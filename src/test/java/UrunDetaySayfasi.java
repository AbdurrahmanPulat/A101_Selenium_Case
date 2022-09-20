import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UrunDetaySayfasi extends BasePage {

    By urunEkle =By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']");
    By urunRenk =By.xpath("//span[.='SİYAH']");
    By sepetGoruntule =By.xpath("//div[@class='right-side']/a[3]");
    By sepetiOnayla = By.xpath("//a[@class=\"button green checkout-button block js-checkout-button\"]");
    public UrunDetaySayfasi(WebDriver driver) {
        super(driver);
    }

    public boolean UrunDetaySayfasiDogrulama() {
        return isDisplayed(urunRenk);
    }
    public void sepeteEkle() {
        waitBySeconds(2);
        tikla(urunEkle);
    }
    public void sepetGit() {
        waitBySeconds(2);
        tikla(sepetGoruntule);
    }
    public void sepetOnay(){
        tikla(sepetiOnayla);
    }
}
