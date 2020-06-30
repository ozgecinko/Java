package akillicihaz;

/**
 *
 * @author ÖZGE ÇİNKO
 */

public class MerkeziIslemBirimi {
    SicaklikOku sicaklik = new SicaklikOku();
    Eyleyici eyleyici = new Eyleyici();
    SogutucuOku sogutucu = new SogutucuOku();
    private int temp;
    public MerkeziIslemBirimi() {
      eyleyici.attach(sogutucu);
    }
    
    // Merkezi işlem biriminden sıcaklık algılayıcı arayüzüne sıcaklık gönderen metot.
    public void SicaklikGonder(String userName)
    {  this.temp = sicaklik.sicakligiOku();
        System.out.println(userName + " suanki ortam sicakligi (C*) = " + this.temp);
    }
    
    // Merkezi işlem biriminden eyleyiciye soğutucu açma bildirimini gönderen metot.
    // Soğutucu açılınca sıcaklık azalır.
    public void SoguklukAc()
    {
       this.temp = sogutucu.SogutucuAcik(true,temp);
       sicaklik.sicaklikUpdate(temp);
       eyleyici.notify("Sogutucu acik.");
    }
    
    // Merkezi işlem biriminden eyleyiciye soğutucu kapama bildirimini gönderen metot.
    public void SoguklukKapa()
    {
      sogutucu.SogutucuKapali(false);
       eyleyici.notify("Sogucutu kapali.");
       
    }
}
