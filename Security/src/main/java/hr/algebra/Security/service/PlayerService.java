package hr.algebra.Security.service;

import hr.algebra.Security.dto.PlayerDTO;
import hr.algebra.Security.request.PlayerRequest;

import java.util.List;

public interface PlayerService {

    List<PlayerDTO> findAll();

    List<PlayerDTO> findByTeamUnsafe(String team);

    PlayerDTO findById(Long id);


    void create(PlayerRequest playerRequest);

    void updateById(Long id, PlayerRequest PlayerRequest);

    void deleteById(Long id);
}
