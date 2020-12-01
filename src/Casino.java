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

        for (int i = 0; i < number; i++) {
            int random = (int)(Math.random()*7);
            int randomValet = (int)((Math.random()*4000000)+100) ;
            switch (random) {
                case 0 -> people.add(new AlwaysRedPlayer("AlwaysRed " + i, randomValet));
                case 1 -> people.add(new BravePlayer("Brave " + i, randomValet));
                case 2 -> people.add(new ConservationPlayer("Conservation " + i, randomValet));
                case 3 -> people.add(new FullRandomPlayer("FullRandom " + i, randomValet));
                case 4 -> people.add(new NowItWillTheAnotherColorPlayer("AnotherColor " + i, randomValet));
                case 5 -> people.add(new RandomColorPlayer("RandomColor " + i, randomValet));
                case 6 -> people.add(new SpecialCountPlayer("SpecialCount " + i, randomValet));
            }

        }

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
                       // if (person.getChosenCombination().getBetOptions().equals(betOptions.NUMBER) && person.getChosenCombination().getChosenNumber() == winnerNr) {
                         //   rulett.numberWin(person);
                       // }
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
                            case NUMBER -> {
                                if (person.getChosenCombination().getChosenNumber()==winnerNr) {
                                    rulett.numberWin(person);
                                }else {
                                    person.setWasWin(false);
                                }
                            }
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