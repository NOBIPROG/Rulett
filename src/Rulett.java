import java.util.ArrayList;
import java.util.TreeMap;

public class Rulett {

    private TreeMap<String, ArrayList<Integer>> fields;
    private int round;

    public TreeMap<String, ArrayList<Integer>> getFields() {
        return fields;
    }

    public void setFields(TreeMap<String, ArrayList<Integer>> fields) {
        this.fields = fields;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
