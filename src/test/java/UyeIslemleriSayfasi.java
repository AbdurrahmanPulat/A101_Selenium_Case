import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UyeIslemleriSayfasi extends BasePage {

    By uyeOlmadanDevam= By.cssSelector(".auth__form__proceed");

    By eMail = By.xpath("//input[@name='user_email']");

    By devam = By.xpath("//button[@class='button block green']");

    By adresDogrula = By.xpath("//span[.='1. ADRES & KARGO  BİLGİLERİ']");
    

    public UyeIslemleriSayfasi(WebDriver driver) {
        super(driver);
    }

    public void mailKutusu(String s) {
        yaz(eMail,s);
        tikla(devam);
    }


    public void uye() {
        tikla(uyeOlmadanDevam);

    }

    public Boolean adresSayfasiDogrula(){

        return isDisplayed(adresDogrula);
    }
}

