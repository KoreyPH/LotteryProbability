/**
 * parse https://www.nclottery.com/ScratchOffPrizes
 **/

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class parseWebsite {


    public static void getWebsite() {
        Document document = null;
        try {
            document = Jsoup.connect("https://www.nclottery.com/ScratchOffPrizes").get();


        } catch (IOException e) {
            e.printStackTrace();
        }
        if (document == null) {
            throw new IOException;
        }
        for(Element table : document.select("table datatable")) {
            System.out.println(table.text());
        }
        //box cloudfx databox price_*
    }


}
