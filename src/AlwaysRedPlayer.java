public class AlwaysRedPlayer extends Person {


    public AlwaysRedPlayer(String name, int valet) {
        super(name, valet);
        setStrategy("alwaysred");
        wasWin = true;
    }

    @Override
    public void bet(Rulett rulett) {
        chosenCombination = new ChosenCombination(betOptions.RED);
        if (wasWin) {
            if (getBet() < getValet()) {
                setBet(rulett.getMinBet());
                setValet(getValet() - getBet());
            } else {
                setBet(getValet());
            }

        } else {
            if (getBet() * 2 < getValet()) {
                setBet(getBet() * 2);
            }else {
                setBet(getValet());
            }

        }
    }
}
