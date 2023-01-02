package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddGameTwice() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.publishGame("Нетология Баттл Онлайн", "Аркады");

        List<Game> expected = new ArrayList<>();
        expected.add(game);
        List<Game> actual = store.getGames();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldAddPlayTime() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Дима", 5);
        store.addPlayTime("Дима", 5);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Дима", 10);
        Map<String, Integer> actual = store.getPlayedTime();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetMostPlayer() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Дима", 5);
        store.addPlayTime("Петя", 10);

        List<String> expected = new ArrayList<>();
        expected.add("Петя");
        List<String> actual = store.getMostPlayer();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetMostPlayerWithNoPlayers() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        List<String> expected = null;
        List<String> actual = store.getMostPlayer();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetMostPlayerWithSecondPlayersEqualsPlayTime() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Дима", 5);
        store.addPlayTime("Петя", 5);

        List<String> expected = new ArrayList<>();
        expected.add(0, "Дима");
        expected.add(1, "Петя");
        List<String> actual = store.getMostPlayer();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetSumPlayedTime() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Дима", 5);
        store.addPlayTime("Петя", 5);

        int expected = 10;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetSumPlayedTimeNoPlayGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        int expected = 0;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetMostPlayerWithZeroTime() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Дима", 0);

        List<String> expected = null;
        List<String> actual = store.getMostPlayer();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetMostPlayerIfMostPlayedOneHour() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Дима", 0);
        store.addPlayTime("Петя", 1);

        List<String> expected = new ArrayList<>();
        expected.add("Петя");
        List<String> actual = store.getMostPlayer();
        assertEquals(expected, actual);

    }

}
