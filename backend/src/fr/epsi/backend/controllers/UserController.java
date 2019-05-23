package fr.epsi.backend.controllers;

import fr.epsi.backend.domain.User;
import fr.epsi.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/signUp")
    public void addUser(@RequestParam(name = "firstname") String firstname
                        , @RequestParam(name = "lastname") String lastname
                        , @RequestParam(name = "email") String email
                        , @RequestParam(name = "password") String password) {

        User user = new User(firstname, lastname, email, new BCryptPasswordEncoder().encode(password));
        this.userService.addUser(user);
    }

    @RequestMapping("/login")
    public void connectUser(@RequestParam(name = "email") String email
                            , @RequestParam(name = "password") String password) {
        User user = this.userService.connectUser(email, new BCryptPasswordEncoder().encode(password));
    }
}
