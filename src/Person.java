public abstract class Person {

    protected String name;
    protected int valet;
    protected int bet;
    protected boolean wasWin;
    protected String strategy;
    protected ChosenCombination chosenCombination;
    protected int wonMoney;
    protected int lostMoney;

    public void setChosenCombination(ChosenCombination chosenCombination) {
        this.chosenCombination = chosenCombination;
    }

    public int getWonMoney() {
        return wonMoney;
    }

    public void setWonMoney(int wonMoney) {
        this.wonMoney = wonMoney;
    }

    public Person(String name, int valet) {
        this.name = name;
        this.valet = valet;


    }
    public abstract void bet(Rulett rulett);

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


    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public ChosenCombination getChosenCombination() {
        return chosenCombination;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", valet=" + valet +
                ", bet=" + bet +
                ", wasWin=" + wasWin +
                ", strategy='" + strategy + '\'' +
                ", chosenCombination=" + chosenCombination +
                '}';
    }

    public int getLostMoney() {
        return lostMoney;
    }

    public void setLostMoney(int lostMoney) {
        this.lostMoney = lostMoney;
    }
}