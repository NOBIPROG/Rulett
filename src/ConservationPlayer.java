public class ConservationPlayer extends Person {


    public ConservationPlayer(String name, int valet) {
        super(name, valet);
        setStrategy("conservation");
    }

    @Override
    public void bet(Rulett rulett) {
        chosenCombination = new ChosenCombination(betOptions.RED);
        setBet(rulett.getMinBet());
        setValet(getValet() - getBet());
    }
}
