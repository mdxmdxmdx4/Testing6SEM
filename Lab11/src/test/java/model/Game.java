package model;

import java.util.Objects;

public class Game {
    private String game_name;

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String title) {
        this.game_name = title;
    }

    public Game(String game_name) {
        this.game_name = game_name;
    }

    @Override
    public String toString() {
        return "Game{" +
                "game title ='" + game_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Objects.equals(game_name, game.game_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_name);
    }
}
