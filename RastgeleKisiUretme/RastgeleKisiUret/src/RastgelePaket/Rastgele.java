/**
* @author Özge Çinko - ozge.cinko@ogr.sakarya.edu.tr
* @since 15.04.2020
* <p>
* Rastgele sınıfının Rastgele(int) constructor'ı hangi aralıkta sayı üretileceğini belirliyor.
* Rastgele sınıfının nextInt() metodu ise belirlenen aralıkta herhangi bir sayı üretiyor.
* </p>
*/
package RastgelePaket;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public class Rastgele {
    
    private int limit;
    private int rastgele;
    
    // 0-limit aralıktaki değeri alacak olan constructor.
    public Rastgele(int limit){
        this.limit = limit;
        long gecenSure = System.currentTimeMillis(); 
        rastgele = (int) (gecenSure % limit);
    }

    // Yukarıda değer aralığını belirledikten sonra burada aralarından herhangi birisini seçmesini sağlayacağınız.
    public int nextInt(){
        rastgele = (rastgele * 32719 + 3) % 32749;
        return rastgele % limit;
    }
}
