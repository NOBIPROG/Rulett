public abstract class Person implements Strategy {

    protected String name;
    protected int valet;
    protected int bet;
    protected boolean wasWin;
    protected String strategy;
    protected String chosenCombination;



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

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", valet=" + valet +
                ", bet=" + bet +
                ", wasWin=" + wasWin +
                ", strategy='" + strategy + '\'' +
                ", chosenCombination='" + chosenCombination + '\'' +
                '}';
    }
}