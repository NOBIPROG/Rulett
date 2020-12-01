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
        int k = 0;
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
            System.out.println("A Tangiers kaszinóban a következő szabályok érvényesek: \nMinimum tét: 100 \nMaximum tét: 1.000.000");
            tangiers.getRulett().setMinBet(100);
            tangiers.getRulett().setMaxBet(1000000);
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
                System.out.println("Add meg a(z) " + (i + 1) + ". játékos nevét");
                String name = sc.next();
                System.out.println("Add meg a kezdő összeget");

                sc = new Scanner(System.in);
                int startMoney = 0;
                isGoodAnswer = false;
                while (!isGoodAnswer) {
                    try {
                        isGoodAnswer = true;
                        startMoney = sc.nextInt();
                        if (startMoney < 100) {
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
            sc = new Scanner(System.in);
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
            System.out.println("Hány kört szeretnénk játszani?");
            sc = new Scanner(System.in);
            int nrOfRound = 0;
            while (!isGoodAnswer) {
                try {
                    isGoodAnswer = true;
                    nrOfRound = sc.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println("Nem számot írtál be. Kérlek írj be számot");
                    sc = new Scanner(System.in);
                    isGoodAnswer = false;
                }
                for (int i = 0; i < nrOfRound; i++) {
                    tangiers.play();
                    try {
                        for (int j = 0; j < tangiers.getPeople().size(); j++) {
                            System.out.println(tangiers.getPeople().get(j));
                        }

                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Minden játékosnak elfogyott a pénze, így vége a játéknak.");
                        break;
                    }
                    while (k < tangiers.getPeople().size()) {
                        if (tangiers.getPeople().get(k) instanceof User) {
                            System.out.println(tangiers.getPeople().get(k).getName() + " Szeretnél még egy kört játszani? \n1 --> Igen \n2 --> Nem");
                            sc = new Scanner(System.in);
                            isGoodAnswer = true;
                            while (isGoodAnswer) {
                                try {
                                    isGoodAnswer = false;
                                    answer = sc.nextInt();
                                    if (answer < 1 || answer > 2) {
                                        throw new TooBigNumberException();
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Nem számot írtál be. Kérlek írj be számot");
                                    sc = new Scanner(System.in);
                                    isGoodAnswer = true;
                                } catch (TooBigNumberException e) {
                                    System.out.println("Ilyen szám nem szerepel a felsorolásban. Kérlek helyes számot adj meg");
                                    sc = new Scanner(System.in);
                                    isGoodAnswer = true;
                                }
                            }
                            if (answer == 1) {
                                k++;
                            } else {
                                tangiers.getPeople().remove(i);
                            }
                        } else {
                            k++;
                        }
                    }
                    int biggestNr = 0;
                    int winnerPlayer = 0;
                    for (int j = 0; j < tangiers.getPeople().size(); j++) {
                                if (biggestNr < (tangiers.getPeople().get(j).getWonMoney()-tangiers.getPeople().get(j).getLostMoney())){
                                    biggestNr = (tangiers.getPeople().get(j).getWonMoney()-tangiers.getPeople().get(j).getLostMoney());
                                    winnerPlayer = j;
                                }
                    }
                    System.out.println("Vége a játéknak. A nyertes játékos adatai: \n" + "Név: " + tangiers.getPeople().get(winnerPlayer).getName() +"\nNyereménye: " + biggestNr);

                }
            }
        }
    }
}