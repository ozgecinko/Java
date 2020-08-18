/* 
*
* Akıllı Cihaz isimli bu sınıf aslında sistemdeki ağ arayüzünü temsil ediyor.
* Kullanıcılar buradan giriş yapıyor.
* Giriş yaptıktan sonra işlemler burada seçiliyor.
*
*/

package akillicihaz;

import java.util.Scanner;

/**
 *
 * @author ÖZGE ÇİNKO
 */

public class AkilliCihaz {

    public static void Islemler(String userName)
    {
        MerkeziIslemBirimi merkezi = new MerkeziIslemBirimi();
            
            Scanner scan = new Scanner(System.in);  
            int sec=0;
            do{
                System.out.println("1- Sicaklik Gonder");
                System.out.println("2- Sogutucuyu Ac");
                System.out.println("3- Sogutucuyu Kapat");
                System.out.println("4- Cikis Yap");
                sec = scan.nextInt();
                	
		switch(sec){
			case 1:
                            merkezi.SicaklikGonder(userName);
			break;
			case 2:
                            merkezi.SoguklukAc();
			break;
                        case 3:
                            merkezi.SoguklukKapa();
			break;
                        case 4:
                            System.out.println("Sistemden cikis yapildi.");
			break;
                        default:
                            System.out.println("Yanlis bir secim, tekrar deneyin...");
                        break;
		}
	}while(sec != 4);
    }
    
    public static void main(String[] args){    

        KullaniciKontrol kontrol = new KullaniciKontrol();

        Scanner input = new Scanner(System.in);
        Scanner sifre = new Scanner(System.in);

        System.out.print("Kullanici Adi:");
        String userName = input.nextLine();
        System.out.print("Sifre:");
        String password = sifre.nextLine();

        
        
        kontrol.KullanicilariKontrolEt(userName, password);
        // Eğer kullanıcı adı ve şifre doğruysa sisteme giriş yapar.
        if( kontrol.KullaniciAdiniKontrolEt(userName) == true && kontrol.SifreKontrolEt(password) == true)
        {
            Islemler(userName);
        }
        
    }
}