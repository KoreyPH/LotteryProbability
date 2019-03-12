/**
 * @author Korey Heiser
 * entrypoint of program
 *
 *
 */

import java.util.ArrayList;

public class LotteryProbability {


    public static int gameWithBestExpectedValue(ArrayList<Game> games) {
        int bestGameIndex = 0;
        for (int i = 0; i < games.size(); i++) {

            double bestMargin = Double.MIN_VALUE;


            Game currentGame = games.get(i);
            double currentExpectedValue = currentGame.calculateExpectedValue();

            if (currentExpectedValue > bestMargin) {
                bestMargin = currentExpectedValue;
                bestGameIndex = i;
            }

        }

        return bestGameIndex;
    }


    public static void main(String[] args) {

        long startTime = System.nanoTime();

        ArrayList<Game> gamesList = parseWebsite.scrapeWebsite();


        System.out.print("Displaying the ticket with the overall best odds: \n");

        int bestOddsIndex = 0;
        double lowestOdds = Double.MAX_VALUE;
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
        System.out.print("The cost of this ticket is " + winner.getCost() + " dollars\n");

        int bestMarginGame = gameWithBestExpectedValue(gamesList);
        System.out.print("The game with the best expected value is " + gamesList.get(bestMarginGame).getTitle() + " with E(x) =  " + gamesList.get(bestMarginGame).calculateExpectedValue());

        System.out.print("\nCompleted in " + totalTime + " seconds");

    }
}
