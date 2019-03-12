/**
 * parse https://www.nclottery.com/ScratchOffPrizes
 **/

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class parseWebsite {





    public static ArrayList<Game> scrapeWebsite() {

        Document document = null;
        try {
            document = Jsoup.connect("https://www.nclottery.com/ScratchOffPrizes").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //create a list of games
         ArrayList<Game> gamesList = new ArrayList<>();

        Elements tables = document.select("table[class=datatable]");


        for (Element table : tables) {
            //new table means a new game

            Elements gameName = table.select("[class=gamename]").select("a");
            String name = gameName.text();
            int remainingWinners = 0;


            String hyperlink = "https://www.nclottery.com" + gameName.attr("href");
            Document cardPage = null;

            //connect to ticket's details page
            try {
                cardPage = Jsoup.connect(hyperlink).get();
            } catch (IOException exception) {
                exception.printStackTrace();
            }

            Element ticketData = cardPage.select("table[class=juxtable]").first();
            Element valueRow = ticketData.select("tr").get(1).select("td").get(1);
            Element oddsRow =  ticketData.select("tr").get(3).select("td").get(1);

            int value = Integer.parseInt(valueRow.text().substring(1).replaceAll(",",""));
            double odds = Double.valueOf(oddsRow.text().substring(4,oddsRow.text().length() - 1));

            gamesList.add(new Game(name));

            Game currentGame = gamesList.get(gamesList.size() - 1);

            currentGame.setOdds(odds);
            currentGame.setCost(value);

            for (Element row : table.select("tr")) {
                //new row denotes a prize

                Elements tds = row.select("td");

                //ensure row has necessary amount of info to parse
                if (tds.size() == 4) {
                    //selects <a href> tag containing name of prize

                    //integers are parsed from string data on website; substrings begin
                    //for value and remaining value to remove dollar symbol. ReplaceAll
                    //removes commas from numbers larger than 999

                    int prizeValue = Integer.parseInt(tds.get(0).text().substring(1).replaceAll(",",""));
                    int originalCount = Integer.parseInt(tds.get(1).text().replaceAll(",",""));
                    int remainingCount = Integer.parseInt(tds.get(2).text().replaceAll(",",""));
                    int remainingValue = Integer.parseInt(tds.get(3).text().substring(1).replaceAll(",",""));

                    remainingWinners += remainingCount;


                    Prize prize = new Prize(prizeValue, originalCount, remainingCount, remainingValue);

                    currentGame.addPrize(prize);
                }
                    //after all the rows, we know how many prizes are left
                    currentGame.setRemainingWinners(remainingWinners);
            }

        }

    return gamesList;
    }


}
