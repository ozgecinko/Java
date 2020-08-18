package akillicihaz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public class Eyleyici implements Subject{
    
   private List<Observer> subscribers = new ArrayList<>();
       
    @Override
    public void attach(Observer o)
    {
        subscribers.add(o);
    }
    
    @Override
    public void detach(Observer o)
    {
        subscribers.remove(o);
    }
   
    @Override
    public void notify(String message)
    {
        for(Observer subscriber: subscribers) {
                subscriber.update(message);
        }
    }
}

