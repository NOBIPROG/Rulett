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
}
