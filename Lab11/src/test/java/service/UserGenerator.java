package service;

import model.Group;
import model.User;

public class UserGenerator {
    public static final String TESTDATA_USER_SEARCH_TEST = "testdata.user.username_search";

    public static User withTitleFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_SEARCH_TEST));
    }
    public static User withConcreteUsername(){
        return new User("ДОМОВОЙ");
    }

    public static User withEmptyGameName(){
        return new User("");
    }
}
