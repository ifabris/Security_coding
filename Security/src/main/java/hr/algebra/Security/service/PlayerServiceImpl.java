package hr.algebra.Security.service;

import hr.algebra.Security.dto.PlayerDTO;
import hr.algebra.Security.model.Player;
import hr.algebra.Security.repo.PlayerRepository;
import hr.algebra.Security.request.PlayerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final JdbcTemplate jdbcTemplate;

    public PlayerServiceImpl(PlayerRepository playerRepository, JdbcTemplate jdbcTemplate){
        this.playerRepository = playerRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PlayerDTO> findAll() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map(PlayerDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<PlayerDTO> findByTeamUnsafe(String team) {
        String unsafeSql = "select * from players where team ='"+ team +"'";

        // Log the generated SQL query
        System.out.println("Generated SQL Query: " + unsafeSql);

        List<Player> players = jdbcTemplate.query(
                unsafeSql,
                (rs, rowNum) -> new Player(
                        rs.getString("name"),
                        rs.getString("team"),
                        rs.getInt("age"),
                        rs.getFloat("height"),
                        rs.getFloat("weight"),
                        rs.getString("college"),
                        rs.getString("country"),
                        rs.getInt("draft_year")
                )
        );

        return players.stream().map(PlayerDTO::new).collect(Collectors.toList());
    }


    @Override
    public PlayerDTO findById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Player with that id was not found")
                );
        return  new PlayerDTO(player);
    }

    @Override
    public void create(PlayerRequest playerRequest) {
        try {
            Player player = new Player();
            player.setName(playerRequest.getName());
            player.setTeam(playerRequest.getTeam());
            player.setAge(playerRequest.getAge());
            player.setWeight(playerRequest.getWeight());
            player.setHeight(playerRequest.getHeight());
            player.setCollege(playerRequest.getCollege());
            player.setCountry(playerRequest.getCountry());
            player.setDraftYear(playerRequest.getDraftYear());
            playerRepository.save(player);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Player with that name already exists");
        }
    }

    @Override
    public void updateById(Long id, PlayerRequest playerRequest) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()){
            Player updatePlayer = player.get();
            updatePlayer.setName(playerRequest.getName());
            updatePlayer.setTeam(playerRequest.getTeam());
            updatePlayer.setAge(playerRequest.getAge());
            updatePlayer.setWeight(playerRequest.getWeight());
            updatePlayer.setHeight(playerRequest.getHeight());
            updatePlayer.setCollege(playerRequest.getCollege());
            updatePlayer.setCountry(playerRequest.getCountry());
            updatePlayer.setDraftYear(playerRequest.getDraftYear());
            playerRepository.save(updatePlayer);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player with that ID does not exist.");
        }
    }
    @Override
    public void deleteById(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()){
            playerRepository.deleteById(id);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player with that ID does not exist.");
        }
    }
}
