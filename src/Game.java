import java.util.ArrayList;

public class Game {
    private String title;
    private double cost;
    private ArrayList<Prize> prizes;


    public Game(String title, double cost, ArrayList<Prize> Prizes) {
        this.title = title;
        this.cost = cost;
        this.prizes = Prizes;

    }

   public Game(String title, double cost) {
        this.title = title;
        this.cost = cost;
        prizes = new ArrayList<>();
   }

    public String getTitle() {
        return title;
    }


    public double getCost() {
        return cost;
    }

    public ArrayList<Prize> getPrizes() {
        return prizes;
    }

    public void addPrize(Prize prize) {
        prizes.add(prize);
    }

}
