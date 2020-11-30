public class RandomColorPlayer extends Person {

    public RandomColorPlayer(String name, int valet) {
        super(name, valet);
        setStrategy("randomColor");
    }

    @Override
    public void bet(Rulett rulett) {
        int randomColor = (int) (Math.random() * 2);
        int randomBetValue = (int) (Math.random() * rulett.getMaxBet() + rulett.getMinBet());
        if (randomColor == 0) {
            chosenCombination.setBetOptions(betOptions.RED);
        } else {
            chosenCombination.setBetOptions(betOptions.BLACK);
        }
        if (getValet() >= randomBetValue) {
            setBet(randomBetValue);
        } else {
            setBet(getValet());
        }
        setValet(getValet() - getBet());
    }
}
