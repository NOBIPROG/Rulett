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

    public void redWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));
    }

    public void blackWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));
    }

    public void evenWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));
    }

    public void oddWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));
    }

    public void numberWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 36));
    }

    public void numbersbetwen1and18Win(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));

    }

    public void numbersbetwen19an36Win(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));
    }

    public void firstThirdWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
    }

    public void secondThirdWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));

    }

    public void thirdThirdWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));

    }

    public void line1(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
    }

    public void line2(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
    }

    public void line3(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
    }

}
