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
            case 0 -> chosenCombination.setBetOptions(betOptions.RED);
            case 1 -> chosenCombination.setBetOptions(betOptions.BLACK);
            case 2 ->chosenCombination.setBetOptions(betOptions.EVEN);
            case 3 -> chosenCombination.setBetOptions(betOptions.ODD);
            case 4 -> {
                int randomNr = (int) (Math.random() * 36);
                chosenCombination.setBetOptions(betOptions.NUMBER);
                chosenCombination.setChosenNumber(randomNr);
            }
            case 5 ->chosenCombination.setBetOptions(betOptions.NUMBERSBETWEEN1AND18);
            case 6 -> chosenCombination.setBetOptions(betOptions.NUMBERSBETWEEN19AND36);
            case 7 -> chosenCombination.setBetOptions(betOptions.FIRSTTHIRD);
            case 8 -> chosenCombination.setBetOptions(betOptions.SECONDTHIRD);
            case 9 -> chosenCombination.setBetOptions(betOptions.THIRDTHIRD);
            case 10 -> chosenCombination.setBetOptions(betOptions.LINE1);
            case 11 -> chosenCombination.setBetOptions(betOptions.LINE2);
            case 12 -> chosenCombination.setBetOptions(betOptions.LINE3);
        }
        if (getValet() >= randomBetValue) {
            setBet(randomBetValue);
        } else {
            setBet(getValet());
        }
        setValet(getValet() - getBet());
    }
}
