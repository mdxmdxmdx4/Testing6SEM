package service;

import model.Game;
import model.Group;

public class GroupGenerator {
    public static final String TESTDATA_GROUP_SEARCH_TEST = "testdata.group.group_name_search";

    public static Group withTitleFromProperty(){
        return new Group(TestDataReader.getTestData(TESTDATA_GROUP_SEARCH_TEST));
    }

    public static Group withEmptyGameName(){
        return new Group("");
    }
}
