/**
* @author Özge Çinko ve ozge.cinko@ogr.sakarya.edu.tr
* @since 18.04.2020
* <p>
* Kişinin TC Kimlik numarası kuralına göre burada rastgele oluşturulacak.
* Kişinin TC Kimlik numarasının kontrolü burada yapılacak.
* </p>
*/
package RastgelePaket;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public class KimlikNo {
    
    private String KimlikNumarasi = "";
    Rastgele rastgeleRakam = new Rastgele(9);
    
    public String KimlikNo() {
        KimlikNumarasi = "";
        int TcDizi[] = new int[11]; 
        int sonHaneyiBul = 0;
        
        for (int hane = 0; hane < 11; hane++) {
            // TC Kimlik numarasının ilk hanesi (dizide 0. index) 0 olamaz. 
            // Sayı rastgele geleceği için 0 olma durumuna 1 ekledim.
            if (hane == 0) {
                TcDizi[hane] = rastgeleRakam.nextInt() + 1;
            // TC Kimlik numarasında son haneye kadar (dizide 10. index) bütün haneler rastgele bir sayı olabilir.
            } else if (hane < 10) {
                TcDizi[hane] = rastgeleRakam.nextInt();
            }
        }
        
        // 10. hanenin kuralını sağlamak için 
        // [0. indexten itibaren çift indexler)*7 - (1. indexten itibaren tek indexler)] işleminin
        // modunu aldım, oluşan sonucu 10. haneye atadım.
        TcDizi[9] = (((TcDizi[0] + TcDizi[2] + TcDizi[4] + TcDizi[6] + TcDizi[8]) * 7) - (TcDizi[1] + TcDizi[3] + TcDizi[5] + TcDizi[7])) % 10;
        
        // Son haneyi bulmak için ilk 10 haneyi bir döngüde topladım.
        // Son hanenin kuralı = bütün hanelerin toplamını % 10.
        for (int i = 0; i <= 9; i++) {
            sonHaneyiBul += TcDizi[i];
        }
        
        // sonHaneyiBul'un modunu aldım ve son haneyi de atadım.
        TcDizi[10] = sonHaneyiBul % 10;
        
        // 11 haneli tc kimlik numarasını tek stringte toplayacak döngüyü yazdım.
        for (int a = 0; a < 11; a++) {
            KimlikNumarasi += TcDizi[a];
        }
        
        return KimlikNumarasi;
    }
    
    
    public boolean KimlikNoKontrol(String Tc) {
        if (Tc.length() != 11) {
            return false;
        }

        // Kontrol edebilmek için TC kimlik numarasındaki sayıları teker teker integer türünde diziye atadım.
        int TcDizi[] = new int[Tc.length()];
        for (int i = 0; i < Tc.length(); i++) {
            TcDizi[i] = Integer.parseInt(Tc.substring(i, i + 1));
        }

        int Hane10, Hane11, elemanlar = 0;

        // 10. hanenin kuralını yazdım.
        // 11. hane kuralı için dizinin bütün elemanlarını for döngüsünde topladım.
        Hane10 = ((TcDizi[0] + TcDizi[2] + TcDizi[4] + TcDizi[6] + TcDizi[8]) * 7 - (TcDizi[1] + TcDizi[3] + TcDizi[5] + TcDizi[7])) % 10;
        for (int i = 0; i <= 9; i++) {
            elemanlar += TcDizi[i];
        }
        
        // 11. hanenin kuralını yazdım.
        Hane11 = elemanlar % 10;
        
        // Eğer dizideki 10. eleman ve 11. eleman kuralı sağlıyorsa TC geçerlidir.
        if (TcDizi[9] == Hane10 && TcDizi[10] == Hane11) {
            return true;
        } else {
            return false;
        }
    }
    
}
