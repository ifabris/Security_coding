package hr.algebra.Security.controller;


import hr.algebra.Security.dto.UserDTO;
import hr.algebra.Security.request.UserLoginRequest;
import hr.algebra.Security.request.UserRequest;
import hr.algebra.Security.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public List<UserDTO> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/login")
    public UserDTO loginUser(@RequestBody @Valid UserLoginRequest userLoginRequest){
        return userService.login(userLoginRequest);
    }

    @PostMapping()
    public void createUser(@RequestBody @Valid UserRequest userRequest){
        userService.register(userRequest);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody @Valid UserRequest userRequest){
        userService.register(userRequest);
    }

    @PutMapping("/{id}")
    public void updateUserById(@PathVariable Long id, @RequestBody @Valid UserRequest userRequest){
        userService.updateById(id, userRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteById(id);
    }

    @PostMapping("/insecureRegister")
    public void registerUserInsecure(@RequestBody @Valid UserRequest userRequest){
        userService.registerInsecure(userRequest);
    }
}
