import java.util.*;
public class CustomComparator implements Comparator<Saint> {
    @Override
    public int compare(Saint saint1, Saint saint2) {
        Double vida1 = (Double)saint1.getVida();
        Double vida2 = (Double)saint2.getVida();
        return vida1.compareTo(vida2);
    }
    
}