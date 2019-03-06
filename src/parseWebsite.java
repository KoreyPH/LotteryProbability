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

        Elements tables = document.select("table");


        Elements rows = tables.select("tr");

        for (Element table : tables) {
            //new table means a new game
        Elements currentRows = table.select("tr");
        System.out.print(currentRows.text());
          //  Game game = new Game();

            for (Element row : rows) {
                //each row represents a prize

                System.out.print(table.text());
                System.out.print(row.text() + '\n');

            }

        }
    }


}
