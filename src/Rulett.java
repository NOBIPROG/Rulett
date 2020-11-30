import java.util.*;

public class Rulett {

    private int nr;
    private int round;
    private int minBet;
    private int maxBet;
    private HashMap<String, Integer> results = new HashMap<>();
    private HashMap<Integer, Set<betOptions>> numbersSpecs;

    public Rulett() {
        numbersSpecs = new HashMap<>();
        for (int i = 0; i < 37; i++) {
            numbersSpecs.putIfAbsent(i, new HashSet<>());
            numbersSpecs.get(i).add(betOptions.NUMBER);
            if (i % 2 == 0) {
                numbersSpecs.get(i).add(betOptions.EVEN);
            } else {
                numbersSpecs.get(i).add(betOptions.ODD);
            }
            if (i < 13 && i != 0) {
                numbersSpecs.get(i).add(betOptions.FIRSTTHIRD);
                numbersSpecs.get(i).add(betOptions.NUMBERSBETWEEN1AND18);
            } else if (i >= 13 && i < 25) {
                numbersSpecs.get(i).add(betOptions.SECONDTHIRD);
                if (i < 19) {
                    numbersSpecs.get(i).add(betOptions.NUMBERSBETWEEN1AND18);
                } else {
                    numbersSpecs.get(i).add(betOptions.NUMBERSBETWEEN19AND36);
                }
            } else if (i > 24) {
                numbersSpecs.get(i).add(betOptions.THIRDTHIRD);
                numbersSpecs.get(i).add(betOptions.NUMBERSBETWEEN19AND36);
            }
        }
        numbersSpecs.get(1).add(betOptions.RED);
        numbersSpecs.get(1).add(betOptions.LINE1);
        numbersSpecs.get(2).add(betOptions.BLACK);
        numbersSpecs.get(2).add(betOptions.LINE2);
        numbersSpecs.get(3).add(betOptions.RED);
        numbersSpecs.get(3).add(betOptions.LINE3);
        numbersSpecs.get(4).add(betOptions.BLACK);
        numbersSpecs.get(4).add(betOptions.LINE1);
        numbersSpecs.get(5).add(betOptions.LINE2);
        numbersSpecs.get(5).add(betOptions.RED);
        numbersSpecs.get(6).add(betOptions.BLACK);
        numbersSpecs.get(8).add(betOptions.BLACK);
        numbersSpecs.get(10).add(betOptions.BLACK);
        numbersSpecs.get(11).add(betOptions.BLACK);
        numbersSpecs.get(13).add(betOptions.BLACK);
        numbersSpecs.get(15).add(betOptions.BLACK);
        numbersSpecs.get(17).add(betOptions.BLACK);
        numbersSpecs.get(20).add(betOptions.BLACK);
        numbersSpecs.get(22).add(betOptions.BLACK);
        numbersSpecs.get(24).add(betOptions.BLACK);
        numbersSpecs.get(26).add(betOptions.BLACK);
        numbersSpecs.get(28).add(betOptions.BLACK);
        numbersSpecs.get(29).add(betOptions.BLACK);
        numbersSpecs.get(31).add(betOptions.BLACK);
        numbersSpecs.get(33).add(betOptions.BLACK);
        numbersSpecs.get(35).add(betOptions.BLACK);
        numbersSpecs.get(7).add(betOptions.RED);
        numbersSpecs.get(9).add(betOptions.RED);
        numbersSpecs.get(12).add(betOptions.RED);
        numbersSpecs.get(14).add(betOptions.RED);
        numbersSpecs.get(16).add(betOptions.RED);
        numbersSpecs.get(18).add(betOptions.RED);
        numbersSpecs.get(19).add(betOptions.RED);
        numbersSpecs.get(21).add(betOptions.RED);
        numbersSpecs.get(23).add(betOptions.RED);
        numbersSpecs.get(25).add(betOptions.RED);
        numbersSpecs.get(27).add(betOptions.RED);
        numbersSpecs.get(30).add(betOptions.RED);
        numbersSpecs.get(32).add(betOptions.RED);
        numbersSpecs.get(34).add(betOptions.RED);
        numbersSpecs.get(36).add(betOptions.RED);
        numbersSpecs.get(7).add(betOptions.LINE1);
        numbersSpecs.get(10).add(betOptions.LINE1);
        numbersSpecs.get(13).add(betOptions.LINE1);
        numbersSpecs.get(16).add(betOptions.LINE1);
        numbersSpecs.get(19).add(betOptions.LINE1);
        numbersSpecs.get(22).add(betOptions.LINE1);
        numbersSpecs.get(25).add(betOptions.LINE1);
        numbersSpecs.get(28).add(betOptions.LINE1);
        numbersSpecs.get(31).add(betOptions.LINE1);
        numbersSpecs.get(34).add(betOptions.LINE1);
        numbersSpecs.get(8).add(betOptions.LINE2);
        numbersSpecs.get(11).add(betOptions.LINE2);
        numbersSpecs.get(14).add(betOptions.LINE2);
        numbersSpecs.get(17).add(betOptions.LINE2);
        numbersSpecs.get(20).add(betOptions.LINE2);
        numbersSpecs.get(23).add(betOptions.LINE2);
        numbersSpecs.get(26).add(betOptions.LINE2);
        numbersSpecs.get(29).add(betOptions.LINE2);
        numbersSpecs.get(32).add(betOptions.LINE2);
        numbersSpecs.get(35).add(betOptions.LINE2);
        numbersSpecs.get(6).add(betOptions.LINE3);
        numbersSpecs.get(9).add(betOptions.LINE3);
        numbersSpecs.get(12).add(betOptions.LINE3);
        numbersSpecs.get(15).add(betOptions.LINE3);
        numbersSpecs.get(18).add(betOptions.LINE3);
        numbersSpecs.get(21).add(betOptions.LINE3);
        numbersSpecs.get(24).add(betOptions.LINE3);
        numbersSpecs.get(27).add(betOptions.LINE3);
        numbersSpecs.get(30).add(betOptions.LINE3);
        numbersSpecs.get(33).add(betOptions.LINE3);
        numbersSpecs.get(36).add(betOptions.LINE3);
    }

    public void setMinBet(int minBet) {
        this.minBet = minBet;
    }

    public void setMaxBet(int maxBet) {
        this.maxBet = maxBet;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void redWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));
        person.setWasWin(true);
        // System.out.println(person.getName() + " " + (person.getBet() * 2) + " " + person.getChosenCombination());
    }

    public void blackWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));
        person.setWasWin(true);
    }

    public void evenWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));
        person.setWasWin(true);
    }

    public void oddWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));
        person.setWasWin(true);
    }

    public void numberWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 36));
        person.setWasWin(true);
    }

    public void numbersBetween1And18Win(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));
        person.setWasWin(true);

    }

    public void numbersBetween19And36Win(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 2));
        person.setWasWin(true);
    }

    public void firstThirdWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
    }

    public void secondThirdWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
        person.setWasWin(true);
    }

    public void thirdThirdWin(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
        person.setWasWin(true);
    }


    public void line1Win(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
        person.setWasWin(true);
    }

    public void line2Win(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
        person.setWasWin(true);
    }

    public void line3Win(Person person) {
        person.setValet(person.getValet() + (person.getBet() * 3));
        person.setWasWin(true);
    }

    public HashMap<Integer, Set<betOptions>> getNumbersSpecs() {
        return numbersSpecs;
    }

    public int getMinBet() {
        return minBet;
    }

    public int getMaxBet() {
        return maxBet;
    }

    public HashMap<String, Integer> getResults() {
        return results;
    }

    public int getActualNr() {
        nr = (int) (Math.random() * 36);
        round++;
        switch (nr) {
            case 0 -> {
                results.putIfAbsent("green", 0);
                results.put("green", results.get("green") + 1);
            }
            case 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 -> {
                results.putIfAbsent("red", 0);
                results.put("red", nr);
            }
            case 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 -> {
                results.putIfAbsent("black", 0);
                results.put("black", nr);

            }
        }
        return nr;
    }
}

