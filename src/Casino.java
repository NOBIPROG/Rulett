import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class Casino {

    private ArrayList<Person> people;
    private Rulett rulett;
    private int income;

    public Casino() {
        people = new ArrayList<>();
        rulett = new Rulett();
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public Rulett getRulett() {
        return rulett;
    }

    public int getIncome() {
        return income;
    }

    public void setRulett(Rulett rulett) {
        this.rulett = rulett;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void fillUpCasino(int number) {

    }

    public void play() {

            for (Person person : people) {
                if (person.getValet() > 0) {
                    person.bet(rulett);
                } else {
                    System.out.println("A " + person.getName() + " nevű játékosnak elfogyott a pénze így kiesett a játékból.");
                    getPeople().remove(person);
                    break;
                }
            }
            int winnerNr = rulett.getActualNr();
            if (rulett.getResults().get("red").equals(winnerNr)) {
                System.out.println("Aktuális nyerőszám: Piros " + winnerNr);
            } else if (rulett.getResults().get("black").equals(winnerNr)) {
                System.out.println("Aktuális nyerőszám: Fekete " + winnerNr);
            } else {
                System.out.println("Aktuális nyerőszám: Zöld " + winnerNr);
            }
            try {
                for (Person person : people) {
                    if (rulett.getNumbersSpecs().get(winnerNr).contains(person.getChosenCombination().getBetOptions())) {
                        if (person.getChosenCombination().getBetOptions().equals(betOptions.NUMBER) && person.getChosenCombination().getChosenNumber() == winnerNr) {
                            rulett.numberWin(person);
                        }
                        switch (person.getChosenCombination().getBetOptions()) {
                            case RED -> rulett.redWin(person);
                            case BLACK -> rulett.blackWin(person);
                            case EVEN -> rulett.evenWin(person);
                            case ODD -> rulett.oddWin(person);
                            case NUMBERSBETWEEN1AND18 -> rulett.numbersBetween1And18Win(person);
                            case NUMBERSBETWEEN19AND36 -> rulett.numbersBetween19And36Win(person);
                            case FIRSTTHIRD -> rulett.firstThirdWin(person);
                            case SECONDTHIRD -> rulett.secondThirdWin(person);
                            case THIRDTHIRD -> rulett.thirdThirdWin(person);
                            case LINE1 -> rulett.line1Win(person);
                            case LINE2 -> rulett.line2Win(person);
                            case LINE3 -> rulett.line3Win(person);
                        }
                    } else {
                        person.setWasWin(false);
                    }
            }

            }catch (ConcurrentModificationException | IndexOutOfBoundsException e){
                System.out.println("Minden játékosnak elfogyott a pénze.");
            }catch (NullPointerException ignored){

            }

    }
}