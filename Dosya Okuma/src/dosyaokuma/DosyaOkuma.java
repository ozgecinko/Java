/**
*
* @author Özge Çinko ozge.cinko@ogr.sakarya.edu.tr
* @since 26 Şubat 2020
* <p>
* Programı yazmaya 26 Şubat 2020 tarihinde başladım. 6 Mart 2020 tarihinde bitirdim.
* </p>
* 
*/
package dosyaokuma;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DosyaOkuma{

    
    // Sesli harfleri sayan metot.
     public static int sesliHarfSay(String text)
     {
        int sesliSayisi=0;
        
       if (text == null || text.isEmpty()) 
       {
           return 0;
       }
        // Bu döngüyle dosyada yazılan her karakteri dolaşıyoruz.
        for (int i = 0; i < text.length(); i++)
        {
            // Eğer karakter a,e,ı,i,o,ö,u,ü,A,E,I,İ,O,Ö,U,Ü ise sesli harftir.
            if(text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'ı' || text.charAt(i) == 'i' ||
                text.charAt(i) == 'o' || text.charAt(i) == 'ö' || text.charAt(i) == 'u' || text.charAt(i) == 'ü' ||
                 text.charAt(i) == 'A' || text.charAt(i) == 'E' || text.charAt(i) == 'I' || text.charAt(i) == 'İ' ||
                  text.charAt(i) == 'O' || text.charAt(i) == 'Ö' || text.charAt(i) == 'U' || text.charAt(i) == 'Ü')
            {
                sesliSayisi++;
            }
        }
        return sesliSayisi;  
     }

     // Kelime sayan metot.
     public static int kelimeSay(String text) 
     {
       if (text == null || text.isEmpty()) 
       {
           return 0;
       }

        String[] kelimeler = text.split("\\s+");
        return kelimeler.length;
    }
     
    // Cümle sayan metot.
    public static int cumleSay(String text)
    {
        if (text == null || text.isEmpty()) 
        {
           return 0;
        }
       
        int cumleSayisi=0;
        
        // Önce text dosyasındaki kelimeleri ayırdım.
        String[] kelimeler = text.split("\\s+");
         
        // Sonra kelimeleri teker teker for döngüsünde dolaştım.
        for(int i=0;i<kelimeler.length;i++)
        {
            String kelime = kelimeler[i];
            
            // Eğer kelime "." ya da "!" ya da "?" ya da "..." ile bitiyorsa bu ifade cümleyi temsil eder.
            if(kelime.endsWith(".") || kelime.endsWith("!") || kelime.endsWith("?") || kelime.endsWith("..."))
            {
                cumleSayisi++;
            }
        }
         return cumleSayisi;
    }
            
    // Mail sayan metot.
    public static int mailSay(String text)
    {          
        if (text == null || text.isEmpty()) 
        {
           return 0;
        }
       
        int mailSayisi = 0;
        
        // Aşağıdaki kuralara göre bir mail adresi a'dan z'ye, A'dan Z'ye harfler içerebilir 0'dan 9'a rakamlar içerebilir.
        // Mail adresinde @ ifadesi ortada bulunmalıdır. 
        String mail = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";
        Matcher mailAdresi = Pattern.compile(mail).matcher(text);
        while (mailAdresi.find()) 
        {
            mailSayisi++;
        }
        return mailSayisi;
    }	

    // Site sayan metot.
    public static int siteSay(String text)
    {   
        int siteSayisi=0;
        if (text == null || text.isEmpty()) 
        {
           return 0;
        }
        
        // Regex yöntemiyle web için bir kural oluşturdum. Aşağıdaki kurala göre web adresi https, www uzantıları içerebilir.
        // Web adresinin alan adı a'dan z'ye karakterlerden oluşmalıdır.
        // Web adresinin sonu .com,.edu,.net,.org, .com.tr, .net.tr, .edu.tr, .org.tr ifadelerinden herhangi biri ile bitmelidir.
        String web = "(https?:\\/\\/)?(www\\.)?(?:^|[^@\\.\\w-])([\\w]+\\.)+(com|edu|net|org)+(\\.(tr))?";
        Matcher m = Pattern.compile(web).matcher(text);
            
        while (m.find()) 
        {
            siteSayisi++;
        }
           
        return siteSayisi;
    }	

    public static void main(String[] args){
        
        String data = ""; 
        try 
        { 
            // Text dosyasındaki bütün karakterleri okumasını istediğim için böyle yaptım.
            // Bu işleme göre text dosyasında bulunan bütün karakterler String türüne dönüşecek.
            // icerik.txt'in proje dosyasında bulunması gerekiyor.
            data = new String(Files.readAllBytes(Paths.get("icerik.txt"))); 
            
            //icerik.txt dosyasını konsola yazdıran işlem.
            System.out.println(data);
            
            System.out.println("Toplam Sesli Harf Sayısı:" + sesliHarfSay(data));
            System.out.println("Toplam Kelime Sayısı: " + kelimeSay(data));
            System.out.println("Toplam Cümle Sayısı: "+ cumleSay(data));
            System.out.println("Toplam Mail Sayısı: " + mailSay(data));
            System.out.println("Toplam Website Sayısı: " + siteSay(data));

        } 
        
        
        catch (Exception e)
        { 
            e.printStackTrace(); 
        }




    }
    
}
