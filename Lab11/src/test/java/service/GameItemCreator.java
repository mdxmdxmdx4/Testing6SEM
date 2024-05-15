package service;

import model.GameItem;

public class GameItemCreator {
    public static final String TESTDATA_GAME_ITEM = "testdata.gameItem.title";

    public static GameItem withTitleFromProperty(){
        return new GameItem(TestDataReader.getTestData(TESTDATA_GAME_ITEM));
    }

    public static GameItem withEmptyGameItemTitle(){
        return new GameItem("");
    }

}

