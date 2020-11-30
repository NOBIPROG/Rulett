public class BravePlayer extends Person {
    public BravePlayer(String name, int valet) {
        super(name, valet);
        setStrategy("brave");
    }

    @Override
    public void bet(Rulett rulett) {
        setChosenCombination("red");
        if (getValet() >= rulett.getMaxBet()) {
            setBet(rulett.getMaxBet());
        }
        else {
            setBet(getValet());
        }
        setValet(getValet() - getBet());
    }
}
