/**
 * @author Korey Heiser
 * entrypoint of program
 *
 *
 */

import java.util.ArrayList;

public class LotteryProbability {


    public static void main(String[] args) {

        long startTime = System.nanoTime();

        ArrayList<Game> gamesList = parseWebsite.scrapeWebsite();

        System.out.print("Displaying the ticket with the overall best odds: \n");

        int bestOddsIndex = 0;
        double lowestOdds = 999999999.99;
        for (int i = 0; i < gamesList.size(); i++) {

            if (gamesList.get(i).getOdds() < lowestOdds) {
                bestOddsIndex = i;
                lowestOdds = gamesList.get(i).getOdds();
            }

        }
        Game winner = gamesList.get(bestOddsIndex);

        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000000;
        System.out.print("The current best odds game is " + winner.getTitle() + " with odds of winning being 1 in " + lowestOdds + ".\n");
        System.out.print("The cost of this ticket is " + winner.getCost() + " dollars");

        System.out.print("\nCompleted in " + totalTime + " seconds");

    }
}
