public class AlwaysRedPlayer extends Person {


    public AlwaysRedPlayer(String name, int valet) {
        super(name, valet);
        setStrategy("alwaysred");
        wasWin = true;
    }

    @Override
    public void bet(Rulett rulett) {
        setChosenCombination("red");
        if (wasWin) {
            setBet(100);
            setValet(getValet() - getBet());
        } else {
            setBet(getBet() * 2);
        }
    }
}
