package Services;
import java.util.Random;

public class RollService {
    public static int roll(){
        return new Random().nextInt(6) + 1;
    }
}
