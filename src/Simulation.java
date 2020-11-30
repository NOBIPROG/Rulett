import java.util.Map;

public class Simulation {

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.doSimulation(10);
    }

    Casino casino;

    public Simulation() {
        casino = new Casino();
        casino.getRulett().setMinBet(100);
        casino.getRulett().setMaxBet(1000000);
    }

    public void doSimulation(int nrOfRound) {
        Person person = new AlwaysRedPlayer("Martingél Béla", 5000000);
        casino.getPeople().add(person);
        for (int i = 0; i < nrOfRound; i++) {
            casino.play();
            for (Map.Entry<String, Integer> entry : casino.getRulett().getResults().entrySet()) {
                if (entry.getValue().equals(casino.getRulett().getNr())) {
                    System.out.println(entry.getKey());
                }

            }
            System.out.println(casino.getPeople().get(0));
        }
    }

}