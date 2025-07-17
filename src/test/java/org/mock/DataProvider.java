package org.mock;

import org.mock.persistence.entity.Player;

import java.util.List;

public class DataProvider {

    public static List<Player> playerListMock(){
        System.out.println("-> Obteniendo listado player / mock");
        return List.of(
                new Player(1L, "nombre 1", "Team 1", "Posicion 11"),
                new Player(2L, "nombre 23", "Team 2", "Posicion 12"),
                new Player(3L, "nombre 12", "Team 2", "Posicion 05"),
                new Player(4L, "nombre 4", "Team 3", "Posicion 13"),
                new Player(5L, "nombre 3", "Team 3", "Posicion 07"),
                new Player(6L, "nombre 2", "Team 4", "Posicion 01"),
                new Player(7L, "nombre 11", "Team 5", "Posicion 03")
        );
    }

    public static Player playerMock(){
        return new Player(1L, "nombre 1", "Team 1", "Posicion 11");
    }

    public  static Player newPlayerMock(){
        Player player = new Player(21L, "name", "Teams", "GOOD");
        return player;
    }
}
