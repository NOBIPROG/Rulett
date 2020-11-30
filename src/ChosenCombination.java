public class ChosenCombination {
    private betOptions betOptions;
    private int chosenNumber;

    public betOptions getBetOptions() {
        return betOptions;
    }

    public void setBetOptions(betOptions betOptions) {
        this.betOptions = betOptions;
    }

    public int getChosenNumber() {
        return chosenNumber;
    }

    public void setChosenNumber(int chosenNumber) {
        this.chosenNumber = chosenNumber;
    }

    public ChosenCombination(betOptions betOptions) {
        this.betOptions = betOptions;
    }

    public ChosenCombination(betOptions betOptions, int chosenNumber) {
        this.betOptions = betOptions;
        this.chosenNumber = chosenNumber;
    }

    @Override
    public String toString() {
        if (betOptions.equals(betOptions.NUMBER)) {
            return "ChosenCombination{" +
                    "betOptions=" + betOptions +
                    ", chosenNumber=" + chosenNumber +
                    '}';
        } else {
            return "ChosenCombination{" +
                    "betOptions=" + betOptions;
        }
    }
}
