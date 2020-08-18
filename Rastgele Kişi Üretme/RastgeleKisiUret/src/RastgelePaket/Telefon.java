/**
* @author Özge Çinko - ozge.cinko@ogr.sakarya.edu.tr
* @since 19.04.2020
* <p>
* Bu sınıfta Türkiye'deki alan kodlarına uyumlu olarak rastgele bir biçimde telefon numarası üretiliyor.
* Üretilen telefon numarasına uyumlu IMEI numarası bu sınıfta kontrol ediliyor.
* </p>
*/
package RastgelePaket;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public class Telefon {
    private final Rastgele rastgeleRakam = new Rastgele(9);
    private final Rastgele rastgeleIki = new Rastgele(5);
    private String TelNumarasi = "";

    
    public String Telefon() {
        TelNumarasi = "";
        int telefonNo[] = new int[11]; 
        /*
        Telefon numarası için ele aldığım liste:
        
        Mobil Operatör	Alan Kodu
        Türk Telekom	501, 505, 506, 507, 551 (BİMcell sanal operatörü), 552, 553, 554, 555, 559
        Turkcell	530, 531, 532, 533, 534, 535, 536, 537, 538, 539
        Vodafone	540, 541, 542, 543, 544, 545, 546, 547, 548, 549
        */

        telefonNo[0] = 0;
        telefonNo[1] = 5;
        
        // Öncelikle telefon numarasındaki 3. sayıyı (0-5) aralığında olmak şartıyla rastgele ürettim.
        telefonNo[2] = rastgeleIki.nextInt();
        
        // Eğer telefon numarasındaki 3. sayı 0 ise 4. sayı 1,5,6 veya 7 olabilir.
        if(telefonNo[2] == 0)
        {
            int rastgeleBirRakam = rastgeleRakam.nextInt();
            if(rastgeleBirRakam == 1 || rastgeleBirRakam == 5 || rastgeleBirRakam == 6 || rastgeleBirRakam == 7 )
            {
                telefonNo[3] = rastgeleBirRakam;
            }
        }
        
        // Eğer telefon numarasındaki 3. sayı 1 ise bu durum düzeltilmelidir.
        // Bu durumu düzeltmek için +2 ekledim çünkü 3. sayı 1 ve 2 olamaz. 
        if(telefonNo[2] == 1)
        {
           telefonNo[2] = telefonNo[2] + 2;
        }
        // Eğer telefon numarasındaki 2. sayı 1 ise bu durum düzeltilmelidir.
        // Bu durumu düzeltmek için +1 ekledim. 
        if(telefonNo[2] == 2)
        {
            telefonNo[2] = telefonNo[2] + 1;
        }
        
        // Eğer telefon numarasındaki 3. sayı 3 ise 4. sayı herhangi bir rakam olabilir.
        if(telefonNo[2] == 3)
        {
            telefonNo[3] = rastgeleRakam.nextInt();
        }
        // Eğer telefon numarasındaki 3. sayı 4 ise 4. sayı herhangi bir rakam olabilir.
        if(telefonNo[2] == 4)
        {
            telefonNo[3] = rastgeleRakam.nextInt();
        }
           
        // Eğer telefon numarasındaki 3. sayı 5 ise 4. sayı 1,2,3,4,5 veya 9 olabilir.
        if(telefonNo[2] == 5)
        {
            int rastgeleBirRakam = rastgeleRakam.nextInt();
            if(rastgeleBirRakam == 1 || rastgeleBirRakam == 2 || rastgeleBirRakam == 3 || rastgeleBirRakam == 4 || rastgeleBirRakam == 5 || rastgeleBirRakam == 9 )
            {
               telefonNo[3] = rastgeleBirRakam;
            }
       }
          
        // İlk 4 sayıdan sonraki sayıların hepsi rastgele olabilir bu yüzden 5. sayıdan itibaren bir döngü kurdum.
        for (int i = 4; i < 11; i++) {
            telefonNo[i] = rastgeleRakam.nextInt();
        }
        
        // Elde edilen telefon numarasını String türünde bir değişkene atadım ve metotta elde edilen String'i döndürdüm.
        for (int i = 0; i < 11; i++) {
            TelNumarasi += telefonNo[i];
        }

        return TelNumarasi;
    }
    

}
