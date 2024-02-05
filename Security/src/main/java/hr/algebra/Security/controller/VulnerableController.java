package hr.algebra.Security.controller;

import hr.algebra.Security.request.PlayerRequest;
import hr.algebra.Security.service.PlayerService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.security.Provider;

@RestController
@RequestMapping("/vuln")
public class VulnerableController {

    private final PlayerService playerService;

    public VulnerableController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/xss")
    public String executeXSS(@RequestParam(name = "param") String param, Model model) {
        model.addAttribute("param", param);
        return "xss";
    }

 //   @GetMapping("/xssSafe")
//    public String executeSafe(@RequestParam(name = "param") String param, Model model) {
        // Sanitize or encode the user input
 //       String sanitizedParam = HtmlUtils.htmlEscape(param);

        // Add the sanitized input to the model
 //       model.addAttribute("param", sanitizedParam);

        // Return the view
  //      return "xss";
 //   }

}
