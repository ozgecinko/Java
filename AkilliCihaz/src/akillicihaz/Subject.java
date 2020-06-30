package akillicihaz;

/**
 *
 * @author ÖZGE ÇİNKO
 */
public interface Subject {
    public void attach(Observer o);
    public void detach(Observer o);
    public void notify(String m);
}
