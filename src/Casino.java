import java.util.ArrayList;

public class Casino {

    private ArrayList<Person> people;
    private Rulett rulett;
    private int income;

    public Casino() {
        people = new ArrayList<>();
        rulett = new Rulett();
    }

    public void fillUpCasino(){
        people.add(new Person("Martingél Béla",1000,"red"));
    }

    public void play(){
        int winnerNr = rulett.getNr();

    }
}
