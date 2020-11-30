public class FullRandomPlayer extends Person {


    public FullRandomPlayer(String name, int valet) {
        super(name, valet);
        setStrategy("fullRandom");
    }

    @Override
    public void bet(Rulett rulett) {
      int  randomBetValue = (int) (Math.random() * rulett.getMaxBet() + rulett.getMinBet());
      int  randomStrategy = (int) (Math.random() * 13);
        switch (randomStrategy) {
            case 0 -> setChosenCombination("red");
            case 1 -> setChosenCombination("black");
            case 2 -> setChosenCombination("even");
            case 3 -> setChosenCombination("odd");
            case 4 -> {
              int  randomNr = (int) (Math.random() * 36);
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
        if (getValet() >= randomBetValue) {
            setBet(randomBetValue);
        }
        else {
            setBet(getValet());
        }
        setValet(getValet() - getBet());
    }
}
