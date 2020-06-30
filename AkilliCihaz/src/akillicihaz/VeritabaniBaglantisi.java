// Singleton tasarım kalıbıyla yapılan VeritabaniBaglantisi.
package akillicihaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public class VeritabaniBaglantisi {
    // Nesnemizin daha önceden oluşturulmadığını anlayabilmemiz için statik instance özelliği tanımlıyoruz.
    private static VeritabaniBaglantisi instance;
    private static Connection baglanti;
    
    //Sınıfımızın construct (kurucu) metodunu private yada protected tanımlıyoruz.
    private VeritabaniBaglantisi() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.baglanti = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Kullanici", "postgres", "bjkarena");
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
}
    
     // Dışarıdan sınıfımızı çağıracağımız (yani bir nevi constructor'ımız sayılacak) metod.
    public static VeritabaniBaglantisi nesneOlustur() throws SQLException
    {
        // Eğer daha önce örnek oluşturulmamış ise sınıfın tek örneğini oluşturan koşul.
        if(instance == null)
        {
            instance  = new VeritabaniBaglantisi();
        }
        else if(instance.baglantiyiKur().isClosed())
        {       
            instance = new VeritabaniBaglantisi();
        }
        return instance;
    } 
    
    // Veritabanıyla bağlantıyı kuran metot.
    public static Connection baglantiyiKur() {
        return baglanti;
    }
}
