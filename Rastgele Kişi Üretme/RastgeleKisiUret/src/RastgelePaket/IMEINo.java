/**
* @author Özge Çinko ve ozge.cinko@ogr.sakarya.edu.tr
* @since 19.04.2020
* <p>
* Kişinin IMEI numarası 15. yani son haneyi kontrol ederek rastgele oluşturulacaktır.
* Kişinin IMEI numarasının kontrolünde de son hanenin kuralı sağlayıp sağlamadığına bakacaktır.
* </p>
*/
package RastgelePaket;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public class IMEINo {
    private final Rastgele rastgeleRakam = new Rastgele(9);
    private String ImeiNumarasi = "";

    public String IMEINo() {
        ImeiNumarasi = "";
        int IMEIno[] = new int[15];
        int TekHaneler = 0;
        int CiftHaneler = 0;
        for (int i = 0; i < 14; i++) {
            IMEIno[i] = rastgeleRakam.nextInt();   
        }
        
        for (int i = 0; i <= 12; i+=2) {
               TekHaneler += IMEIno[i];
        }
        
        int islem=0;
        // Çift haneler için ayrı bir for döngüsü kullandım.
        for (int i = 1; i <= 13; i += 2) {
            islem=IMEIno[i] * 2;
            if (islem > 9) {
                CiftHaneler += islem - 9;
            } 
            CiftHaneler += islem;
        }
        
        islem = CiftHaneler + TekHaneler;
        int sonuc = 0;
        sonuc = (islem*9) % 10;
        IMEIno[14] = sonuc;

        for (int i = 0; i < 15; i++) {
            ImeiNumarasi += IMEIno[i];
        }
        return ImeiNumarasi;
    }

    
    public boolean IMEINoKontrol(String Imei) {
        int Tek = 0;
        int Cift = 0;
        
        if (Imei.length() != 15) {
            return false;
        }

        // Kontrol edebilmek için Imei numarasındaki sayıları teker teker integer türünde diziye atadım.
        int ImeiDizi[] = new int[Imei.length()];
        for (int i = 0; i < Imei.length(); i++) {
            ImeiDizi[i] = Integer.parseInt(Imei.substring(i, i + 1));
        }

        // Çift indexli sayıları kurala göre topladım.
        for (int i = 0; i <= 12; i += 2) {
            Tek += ImeiDizi[i];
        }
        
        int islem=0;
        // Çift haneler için ayrı bir for döngüsü kullandım.
        for (int i = 1; i <= 13; i += 2) {
            islem=ImeiDizi[i] * 2;
            if (islem > 9) {
                Cift += islem - 9;
            } 
            Cift += islem;
        }
        
        islem = Cift + Tek;
        int sonuc = 0;
        sonuc = (islem*9) % 10;
        ImeiDizi[14] = sonuc;
        
        // Eğer son eleman kuralı sağlıyorsa IMEI numarası geçerlidir.
        // Sağlamıyorsa geçersizdir.
        if(ImeiDizi[14] == sonuc)
        {
            return true;
        }
        else
            return false;
    }

}
