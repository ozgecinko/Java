package akillicihaz;

import java.util.Random;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public class SicaklikOku implements SicaklikAlgilayici {
    
    private Random random;
    private int measure;
    
    public SicaklikOku(){
        this.random = new Random();
        this.measure = random.nextInt(40 - (-20) + -20);
    }
    
    @Override
    public int sicakligiOku(){

        return measure;
    }
    public void sicaklikUpdate(int temp) {
      this.measure = temp;
    }
}
