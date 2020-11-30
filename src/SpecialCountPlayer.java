public class SpecialCountPlayer extends Person {

    private int nrOfWin;
    private int betValue;

    public SpecialCountPlayer(String name, int valet) {
        super(name, valet);
        setStrategy("specialCount");
        betValue = getValet() / 12;
        setWasWin(false);

    }

    @Override
    public void bet(Rulett rulett) {
        if (nrOfWin == 3) {
            betValue = getValet() / 12;
            nrOfWin = 0;
        }
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
            case 5 -> chosenCombination = new ChosenCombination(betOptions.NUMBERSBETWEEN1AND18);
            case 6 -> chosenCombination = new ChosenCombination(betOptions.NUMBERSBETWEEN19AND36);
            case 7 -> chosenCombination = new ChosenCombination(betOptions.FIRSTTHIRD);
            case 8 -> chosenCombination = new ChosenCombination(betOptions.SECONDTHIRD);
            case 9 -> chosenCombination = new ChosenCombination(betOptions.THIRDTHIRD);
            case 10 -> chosenCombination = new ChosenCombination(betOptions.LINE1);
            case 11 -> chosenCombination = new ChosenCombination(betOptions.LINE2);
            case 12 -> chosenCombination = new ChosenCombination(betOptions.LINE3);

        }
        if (nrOfWin == 0) {
            setBet(betValue);
        }
        if (isWasWin()) {
            nrOfWin++;
            switch (nrOfWin) {
                case 1:
                    setBet(betValue * 3);
                    break;
                case 2:
                    setBet(betValue * 2);
                    break;
                case 3:
                    setBet(betValue * 6);
                    break;
            }
        } else {
            nrOfWin = 0;
        }

    }

}
