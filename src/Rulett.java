import java.util.ArrayList;
import java.util.TreeMap;

public class Rulett {

    private int nr;
    private int round;

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

    public void red(int bet,Person p){

    }
    public void black(){

    }
    public void even(){

    }
    public void odd(){

    }
    public void number(){

    }
    public void numbersbetwen1and18(){

    }
    public void numbersbetwen19an36(){

    }
    public void firstThird(){

    }
    public void secondThird(){

    }
    public void thirdThird(){

    }
    public void getActualNr(){
        nr = (int)(Math.random()*36);
        round++;
    }
}
