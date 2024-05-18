package service;

import model.Game;

public class GameGenerator {
    public static final String TESTDATA_GAME_MARKET_TEST = "testdata.game.game_name_search";
    public static final String TESTDATA_GAME_HUB_TEST = "testdata.game.game_hub_search";

    public static Game withTitleFromProperty(){
        return new Game(TestDataReader.getTestData(TESTDATA_GAME_MARKET_TEST));
    }
    public static  Game gameForHubSearch(){
        return  new Game(TestDataReader.getTestData(TESTDATA_GAME_HUB_TEST));
    }

    public static Game withEmptyGameName(){
        return new Game("");
    }
}
