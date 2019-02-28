import java.util.ArrayList;

public class Game {
    private String title;
    private double cost;
    private ArrayList<Prize> Prizes;


    public Game(String title, double cost, ArrayList<Prize> Prizes) {
        this.title = title;
        this.cost = cost;
        this.Prizes = Prizes;

    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }

    public ArrayList<Prize> getPrizes() {
        return Prizes;
    }
}
