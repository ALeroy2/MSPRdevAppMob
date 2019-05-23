package fr.epsi.backend.services;

import fr.epsi.backend.daI.IUser;
import fr.epsi.backend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    IUser dao;

    public void addUser(User user) {
        this.dao.save(user);
    }

    public User connectUser(String email, String password) {
        AtomicReference<User> connectedUser = null;

        this.dao.findAll().forEach(user -> {
            if (user.getPassword() == password
                && user.getEmail() == email) {
                connectedUser.set(user);
            }
        });

        return connectedUser.get();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Objects.requireNonNull(email);
        User user = dao.findByEmail(email);
        if (user == null) { new UsernameNotFoundException("User not found"); }
        return user;
    }
}
