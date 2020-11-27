public class AlwaysRedStrategy implements Strategy {


    @Override
    public void bet(Rulett rulett, Person person) {
        if (rulett.getRound() == 1) {
            person.setBet(100);
            rulett.red(person.getBet());
        } else {
            rulett.red(person.getBet());
            person.setBet(person.getBet() * 2);
        }

    }
}