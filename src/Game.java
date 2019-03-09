import java.util.ArrayList;

public class Game {
    private String title;
    private int cost;
    private ArrayList<Prize> prizes;


   public Game(String title, int cost) {
        this.title = title;
        this.cost = cost;
        prizes = new ArrayList<>();
   }

   public Game(String title) {
        this.title = title;
       prizes = new ArrayList<>();
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

}
