package org.mock.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mock.DataProvider;
import org.mock.persistence.entity.Player;
import org.mock.repository.PlayerRepositoryImpl;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepositoryImpl playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    /*
    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }
     */

    @Test
    void testFindAll(){
        /*
        // Given
        PlayerRepositoryImpl playerRepository = mock(PlayerRepositoryImpl.class); // Simulacion
        PlayerServiceImpl playerService = new PlayerServiceImpl(playerRepository);
         */

        // When
        when(playerRepository.findAll()).thenReturn(DataProvider.playerListMock());
        List<Player> result = playerService.findAll();

        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals("nombre 1", result.get(0).getName());
        assertEquals("Team 1", result.get(0).getTeam());
        assertEquals("Posicion 11", result.get(0).getPosition());
    }

    @Test
    void testFindById(){
        // Give
        Long id = 1L;

        // When
        when(this.playerRepository.findById(anyLong())).thenReturn(DataProvider.playerMock());
        Player player = this.playerService.findById(id);

        // Then
        assertNotNull(player);
        assertEquals("nombre 1", player.getName());
        assertEquals("Team 1", player.getTeam());
        assertEquals("Posicion 11", player.getPosition());
        //verify(this.playerRepository, times(1)).findById(anyLong());
        verify(this.playerRepository).findById(anyLong());
    }

    @Test
    void testSave(){
        // Give
        Player player = DataProvider.newPlayerMock();

        //When
        this.playerService.save(player);

        //Then
        ArgumentCaptor<Player> playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
        verify(this.playerRepository).save(any(Player.class));
        verify(this.playerRepository).save(playerArgumentCaptor.capture());
        assertEquals(21, playerArgumentCaptor.getValue().getId());
        assertEquals("name", playerArgumentCaptor.getValue().getName());
    }

    @Test
    void testDeleteId(){
        // Given
        Long id = 1L;

        // When
        this.playerService.deleteById(id);

        // Then
        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(this.playerRepository).deleteById(anyLong());
        verify(this.playerRepository).deleteById(longArgumentCaptor.capture());
        assertEquals(1L, longArgumentCaptor.getValue());
    }
}
