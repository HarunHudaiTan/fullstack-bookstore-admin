package com.project.bookstore.service;


import com.project.bookstore.dto.request.CreateUserRequest;
import com.project.bookstore.dto.request.UpdateUserRequest;
import com.project.bookstore.model.User;
import com.project.bookstore.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(EntityNotFoundException::new);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public User getUserById(Long id) {
        return findUserById(id);
    }

    public List<User> listAllUsers()         {
        return userRepository.findAll();
    }

    public User updateUser(Long id, UpdateUserRequest request) {
        User user = findUserById(id);
        User updatedUser = new User(user.getId(),
                request.getName(),
                request.getSurname(),
                request.getUsername(),
                user.getPassword(),
                request.getShippingAddress(),
                request.getBillingAddress(),
                request.getAuthorities(),
                request.isAccountNonExpired(),
                request.isAccountNonLocked(),
                request.isCredentialsNonExpired(),
                request.isEnabled());
        return userRepository.save(updatedUser);
    }


    public User createUser(CreateUserRequest request) {
        User user = new User(
                request.getName(),
                request.getSurname(),
                request.getUsername(),
                encoder.encode(request.getPassword()),
                request.getAuthorities(),
                true,
                true,
                true,
                true);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
