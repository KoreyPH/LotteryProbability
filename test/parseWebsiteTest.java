import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;



public class parseWebsiteTest {

    //number of games listed on the website as of 3/9/19
    public static final int NUM_GAMES = 78;


    @Test
    public void scrapeWebsite() {

        ArrayList<Game> gamesList = parseWebsite.scrapeWebsite();

        assertEquals(NUM_GAMES, gamesList.size());
        assertEquals("777", gamesList.get(0).getTitle());
        assertEquals(277777, gamesList.get(0).getPrizes().get(0).getValue());
        assertEquals(5, gamesList.get(0).getCost());

    }


}