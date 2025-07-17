package org.mock.repository;

import org.mock.persistence.entity.Player;

import java.util.List;

public interface IplayerRepository {

    List<Player> findAll();

    Player findById(Long id);

    void save(Player player);

    void deleteById(Long id);


}
