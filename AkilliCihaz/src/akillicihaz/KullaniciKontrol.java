package akillicihaz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public class KullaniciKontrol {
            
    ArrayList<String> kullanicilar = new ArrayList<String>();
    ArrayList<String> sifreler = new ArrayList<String>();
       
    public void KullanicilariKontrolEt(String userName, String password)
    {
        Statement stmt = null;
        try {
           VeritabaniBaglantisi instance = VeritabaniBaglantisi.nesneOlustur();
           Connection c = VeritabaniBaglantisi.baglantiyiKur();
           
           stmt = c.createStatement();
           ResultSet rs = stmt.executeQuery( "select * from kullanicilar" );
           while ( rs.next() ) {
               
              String kullaniciAdi = rs.getString("KullaniciAdi");
              kullanicilar.add(kullaniciAdi);
              String  sifre = rs.getString("Sifre");
              sifreler.add(sifre);
           }
        } catch ( Exception e ) {
           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
           System.exit(0);

        }
    }
    
    public Boolean KullaniciAdiniKontrolEt(String userName)
    {             
        if(kullanicilar.contains(userName))
        {   
            return true;
        }
        else
        {
           System.out.println("Gecerli bir kullanici giriniz.");
           return false;
        }
    } 
    
    public Boolean SifreKontrolEt(String password)
    {             
        if(sifreler.contains(password))
        {   
            return true;
        }
        else
        {
           System.out.println("Gecerli bir sifre giriniz.");
           return false;
        }
    } 
}
