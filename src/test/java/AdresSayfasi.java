import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class AdresSayfasi extends BasePage {
    public AdresSayfasi(WebDriver driver) {
        super(driver);
    }

    By adresButon = By.xpath("//div[@class='addresses']/div[@class='list']//a[contains(.,'Yeni adres oluştur')]");

    WebElement adresBasligi = driver.findElement(By.xpath("//input[@name='title']"));

    By kaydetDevam = By.xpath("//button[@class='button block green js-proceed-button']");
    By devam = By.xpath("//button[@class='button green js-set-country js-prevent-emoji']");

    By sehir =By.xpath("//select[@name=\"city\"]");

    By ilce = By.cssSelector("[name='township']");//span[contains(.,'Sendeo')]
    By mahalle = By.cssSelector("[name='district']");

    By adres = By.xpath("//textarea[@name='line']");

    By kargo = By.cssSelector(".js-checkout-cargo-item .radio");

    By odeme = By.xpath("//span[.='2. ÖDEME SEÇENEKLERİ']");



    public void yeniAdresOlustur() {
        tikla(adresButon);
     }

    public void BilgileriDoldur() {
        Actions actions = new Actions(driver);
        actions.click(adresBasligi)
                .sendKeys("Ev")
                .sendKeys(Keys.TAB)
                .sendKeys("Abdurrahman")
                .sendKeys(Keys.TAB)
                .sendKeys("PÜLAT")
                .sendKeys(Keys.TAB)
                .sendKeys("5555555555").perform();

    }
    public void BilgileriDoldur2() {

        String karakter ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String rastgeleAdres= "";
        int uzunluk = 15;
        Random rand = new Random();
        char [] text = new char[uzunluk];

        for (int i = 0; i< uzunluk;i++){
            text[i] = karakter.charAt(rand.nextInt(karakter.length()));

        }
        for (int i = 0; i<text.length; i++){
            rastgeleAdres += text[i];
        }
        yaz(sehir,"ANKARA");
        waitBySeconds(1);

        yaz(ilce,"AKYURT");
        waitBySeconds(1);
        yaz(mahalle,"ATATÜRK");
        yaz(adres,rastgeleAdres);

    }

    public void kaydetVeDevamEt() {
         tikla(devam);


         waitBySeconds(2);
         tikla(kargo);
         tikla(kaydetDevam);
    }

    public boolean odemeSayfasi(){
        return isDisplayed(odeme);
    }


}
