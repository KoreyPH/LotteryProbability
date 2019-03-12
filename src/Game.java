import java.util.ArrayList;

public class Game {
    private String title;
    private int cost;
    private double odds;
    private ArrayList<Prize> prizes;
    private int remainingWinners;



   public Game(String title, int cost) {
        this.title = title;
        this.cost = cost;
        prizes = new ArrayList<>();
   }

   public Game(String title) {
        this.title = title;
       prizes = new ArrayList<>();
   }

    public double calculateExpectedValue() {
        double expectedValue = 0;

        ArrayList<Prize> prizes = getPrizes();
        int investment = getCost();

        //1 in x odds as a percentage chance
        double percentOdds = 1/getOdds();
        //what the chance is in losing the game
        double losingChance = 1 - percentOdds;


        for (int i = 0; i < prizes.size(); i++) {

            Prize currentPrize = prizes.get(i);

            int profitForWin = currentPrize.getValue() - getCost();

            //amount of prize divided by total amount of winning tickets left
            //type casting to doubles for accurate division
            double probabilityGivenWin = (double) currentPrize.getRemainingPrizeCount() / (double) getRemainingWinners();

            //probability that you will win this prize. The probability of winning a prize along with winning this particular prize
            double probabilityOfWinningThisPrize = probabilityGivenWin * percentOdds;

            //winning probability multiplied by profit to get an expected value of this event
            double pwin = probabilityOfWinningThisPrize * profitForWin;

            expectedValue += pwin;


        }
        //we need to include the loss for losing money by not winning
        expectedValue += (-(investment) * losingChance);
        return expectedValue;
    }

    public String getTitle() {
        return title;
    }


    public int getCost() {
        return cost;
    }

    public ArrayList<Prize> getPrizes() {
        return prizes;
    }

    public void addPrize(Prize prize) {
        prizes.add(prize);
    }

    public void setCost(int cost) {
       this.cost = cost;
    }

    public void setOdds(double odds) {
       this.odds = odds;
    }

    public double getOdds() {
       return odds;
    }

    public int getRemainingWinners() {
       return remainingWinners;
    }

    public void setRemainingWinners(int remainingWinners) {
       this.remainingWinners = remainingWinners;
    }

}
