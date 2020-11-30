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
        if (nrOfWin == 3){
            betValue = getValet() /12;
            nrOfWin = 0;
        }
        int randomStrategy = (int) (Math.random() * 13);
        switch (randomStrategy) {
            case 0 -> setChosenCombination("red");
            case 1 -> setChosenCombination("black");
            case 2 -> setChosenCombination("even");
            case 3 -> setChosenCombination("odd");
            case 4 -> {
                int randomNr = (int) (Math.random() * 36);
                setChosenCombination(Integer.toString(randomNr));
            }
            case 5 -> setChosenCombination("numbersbetwen1and18");
            case 6 -> setChosenCombination("numbersbetwen19an36");
            case 7 -> setChosenCombination("firstThird");
            case 8 -> setChosenCombination("secondThird");
            case 9 -> setChosenCombination("thirdThird");
            case 10 -> setChosenCombination("line1");
            case 11 -> setChosenCombination("line2");
            case 12 -> setChosenCombination("line3");

        }
        if (nrOfWin == 0){
            setBet(betValue);
    }
        if (isWasWin()){
            nrOfWin++;
            switch (nrOfWin){
                case 1 : setBet(betValue * 3);
                break;
                case 2 : setBet(betValue * 2);
                break;
                case 3 : setBet(betValue * 6);
                break;
            }
        }
        else {
            nrOfWin = 0;
        }

    }

}
