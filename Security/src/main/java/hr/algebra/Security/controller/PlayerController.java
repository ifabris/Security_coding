package hr.algebra.Security.controller;

import hr.algebra.Security.dto.PlayerDTO;
import hr.algebra.Security.request.PlayerRequest;
import hr.algebra.Security.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all")
    public List<PlayerDTO> getAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/unsafe/{team}")
    public List<PlayerDTO> getPlayerByTeamUnsafe(@PathVariable String team) {
        return playerService.findByTeamUnsafe(team);
    }


    @GetMapping("/id/{id}")
    public PlayerDTO getPlayerById(@PathVariable Long id) {
    return playerService.findById(id);
    }

    @PostMapping()
    public void createPlayer(@RequestBody PlayerRequest playerRequest) {
         playerService.create(playerRequest);
    }

    @PutMapping("/id/{id}")
    public void updatePlayer(@PathVariable Long id, @RequestBody @Valid PlayerRequest playerRequest) {
        playerService.updateById(id,playerRequest);
    }

    @DeleteMapping("/id/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deleteById(id);
    }
}

