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

    private ArrayList<Game> games;


    public static void getWebsite() {
        Document document = null;
        try {
            document = Jsoup.connect("https://www.nclottery.com/ScratchOffPrizes").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements tables = document.select("table[class=datatable]");


        Elements rows = tables.select("tr");

        for (Element table : tables) {
            //new table means a new game
          //  Game game = new Game();
            for (Element row : table.select("tr")) {

                Elements gameName = table.select("[class=gamename]");
                Elements tds = row.select("td");
                System.out.print(tds.size());
                System.out.print(gameName.text());
                if (tds.size() == 4) {
                    String value = tds.get(0).text();
                    String originalCount = tds.get(1).text();
                    String remainingCount = tds.get(2).text();
                    String remainingValue = tds.get(3).text();
                }


               // System.out.print(table.text());
                //System.out.print(row.text() + '\n');

            }

        }
    }


}
