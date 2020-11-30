public class FullRandomPlayer extends Person {


    public FullRandomPlayer(String name, int valet) {
        super(name, valet);
        setStrategy("fullRandom");
    }

    @Override
    public void bet(Rulett rulett) {
        int randomBetValue = (int) (Math.random() * rulett.getMaxBet() + rulett.getMinBet());
        int randomStrategy = (int) (Math.random() * 13);
        switch (randomStrategy) {
            case 0 -> chosenCombination = new ChosenCombination(betOptions.RED);
            case 1 -> chosenCombination = new ChosenCombination(betOptions.BLACK);
            case 2 -> chosenCombination = new ChosenCombination(betOptions.EVEN);
            case 3 -> chosenCombination = new ChosenCombination(betOptions.ODD);
            case 4 -> {
                int randomNr = (int) (Math.random() * 36);
                chosenCombination = new ChosenCombination(betOptions.NUMBER);
                chosenCombination.setChosenNumber(randomNr);
            }
            case 5 ->chosenCombination = new ChosenCombination(betOptions.NUMBERSBETWEEN1AND18);
            case 6 -> chosenCombination = new ChosenCombination(betOptions.NUMBERSBETWEEN19AND36);
            case 7 -> chosenCombination = new ChosenCombination(betOptions.FIRSTTHIRD);
            case 8 -> chosenCombination = new ChosenCombination(betOptions.SECONDTHIRD);
            case 9 -> chosenCombination = new ChosenCombination(betOptions.THIRDTHIRD);
            case 10 -> chosenCombination = new ChosenCombination(betOptions.LINE1);
            case 11 -> chosenCombination = new ChosenCombination(betOptions.LINE2);
            case 12 -> chosenCombination = new ChosenCombination(betOptions.LINE3);
        }
        if (getValet() >= randomBetValue) {
            setBet(randomBetValue);
        } else {
            setBet(getValet());
        }
        setValet(getValet() - getBet());
    }
}
