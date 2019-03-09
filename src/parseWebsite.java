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


        Elements rows = tables.select("tr");

        for (Element table : tables) {
            //new table means a new game

            Elements gameName = table.select("[class=gamename]").select("a");
            String name = gameName.text();

            gamesList.add(new Game(name));

            Game currentGame = gamesList.get(gamesList.size() - 1);
            int count = 0;

            for (Element row : table.select("tr")) {
                //new row denotes a prize

                Elements tds = row.select("td");

                //ensure row has necessary amount of info to parse
                if (tds.size() == 4) {
                    //selects <a href> tag containing name of prize

                    int value = Integer.parseInt(tds.get(0).text().substring(1).replaceAll(",",""));
                    int originalCount = Integer.parseInt(tds.get(1).text().replaceAll(",",""));
                    int remainingCount = Integer.parseInt(tds.get(2).text().replaceAll(",",""));
                    int remainingValue = Integer.parseInt(tds.get(3).text().substring(1).replaceAll(",",""));

                    Prize prize = new Prize(value, originalCount, remainingCount, remainingValue);

                    currentGame.addPrize(prize);


                    //set the ticket price w/ final prize value
                    if (count == table.childNodeSize() - 1) {
                        //set ticket price w/ value
                       currentGame.setCost(value);
                    }
                }

            }


        }

    return gamesList;
    }


}
