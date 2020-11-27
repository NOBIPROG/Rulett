public class Person {

    private String name;
    private int valet;
    private int bet;
    private Strategy strategy;

    public Person(String name, int valet, Strategy strategy) {
        this.name = name;
        this.valet = valet;
        this.strategy = strategy;
    }

    public Person(String name, int valet) {
        this.name = name;
        this.valet = valet;
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

    public Strategy getStrategy() {
        return strategy;
    }

}