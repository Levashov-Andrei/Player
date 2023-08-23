package ru.Netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test

    public void twoRegisteredPlayers() {
        Player petya = new Player(1, "Петя", 10);
        Player ivan = new Player(2, "Иван", 20);
        Game game = new Game();

        game.register(petya);
        game.register(ivan);
        int actual = game.round("Иван", "Петя");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void twoRegisteredPlayersWonTheSecond() {
        Player petya = new Player(1, "Петя", 20);
        Player ivan = new Player(2, "Иван", 10);
        Game game = new Game();

        game.register(petya);
        game.register(ivan);
        int actual = game.round("Иван", "Петя");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void twoRegisteredPlayersDraw() {
        Player petya = new Player(1, "Петя", 20);
        Player ivan = new Player(2, "Иван", 20);
        Game game = new Game();

        game.register(petya);
        game.register(ivan);
        int actual = game.round("Иван", "Петя");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void theFirstPlayerRegistered() {
        Player petya = new Player(1, "Петя", 20);
        Player ivan = new Player(1, "Иван", 10);
        Game game = new Game();

        game.register(petya);
        game.register(ivan);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Петя", "Саша"));

    }

    @Test
    public void theSecondPlayerRegistered() {
        Player petya = new Player(1, "Петя", 20);
        Player ivan = new Player(1, "Иван", 10);
        Game game = new Game();

        game.register(petya);
        game.register(ivan);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Алексей", "Иван"));
    }

    @Test
    public void twoPlayersNotRegistered() {
        Player petya = new Player(1, "Петя", 20);
        Player ivan = new Player(1, "Иван", 10);
        Game game = new Game();

        game.register(petya);
        game.register(ivan);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Алексей", "Сергей"));
    }

}
