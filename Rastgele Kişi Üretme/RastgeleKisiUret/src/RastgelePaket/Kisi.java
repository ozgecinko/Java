/**
* @author Özge Çinko - ozge.cinko@ogr.sakarya.edu.tr
* @since 20.04.2020
* <p>
* Kişi kimlik numarası, adı soyadı, yaşı, telefonu ve imei numarasıyla birlikte burada oluşturuluyor.
* </p>
*/
package RastgelePaket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author ÖZGE ÇİNKO
 */
public class Kisi {
    
    private final RastgeleKisi Kisi = new RastgeleKisi();
    private final Yas yas = new Yas();
    private final Telefon telefon = new Telefon();
    private final IMEINo Imei = new IMEINo();
    private final KimlikNo Kimlik = new KimlikNo();


    public void KisiUret(int kisiSayisi, File file) throws FileNotFoundException, IOException {  
      for (int i = 0; i < kisiSayisi; i++) {

            String Kayit = Kimlik.KimlikNo() + " " + Kisi.RandomKisi() + " " + yas.Yas() + " " + telefon.Telefon() + " " + "(" +Imei.IMEINo() + ")";
       
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(Kayit);
            bWriter.newLine();
            bWriter.close();
        }
        System.out.println("Rastgele kişiler dosyanın içerisinde üretildi.");

    }
    
    public void DosyadanKontrolEt(String fileName) throws FileNotFoundException, IOException {

        KimlikNo Tckontrol = new KimlikNo();
        IMEINo imeiKontrol = new IMEINo();
        
        FileReader fileReader = new FileReader(fileName);
        String line;

        try (BufferedReader okuma = new BufferedReader(fileReader)) {
            int GecerliTc = 0, GecersizTc = 0;
            int GecerliImei = 0, GecersizImei = 0;
            while ((line = okuma.readLine()) != null) {

                String[] Sutunlar = line.split(" ");
                
                // 0. sütun TC, 1. sütun isim, 2. sütun soyisim, 3. sütun yaş, 4. sütun telefon, 5. sütun IMEI.
                if(Tckontrol.KimlikNoKontrol(Sutunlar[0]))
                    GecerliTc++;
                else if(!Tckontrol.KimlikNoKontrol(Sutunlar[0]))
                    GecersizTc++;
                
                // 5. sütunun ilk kısmını okumuyorum çünkü orada parantez var.
                if(imeiKontrol.IMEINoKontrol(Sutunlar[5].substring(1, Sutunlar[5].length() - 1)))
                    GecerliImei++;
                else if(!imeiKontrol.IMEINoKontrol(Sutunlar[5].substring(1, Sutunlar[5].length() - 1)))
                    GecersizImei++;          
            }
            
            System.out.println("\nT.C Kimlik Kontrol\n" + GecerliTc + " Geçerli\n" + GecersizTc + " Geçersiz");
            System.out.println("\nIMEI Kontrol\n" + GecerliImei + " Geçerli\n" + GecersizImei + " Geçersiz");

        }
    }
}
