package model;

import java.util.Objects;

public class GameItem {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GameItem(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "GameItem{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameItem)) return false;
        GameItem gameItem = (GameItem) o;
        return Objects.equals(title, gameItem.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
