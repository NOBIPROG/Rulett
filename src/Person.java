public class Person implements Strategy{

    private String name;
    private int valet;
    private int bet;
    private String strategy;
    private boolean wasWin= true;
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
        int random = (int)(Math.random()*2);

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

    public void bet (Rulett rulett){
        if (strategy.equals("alwaysred")){
            setChosenCombination("red");
            if (wasWin){
                setBet(100);
                setValet(getValet() - getBet());
            }
            else {
                setBet(getBet()*2);
            }
        }
    }
}