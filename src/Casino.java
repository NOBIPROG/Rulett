import java.util.ArrayList;

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

    public void fillUpCasino() {

    }

    public void play() {
        for (Person value : people) {
            value.bet(rulett);
        }
        int winnerNr = rulett.getActualNr();
        if (rulett.getResults().get("red").equals(winnerNr)) {
            System.out.println("Piros" + winnerNr);
        } else if (rulett.getResults().get("red").equals(winnerNr)) {
            System.out.println("Fekete" + winnerNr);
        } else {
            System.out.println(winnerNr);
        }

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
    }
}