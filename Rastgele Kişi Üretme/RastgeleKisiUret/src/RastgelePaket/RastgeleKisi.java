/**
* @author Özge Çinko - ozge.cinko@ogr.sakarya.edu.tr
* @since 15.04.2020
* <p>
* Bu sınıfta random_isimler.txt dosyasından veri çekiliyor ve çekilen veriler bir diziye atanıyor.
* Atanan dizideki verilerden herhangi birisi Rastgele sınıfı yardımıyla rastgele olarak seçiliyor.
* </p>
*/

package RastgelePaket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author ÖZGE ÇİNKO
 */
public class RastgeleKisi {

    public String RandomKisi() throws IOException
    { 
        // random_isimler.txt dosyasını alıyorum.
        File f = new File("random_isimler.txt");

        // BufferedReader (yani dosyayı satır satır okumaya yarayan yöntem) ile dosyayı okuyorum.
        BufferedReader br = new BufferedReader(new FileReader(f));
        
        // br.readLine()'ı eşitlemek için str adında string oluşturdum.
        String str = null;
        
        // random_isimler.txt dosyasındaki isimleri lines adında oluşturduğum ArrayList'e atadım.
        ArrayList<String> lines = new ArrayList<String>();
        while((str=br.readLine())!= null)
        {
            lines.add(str);
        }
        // linesArray adında, oluşturduğum ArrayList'in boyutunda bir dizi oluşturdum ve ArrayList'teki isimleri diziye atadım.
        String[] linesArray = lines.toArray(new String[lines.size()]);

        // Kendi oluşturduğum Rastgele sınıfını kullanarak diziden rastgele bir satır çektim ve o satırı metotta döndürdüm.
        Rastgele rastgeleIndex = new Rastgele(linesArray.length);
       return linesArray[rastgeleIndex.nextInt()];
    }
    

}
