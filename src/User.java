import java.util.InputMismatchException;
import java.util.Scanner;

public class User extends Person {

    private Scanner sc;

    public User(String name, int valet) {
        super(name, valet);
        setStrategy("User");
        sc = new Scanner(System.in);
    }

    @Override
    public void bet(Rulett rulett) {
        boolean isGoodAnswer = false;
        int answer1 = 0;
        int chosenNr = 0;
        while (!isGoodAnswer) {
            System.out.println(name +  " mekkora összeget szeretnél rakni? (Min: 100, Max: 1.000.000)");
            try {
                answer1 = sc.nextInt();
                isGoodAnswer = true;
                if (answer1 < 100 || answer1 > 1000000) {
                    throw new BadBetException();
                }if (answer1>getValet()){
                  throw new TooBigNumberException();
                }

            } catch (InputMismatchException e) {
                System.out.println("Nem számot adtál meg. Kérlek írj be számot.");
                isGoodAnswer = false;
                sc = new Scanner(System.in);
            } catch (BadBetException e) {
                System.out.println("Ekkora összeget nem rakhatsz. Kérlek válassz újra.");
                isGoodAnswer = false;
                sc = new Scanner(System.in);
            }catch (TooBigNumberException e){
                System.out.println("Nincs ennyi pénzed! Maximum "+getValet()+"-t rakhatsz");
                isGoodAnswer=false;
                sc=new Scanner(System.in);
            }
        }
        setBet(answer1);
        System.out.println("Mire szeretnél rakni?");
        System.out.println("1.--> Pirosra \n2.--> Feketére \n3.--> Párosra \n4.--> Páratlanra \n5.--> Számra \n6.--> 1-18 közötti számra \n7.--> 19-36 közötti számra \n8.--> Első harmadra \n9.--> Második harmad \n10.--> Harmadik harmad \n11.--> Első oszlop \n12.--> Második oszlop \n13.--> Harmadik oszlop");
        sc = new Scanner(System.in);
        while (isGoodAnswer) {
            try {
                answer1 = sc.nextInt();
                isGoodAnswer = false;
                if (answer1 <= 0 || answer1 > 13) {
                    throw new TooBigNumberException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Nem számot adtál meg. Kérlek írj be számot.");
                isGoodAnswer = true;
                sc = new Scanner(System.in);
            } catch (TooBigNumberException e) {
                System.out.println("Nincs ilyen szám a felsorolásban. Kérlek válassz újra.");
                isGoodAnswer = true;
                sc = new Scanner(System.in);
            }

        }
        if (answer1 == 5) {
            System.out.println("Melyik számra szeretnél rakni? (0 - 36) ");
            sc = new Scanner(System.in);
            while (!isGoodAnswer) {
                try {
                    chosenNr = sc.nextInt();
                    isGoodAnswer = true;
                    if (chosenNr < 0 || chosenNr > 36) {
                        throw new TooBigNumberException();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Nem számot adtál meg. Kérlek írj be számot.");
                    isGoodAnswer = false;
                    sc = new Scanner(System.in);
                } catch (TooBigNumberException e) {
                    System.out.println("Nincs ilyen szám a felsorolásban. Kérlek válassz újra.");
                    isGoodAnswer = false;
                    sc = new Scanner(System.in);
                }
            }
        }

        switch (answer1) {
            case 1 -> chosenCombination = new ChosenCombination(betOptions.RED);
            case 2 -> chosenCombination = new ChosenCombination(betOptions.BLACK);
            case 3 -> chosenCombination = new ChosenCombination(betOptions.EVEN);
            case 4 -> chosenCombination = new ChosenCombination(betOptions.ODD);
            case 5 -> {
                chosenCombination = new ChosenCombination(betOptions.NUMBER);
                chosenCombination.setChosenNumber(chosenNr);
            }
            case 6 -> chosenCombination = new ChosenCombination(betOptions.NUMBERSBETWEEN1AND18);
            case 7 -> chosenCombination = new ChosenCombination(betOptions.NUMBERSBETWEEN19AND36);
            case 8 -> chosenCombination = new ChosenCombination(betOptions.FIRSTTHIRD);
            case 9 -> chosenCombination = new ChosenCombination(betOptions.SECONDTHIRD);
            case 10 -> chosenCombination = new ChosenCombination(betOptions.THIRDTHIRD);
            case 11 -> chosenCombination = new ChosenCombination(betOptions.LINE1);
            case 12 -> chosenCombination = new ChosenCombination(betOptions.LINE2);
            case 13 -> chosenCombination = new ChosenCombination(betOptions.LINE3);
        }
        setValet(getValet()-getBet());
    }
}