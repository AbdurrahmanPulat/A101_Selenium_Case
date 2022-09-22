# A101_Selenium_Case
# Hedef
Hedef A101 online alışveriş sayfasında sipariş oluşturmak.

## Video

https://use

https://user-images.githubusercontent.com/57863133/191795880-9db4c09c-67da-4576-bfff-d92616c46033.mp4


# Selenium



Selenium, web uygulamaları için taşınabilir bir yazılım test çerçevesidir. Ayrıca Java, C#, Groovy, Perl, PHP, Python ve Ruby dahil olmak üzere bir dizi popüler programlama dilinde testler yazmak için test alanına özgü bir dil sağlar.

  * [PageObjects Kalıbı Kullanımı](#use-pageobjects-pattern)
  * [Video](#Video)
  * [Senaryo](#Senaryo)
  * [TestClass](#TesClass)
  * [log4j](#log4j)
  * [TestResultLogger](#TestResultLogger)
  
 
## PageObjects Kalıbı Kullanımı

Sayfa Nesnesi, test bakımını geliştirmek ve kod tekrarını azaltmak için test otomasyonunda popüler hale gelen bir Tasarım Modelidir. Sayfa nesnesi modelinin bir uygulaması, test nesnesinin soyutlaması ile test komut dosyalarının ayrılmasıyla gerçekleştirilebilir.

**Sayfa Nesne Kalıbını kullanmanın avantajları:**
* Bakımı kolay
* Komut dosyalarının Kolay Okunabilirliği
* Yinelemeyi Azaltın veya Ortadan Kaldırın
* Kodun yeniden kullanılabilirliği
* Güvenilirlik
* Test kodu ile yer belirleyiciler ve düzen gibi sayfaya özel kodlar arasında net bir ayrım vardır.

## Senaryo
Uçtan uca ödeme ekranına kadar Selenium’da java dili ile chrome browser kullanarak test otomasyonuyapılacak.

- Senaryoya üye kaydı oluşturmadan devam edilecek.
- Giyim--> Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir.
- Açılan ürünün siyah olduğu doğrulanır.
- Sepete ekle butonuna tıklanır.
- Sepeti Görüntüle butonuna tıklanır.
- Sepeti Onayla butonuna tıklanır.
- Üye olmadan devam et butonuna tıklanır.
- Mail ekranı gelir.
- Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.
- Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği ,doğru ekrana yönlendiklerini kontrol edilecek.


## Test Class

```java
public class A101SiparisOlustur extends BaseTest {

    AnaSayfa anaSayfa;
    UrunSayfasi urunSayfasi;
    UrunDetaySayfasi urunDetaySayfasi;
    UyeIslemleriSayfasi uyeIslemleriSayfasi;
    AdresSayfasi adresSayfasi;

    @Test
    @Order(1)
    public void urunuBul(){
        anaSayfa = new AnaSayfa(driver);
        urunSayfasi = new UrunSayfasi(driver);
        anaSayfa.setCerezleriKabulEt();
        anaSayfa.duraksa();
        Assertions.assertTrue(urunSayfasi.UrunSayfasiDogrulama(),
                "Ürün sayfasında değilsiniz");
    }
    @Test
    @Order(2)
    public void urunuSec(){
        urunSayfasi = new UrunSayfasi(driver);
        urunDetaySayfasi = new UrunDetaySayfasi(driver);
        urunSayfasi.UrunuSec();
        Assertions.assertTrue(urunDetaySayfasi.UrunDetaySayfasiDogrulama(),
                "Açılan ürün siyah değil");
    }
    @Test
    @Order(3)
    public void sepet(){
        urunDetaySayfasi = new UrunDetaySayfasi(driver);
        urunDetaySayfasi.sepeteEkle();
        urunDetaySayfasi.sepetGit();
        Assertions.assertTrue(urunSayfasi.UrunEklemeKontrol(),
                "Ürün sepete eklenmedi");
        urunDetaySayfasi.sepetOnay();
    }
    @Test
    @Order(4)
    public void emailOnay (){
        uyeIslemleriSayfasi = new UyeIslemleriSayfasi(driver);
        uyeIslemleriSayfasi.uye();
        uyeIslemleriSayfasi.mailKutusu("afdbf@gmail.com");
        Assertions.assertTrue(uyeIslemleriSayfasi.adresSayfasiDogrula(),
                "Adres sayfasında değilsiniz");
        adresSayfasi = new AdresSayfasi(driver);
        adresSayfasi.yeniAdresOlustur();
        adresSayfasi.BilgileriDoldur();
        adresSayfasi.BilgileriDoldur2();
        adresSayfasi.kaydetVeDevamEt();
        Assertions.assertTrue(adresSayfasi.odemeSayfasi(),
                "Ödeme sayfası bulunamadı");
    }

}
```


## log4j

```java

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {

    static Logger logger = Logger.getLogger(Log.class);

    public Log(){
        DOMConfigurator.configure("log4j.xml");
    }

    public void info(String message){
        logger.info(message);
    }

    public void warn(String message){
        logger.warn(message);
    }

    public void error(String message){
        logger.error(message);
    }

}
```

## TestResultLogger


```java


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestResultLogger implements TestWatcher {


    Log log = new Log();
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        TestWatcher.super.testDisabled(context, reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        TestWatcher.super.testSuccessful(context);
        String testName = context.getDisplayName();
        log.info(testName+"Başarılı");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testAborted(context, cause);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
        String testName = context.getDisplayName();
        String testFailCause = cause.getMessage();
        log.error(testName+"Başarısız oldu çünkü: "+ testFailCause);
    }
}

```
