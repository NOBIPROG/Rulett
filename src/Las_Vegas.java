import java.util.InputMismatchException;
import java.util.Scanner;

public class Las_Vegas {

    public static void main(String[] args) {
        Las_Vegas lasVegas = new Las_Vegas();
        lasVegas.letsGoToTheCasino();
    }

    Casino tangiers;

    public Las_Vegas() {
        tangiers = new Casino();
    }

    public void letsGoToTheCasino() {
        System.out.println("Üdvözöllek a Tangiers kaszinóban. Először is kérlek add meg, hogy szimulációt szeretnél-e játszani vagy azonnal odaülsz a rulett asztalhoz és játszol élesben: \n 1. --> Szimuláció \n 2. --> Játék");
        Scanner sc = new Scanner(System.in);
        boolean isGoodAnswer = false;
        int answer = 0;
        while (!isGoodAnswer) {
            try {
                isGoodAnswer = true;
                answer = sc.nextInt();
                if (answer == 0 || answer > 2) {
                    throw new TooBigNumberException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Nem számot írtál be. Kérlek írj be számot");
                sc = new Scanner(System.in);
                isGoodAnswer = false;
            } catch (TooBigNumberException e) {
                System.out.println("Ilyen szám nem szerepel a felsorolásban. Kérlek helyes számot adj meg");
                sc = new Scanner(System.in);
                isGoodAnswer = false;
            }
        }
        sc = new Scanner(System.in);
        if (answer == 1) {
            Simulation simulation = new Simulation();
            System.out.println("Kérlek add meg, hogy hány körig menjen a szimuláció: ");
            answer = sc.nextInt();
            simulation.doSimulation(answer);
        } else {
            System.out.println("Hány felhasználóval szeretnél játszani?");

            while (isGoodAnswer) {
                try {
                    isGoodAnswer = false;
                    answer = sc.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println("Nem számot írtál be. Kérlek írj be számot");
                    sc = new Scanner(System.in);
                    isGoodAnswer = true;
                }
            }
            for (int i = 0; i < answer; i++) {
                sc = new Scanner(System.in);
                System.out.println("Add meg a" + (i + 1) + ". játékos nevét");
                String name = sc.next();
                System.out.println("Add meg a kezdő összeget");

                sc = new Scanner(System.in);
                int startMoney = 0;
                while (!isGoodAnswer) {
                    try {
                        isGoodAnswer = true;
                        startMoney = sc.nextInt();
                        if (answer < 100) {
                            throw new TooSmallNumberException();
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Nem számot írtál be. Kérlek írj be számot");
                        sc = new Scanner(System.in);
                        isGoodAnswer = false;
                    } catch (TooSmallNumberException e) {
                        System.out.println("A kezdő összeg minimum 100");
                        sc = new Scanner(System.in);
                        isGoodAnswer = false;
                    }
                    tangiers.getPeople().add(new User(name, startMoney));

                }

            }
            System.out.println("Hány BOT-ot szeretnél?");
            sc=new Scanner(System.in);
            while (isGoodAnswer) {
                try {
                    isGoodAnswer = false;
                    answer = sc.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println("Nem számot írtál be. Kérlek írj be számot");
                    sc = new Scanner(System.in);
                    isGoodAnswer = true;
                }
                tangiers.fillUpCasino(answer);
            }


        }
    }
}
