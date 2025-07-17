package org.mock.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mock.persistence.entity.Player;

import java.util.List;

public class PlayerRepositoryTest {

    private PlayerRepositoryImpl playerRepository;

    @BeforeEach
    void init(){
        playerRepository = new PlayerRepositoryImpl();
    }

    @Test
    void testFindAll(){
        // Given
        // When
        List<Player> result =playerRepository.findAll();
        // Then
        assertEquals("nombre 1", result.get(0).getName());
        assertEquals("Team 1", result.get(0).getTeam());
    }

    @Test
    void testFindById(){
        // Given
        Long id = 1L;
        // When
        Player player = playerRepository.findById(id);
        // Then
        assertEquals("nombre 1", player.getName());
        assertEquals("Team 1", player.getTeam());
    }

    @Test
    void testFindByIdIsNotExist(){
        // Given
        Long id = 100L;
        // When

        // Then
        assertThrows(RuntimeException.class, () ->{
            playerRepository.findById(100L);
        });
    }

    @Test
    void testSave(){
        // Given
        Player player = new Player(22L,"Name1", "Team1", "Position1");
        // When
        playerRepository.save(player);
        // Then
        assertEquals("Name1",playerRepository.findById(22L).getName());
    }

    @Test
    void testDeleteById(){
        // Given
        Long id = 2L;
        // When
        playerRepository.deleteById(id);
        // Then
        assertThrows(RuntimeException.class,()->{
            playerRepository.findById(id);
        } );
    }
}
