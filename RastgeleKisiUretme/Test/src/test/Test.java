/**
* @author Özge Çinko - ozge.cinko@ogr.sakarya.edu.tr
* @since 15.04.2020
* <p>
* Bu programda RastgelePaket aracılığıyla rastgele kişiler üretiliyor ve üretilen kişilerin kimlik numarası, imei numarası kontrol ediliyor.
* </p>
*/
package test;

import RastgelePaket.Kisi;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public class Test {


    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);     
        Kisi kisi = new Kisi();   
        
        // Yeni bir dosya oluşturuyoruz.
        File file = new File("Kisiler.txt");
        String fileName = "Kisiler.txt";
        try {

	int sec=0;
        int kisiSayisi = 0;
	do{
                System.out.println("1- Rastgele Kişi Üret");
                System.out.println("2- Üretilmiş Dosya Kontrol Et");
                System.out.println("3- Çıkış");
                sec = scan.nextInt();
                	
		switch(sec){
			case 1:
                            System.out.println("Kaç Kişi Üretilsin?");
                            kisiSayisi = scan.nextInt();
                            kisi.KisiUret(kisiSayisi, file);
			break;
			case 2:
                            kisi.DosyadanKontrolEt(fileName);
			break;
                        case 3:
                            System.out.println("Çıkış yapıldı...");
			break;
                        default:
                            System.out.println("Yanlış bir seçeneği seçtiniz, tekrar deneyin...");
                        break;
		}
	}while(sec != 3);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
