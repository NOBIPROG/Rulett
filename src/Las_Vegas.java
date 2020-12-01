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

    public void letsGoToTheCasino(){
        System.out.println("Üdvözöllek a Tangiers kaszinóban. Először is kérlek add meg, hogy szimulációt szeretnél-e játszani vagy azonnal odaülsz a rulett asztalhoz és játszol élesben: \n 1. --> Szimuláció \n 2. --> Játék");
        Scanner sc = new Scanner(System.in);
        boolean isGoodAnswer = false;
        int answer = 0;
        while (!isGoodAnswer){
            try {
                isGoodAnswer = true;
                answer = sc.nextInt();
                if (answer == 0 || answer > 2){
                    throw new TooBigNumberException();
                }
            }catch (InputMismatchException e){
                System.out.println("Nem számot írtál be. Kérlek írj be számot");
                sc = new Scanner(System.in);
                isGoodAnswer = false;
            }
            catch (TooBigNumberException e){
                System.out.println("Ilyen szám nem szerepel a felsorolásban. Kérlek helyes számot adj meg");
                sc = new Scanner(System.in);
                isGoodAnswer = false;
            }
        }
        sc = new Scanner(System.in);
        if (answer == 1){
            Simulation simulation = new Simulation();
            System.out.println("Kérlek add meg, hogy hány körig menjen a szimuláció: ");
            answer = sc.nextInt();
            simulation.doSimulation(answer);
        }
        else {


        }


    }
}
