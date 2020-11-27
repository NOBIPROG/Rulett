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
        for (Person value:people){
            value.bet(rulett);
        }
        int winnerNr = rulett.getNr();
for (Person person: people){
    switch (winnerNr){
        case 0:
            for (Person person1:people){
                if (person1.getChosenCombination().equals("0")){
                    rulett.numberWin(person1);
                    break;
                }
            }
        case 1:

                if (person.getChosenCombination().equals("red")){
                    rulett.redWin(person);
                }else if (person.getChosenCombination().equals("odd")){
                    rulett.oddWin(person);
                }else if(person.getChosenCombination().equals("firstThird")){

            }

    }
}
    }
}
