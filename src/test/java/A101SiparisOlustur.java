import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


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
