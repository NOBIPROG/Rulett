public class Person implements Strategy {

    private String name;
    private int valet;
    private int bet;
    private String strategy;
    private boolean wasWin = true;
    private String chosenCombination;


    public Person(String name, int valet, String strategy) {
        this.name = name;
        this.valet = valet;
        this.strategy = strategy;
    }

    public Person(String name, int valet) {
        this.name = name;
        this.valet = valet;
        chosenCombination = "red";
        int random = (int) (Math.random() * 2);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValet() {
        return valet;
    }

    public void setValet(int valet) {
        this.valet = valet;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public String getStrategy() {
        return strategy;
    }

    public boolean isWasWin() {
        return wasWin;
    }

    public void setWasWin(boolean wasWin) {
        this.wasWin = wasWin;
    }

    public String getChosenCombination() {
        return chosenCombination;
    }

    public void setChosenCombination(String chosenCombination) {
        this.chosenCombination = chosenCombination;
    }

    public void bet(Rulett rulett) {
        int randomStrategy;
        int randomBetValue;
        int randomNr;
        if (strategy.equals("alwaysred")) {
            setChosenCombination("red");
            if (wasWin) {
                setBet(100);
                setValet(getValet() - getBet());
            } else {
                setBet(getBet() * 2);
            }
        } else if (strategy.equals("randomColor")) {
            randomStrategy = (int) (Math.random() * 2);
            randomBetValue = (int) (Math.random() * rulett.getMaxBet() + rulett.getMinBet());
            if (randomStrategy == 0) {
                setChosenCombination("red");
            } else {
                setChosenCombination("black");
            }
            setBet(randomBetValue);
            setValet(getValet() - getBet());
        } else if (strategy.equals("fullRandom")) {
            randomBetValue = (int) (Math.random() * rulett.getMaxBet() + rulett.getMinBet());
            randomStrategy = (int) (Math.random() * 13);
            switch (randomStrategy) {
                case 0 -> setChosenCombination("red");
                case 1 -> setChosenCombination("black");
                case 2 -> setChosenCombination("even");
                case 3 -> setChosenCombination("odd");
                case 4 -> {
                    randomNr = (int) (Math.random() * 36);
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
            setBet(randomBetValue);
            setValet(getValet() - getBet());
        }

        else if (strategy.equals("conservation")){
            setChosenCombination("red");
            setBet(rulett.getMinBet());
            setValet(getValet() - getBet());
        }
        else if (strategy.equals("brave")){
            setChosenCombination("red");
            setBet(rulett.getMaxBet());
            setValet(getValet() - getBet());
        }
        //Mostmármásjön stratégia megírni. Rulett számolja a piros és feketét.
    }
}