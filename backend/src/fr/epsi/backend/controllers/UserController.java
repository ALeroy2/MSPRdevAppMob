package fr.epsi.backend.controllers;

import fr.epsi.backend.domain.User;
import fr.epsi.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;

    // @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signUp")
    public Long addUser(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        this.userService.addUser(user);
        return user.getId();
    }
}
