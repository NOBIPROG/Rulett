public class AlwaysRedStrategy implements Strategy {


    @Override
    public void bet(Rulett rulett, Person person) {
        if (Rulett.getRound() == 1) {
            person.setBet(100);
        } else {
            rulett.red(person.getBet());
            person.setBet(person.getBet() * 2);
        }

    }
}