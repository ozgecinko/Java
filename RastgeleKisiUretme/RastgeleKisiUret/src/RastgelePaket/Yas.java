/**
* @author Özge Çinko ve ozge.cinko@ogr.sakarya.edu.tr
* @since 15.04.2020
* <p>
* Rastgele yaş oluşturmak için de sınıf oluşturdum.
* </p>
*/
package RastgelePaket;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public class Yas {
    
    public int Yas()
    {
        Rastgele rastgeleYas = new Rastgele(100);
        return rastgeleYas.nextInt();    
    }
}
