import java.util.ArrayList;

public class NowItWillTheAnotherColorPlayer extends Person {

   private ArrayList<String> winnerColor;
    private int random;


    public NowItWillTheAnotherColorPlayer(String name, int valet) {
        super(name, valet);
        setStrategy("nowItWillTheAnotherColorPlayer");
        random = (int)(Math.random()*10+4);
    }

    @Override
    public void bet(Rulett rulett) {
        int randomBetValue = (int)(Math.random()*rulett.getMaxBet()+rulett.getMinBet());
        if (rulett.getRound() > 0){
            switch (rulett.getNr()){
                case 2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35 : winnerColor.add("black");
                break;
                case 1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36 : winnerColor.add("red");
                break;
                default:
                    break;
            }
        }
        if (rulett.getRound() >= random){
                if (winnerColor.get(winnerColor.size()-2).equals(winnerColor.get(winnerColor.size()-1)) && winnerColor.get(winnerColor.size()-3).equals(winnerColor.get(winnerColor.size()-1)) && winnerColor.get(winnerColor.size()-4).equals(winnerColor.get(winnerColor.size()-1)) && winnerColor.get(winnerColor.size()-1).equals("black")){
                    setChosenCombination("red");
                    if (getValet() >= randomBetValue) {
                        setBet(randomBetValue);
                    }
                    else {
                        setBet(getValet());
                    }
                    setValet(getValet() - getBet());

                }

        }else if (winnerColor.get(winnerColor.size()-2).equals(winnerColor.get(winnerColor.size()-1)) && winnerColor.get(winnerColor.size()-3).equals(winnerColor.get(winnerColor.size()-1)) && winnerColor.get(winnerColor.size()-4).equals(winnerColor.get(winnerColor.size()-1)) && winnerColor.get(winnerColor.size()-1).equals("red")){
            setChosenCombination("black");
            setBet(Math.min(getValet(), randomBetValue));
            setValet(getValet() - getBet());
        }

    }
}
