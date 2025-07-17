package org.mock.repository;

import org.mock.persistence.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImpl implements IplayerRepository{
    private List<Player> playersDataBase = new ArrayList<>(List.of(
            new Player(1L, "nombre 1", "Team 1", "Posicion 11"),
            new Player(2L, "nombre 23", "Team 2", "Posicion 12"),
            new Player(3L, "nombre 12", "Team 2", "Posicion 05"),
            new Player(4L, "nombre 4", "Team 3", "Posicion 13"),
            new Player(5L, "nombre 3", "Team 3", "Posicion 07"),
            new Player(6L, "nombre 2", "Team 4", "Posicion 01"),
            new Player(7L, "nombre 11", "Team 5", "Posicion 03")
    ));

    @Override
    public List<Player> findAll() {
        System.out.println("-> Metodo findAll real");
        return this.playersDataBase;
    }

    @Override
    public Player findById(Long id) {
        System.out.println("-> Metodo findById real");

        return this.playersDataBase.stream()
                .filter(player -> player.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void save(Player player) {
        System.out.println("-> Metodo save real");
        this.playersDataBase.add(player);

    }

    @Override
    public void deleteById(Long id) {
        System.out.println("-> Metodo deleteById real");
        this.playersDataBase = this.playersDataBase.stream()
                .filter( player -> player.getId() != id)
                .toList();
    }
}
