package org.mock;

import org.mock.persistence.entity.Player;
import org.mock.repository.PlayerRepositoryImpl;
import org.mock.service.PlayerServiceImpl;

public class Main {
    public static void main(String[] args) {
        PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl();
        PlayerServiceImpl playerService = new PlayerServiceImpl(playerRepository);

        /*

        System.out.println(playerService.findAll());

        System.out.println(playerService.findById(1L));

        playerService.deleteById(1L);
        System.out.println(playerService.findAll());

        Player player = new Player(99L,"player 12","tema 1212", "posicion122");
        playerService.save(player);
        System.out.println(playerService.findAll());
         */


    }
}