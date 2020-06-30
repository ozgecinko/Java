package akillicihaz;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public class SogutucuOku implements Observer{
    private int temp;
    private boolean sogutucu;
    public int SogutucuAcik(boolean sogutucu, int sicaklik)
    {
        this.sogutucu = sogutucu;
        sicaklik -= 2;
        this.temp = sicaklik;
        return this.temp;
    }
    public void SogutucuKapali(boolean sogutucu)
    {
        this.sogutucu = sogutucu;
    }
    
    @Override
    public void update(String message)
    {
        if(this.sogutucu == true) 
        {
            message = "Sogutucu acik.";
        }
        
        else message = "Sogutucu kapali.";
        
        System.out.println(message);
    }
}
