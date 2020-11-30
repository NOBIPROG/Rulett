import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Rulett {

    private int nr;
    private int round;
    private int minBet;
    private int maxBet;
    private HashMap <String,Integer> results;

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
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


    public void line1Win(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
    }

    public void line2Win(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
    }

    public void line3Win(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
    }

    public int getMinBet() {
        return minBet;
    }

    public int getMaxBet() {
        return maxBet;
    }

    public HashMap<String, Integer> getResults() {
        return results;
    }

    public void getActualNr(){
        nr = (int)(Math.random()*36);
        round++;
        switch (nr) {
            case 0 -> {
                results.putIfAbsent("green", 0);
                results.put("green", results.get("green") + 1);
            }
            case 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 -> {
                results.putIfAbsent("red", 0);
                results.put("red", results.get("red") + 1);
            }
            case 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 -> {
                results.putIfAbsent("black", 0);
                results.put("black", results.get("black") + 1);
            }
        }
    }
}
