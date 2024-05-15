package service;

import model.Game;

public class GameGenerator {
    public static final String TESTDATA_GAME = "testdata.game.game_name";

    public static Game withTitleFromProperty(){
        return new Game(TestDataReader.getTestData(TESTDATA_GAME));
    }

    public static Game withEmptyGameName(){
        return new Game("");
    }
}
