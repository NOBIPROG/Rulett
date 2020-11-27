import java.util.ArrayList;

public class Casino {

    private ArrayList<Person> people;
    private Rulett rulett;
    private int income;

    public Casino() {
        people = new ArrayList<>();
        rulett = new Rulett();
    }

    public void fillUpCasino() {
        people.add(new Person("Martingél Béla", 1000, "red"));
    }

    public void play() {
        for (Person value : people) {
            value.bet(rulett);
        }
        int winnerNr = rulett.getNr();
        for (Person person : people) {
            switch (winnerNr) {
                case 0:

                    if (person.getChosenCombination().equals("0")) {
                        rulett.numberWin(person);
                    }
                case 1:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "firstThird" -> rulett.firstThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line1" -> rulett.line1Win(person);
                        case "1" -> rulett.numberWin(person);
                    }
                case 2:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "firstThird" -> rulett.firstThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "2" -> rulett.numberWin(person);
                    }
                case 3:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "firstThird" -> rulett.firstThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "3" -> rulett.numberWin(person);
                    }
                case 4:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "firstThird" -> rulett.firstThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line1" -> rulett.line1Win(person);
                        case "4" -> rulett.numberWin(person);
                    }
                case 5:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "firstThird" -> rulett.firstThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "5" -> rulett.numberWin(person);
                    }
                case 6:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "firstThird" -> rulett.firstThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "6" -> rulett.numberWin(person);
                    }
                case 7:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "firstThird" -> rulett.firstThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line1" -> rulett.line1Win(person);
                        case "7" -> rulett.numberWin(person);
                    }
                case 8:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "firstThird" -> rulett.firstThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "2" -> rulett.numberWin(person);
                    }
                case 9:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "firstThird" -> rulett.firstThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "9" -> rulett.numberWin(person);
                    }
                case 10: switch (person.getChosenCombination()) {
                    case "black" -> rulett.blackWin(person);
                    case "even" -> rulett.evenWin(person);
                    case "firstThird" -> rulett.firstThirdWin(person);
                    case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                    case "line1" -> rulett.line1Win(person);
                    case "10"->rulett.numberWin(person);
                }
                case 11:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "firstThird" -> rulett.firstThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "11"->rulett.numberWin(person);
                    }
                case 12:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "firstThird" -> rulett.firstThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "12" -> rulett.numberWin(person);
                    }
                case 13:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line1" -> rulett.line1Win(person);
                        case "13"->rulett.numberWin(person);
                    }
                case 14:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "14" -> rulett.numberWin(person);
                    }
                case 15:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "15"->rulett.numberWin(person);
                    }
                case 16:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line1" -> rulett.line1Win(person);
                        case "16" -> rulett.numberWin(person);
                    }
                case 17:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "17"->rulett.numberWin(person);
                    }
                case 18:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween1and18" -> rulett.numbersbetwen1and18Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "18" -> rulett.numberWin(person);
                    }
                case 19:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line1" -> rulett.line1Win(person);
                        case "19"->rulett.numberWin(person);

                    }
                case 20:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "20"->rulett.numberWin(person);
                    }
                case 21:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "21"->rulett.numberWin(person);
                    }
                case 22:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line1" -> rulett.line1Win(person);
                        case "22"->rulett.numberWin(person);
                    }
                case 23:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "23"->rulett.numberWin(person);
                    }
                case 24:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "secondThird" -> rulett.secondThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "24"->rulett.numberWin(person);
                    }
                case 25:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line1" -> rulett.line1Win(person);
                        case "25"->rulett.numberWin(person);
                    }
                case 26:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "26"->rulett.numberWin(person);
                    }
                case 27:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "27"->rulett.numberWin(person);
                    }
                case 28:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line1" -> rulett.line1Win(person);
                        case "28"->rulett.numberWin(person);
                    }
                case 29:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "29"->rulett.numberWin(person);
                    }
                case 30:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "30"->rulett.numberWin(person);

                    } case 31:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line1" -> rulett.line1Win(person);
                        case "31"->rulett.numberWin(person);
                    }
                case 32:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "32"->rulett.numberWin(person);
                    }
                case 33:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "33"->rulett.numberWin(person);
                    }
                case 34:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line1" -> rulett.line1Win(person);
                        case "34"->rulett.numberWin(person);
                    }
                case 35:
                    switch (person.getChosenCombination()) {
                        case "black" -> rulett.blackWin(person);
                        case "odd" -> rulett.oddWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line2" -> rulett.line2Win(person);
                        case "35"->rulett.numberWin(person);
                    }
                case 36:
                    switch (person.getChosenCombination()) {
                        case "red" -> rulett.redWin(person);
                        case "even" -> rulett.evenWin(person);
                        case "thirdThird" -> rulett.thirdThirdWin(person);
                        case "numbersbetween19and36" -> rulett.numbersbetwen19an36Win(person);
                        case "line3" -> rulett.line3Win(person);
                        case "36"->rulett.numberWin(person);
                    }
        }
    }
}
