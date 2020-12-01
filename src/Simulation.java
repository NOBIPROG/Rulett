import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Simulation {

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.doSimulation(100);
    }

 private    Casino casino;

    public Simulation() {
        casino = new Casino();
        casino.getRulett().setMinBet(100);
        casino.getRulett().setMaxBet(1000000);

    }

    public void doSimulation(int nrOfRound) {
        System.out.println("Kérlek válassz, hogy melyik stratégiájú játékost szeretnéd szimulálni: ");
        System.out.println("1. --> Martingel stratégia \n 2. --> Random-szín stratégia \n 3. --> Full random stratégia (véletlen tét, véletlen kombináció) \n 4. --> Konzervatív stratégia (legkisebb tét, mindig piros) \n 5. --> Bátor stratégia (legnagyobb tét, mindig piros) \n 6. --> Most már biztos a másik jön stratégia \n 7. --> 1-3-2-6 stratégia ");
        Scanner sc = new Scanner(System.in);
        Person person;
        int answer = 0;
        boolean isGoodAnswer = false;
        while (!isGoodAnswer){
            try {
                answer = sc.nextInt();
                isGoodAnswer = true;
                if (answer == 0 || answer > 7){
                    throw new TooBigNumberException();
                }
            }catch (InputMismatchException e){
                System.out.println("Nem számot adtál meg. Kérlek írj be egy számot a felsorolásból.");
                isGoodAnswer = false;
                sc = new Scanner(System.in);
            }catch (TooBigNumberException e){
                System.out.println("A felsorolásban nem szerepel ilyen számú stratégia. Kérlek a felsorolásból válassz.");
                isGoodAnswer = false;
                sc = new Scanner(System.in);
            }
        }
        switch (answer) {
            case 1 -> {
                System.out.println("A válaszott stratégia: Martingel. Játékos a következő adatokkal jön létre: \n Név: Mr. Martingel \n Kezdő tőke: 4.000.000 HUF");
                person = new AlwaysRedPlayer("Mr. Martingel", 4000000);
            }
            case 2 -> {
                System.out.println("A válaszott stratégia: Random-szín. Játékos a következő adatokkal jön létre: \n Név: Mr. Random \n Kezdő tőke: 4.000.000 HUF");
                person = new RandomColorPlayer("Mr. Random", 4000000);
            }
            case 3 -> {
                System.out.println("A válaszott stratégia: Full random. Játékos a következő adatokkal jön létre: \n Név: Mr. FullRandom \n Kezdő tőke: 4.000.000 HUF");
                person = new FullRandomPlayer("Mr. FullRandom", 4000000);
            }
            case 4 -> {
                System.out.println("A válaszott stratégia: Konzervatív. Játékos a következő adatokkal jön létre: \n Név: Mr. Conservation \n Kezdő tőke: 4.000.000 HUF");
                person = new ConservationPlayer("Mr. Conservation", 4000000);
            }
            case 5 -> {
                System.out.println("A válaszott stratégia: Bátor. Játékos a következő adatokkal jön létre: \n Név: Mr. Brave \n Kezdő tőke: 4.000.000 HUF");
                person = new BravePlayer("Mr. Brave", 4000000);
            }
            case 6 -> {
                System.out.println("A válaszott stratégia: Most már biztos a másik jön. Játékos a következő adatokkal jön létre: \n Név: Mr. AnotherColor \n Kezdő tőke: 4.000.000 HUF");
                person = new NowItWillTheAnotherColorPlayer("Mr. AnotherColor", 4000000);
            }
            case 7 -> {
                System.out.println("A válaszott stratégia: 1-3-2-6. Játékos a következő adatokkal jön létre: \n Név: Mr. SpecialCount \n Kezdő tőke: 4.000.000 HUF");
                person = new SpecialCountPlayer("Mr. SpecialCount", 4000000);
            }
            default -> throw new IllegalStateException("Unexpected value: " + answer);
        }

        casino.getPeople().add(person);
        for (int i = 0; i < nrOfRound; i++) {
            casino.play();
            try {
                System.out.println(casino.getPeople().get(0));
            }catch (IndexOutOfBoundsException e){
                System.out.println("Minden játékosnak elfogyott a pénze, így vége a játéknak.");
                break;
            }

        }
    }

}