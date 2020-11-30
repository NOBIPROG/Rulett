public class ConservationPlayer extends Person {


    public ConservationPlayer(String name, int valet) {
        super(name, valet);
        setStrategy("conservation");
    }

    @Override
    public void bet(Rulett rulett) {
        setChosenCombination("red");
        setBet(rulett.getMinBet());
        setValet(getValet() - getBet());
    }
}
