package by.chertko.delivery.Service.impl;

import by.chertko.delivery.Dto.RegisterUserDto;
import by.chertko.delivery.Entity.Role;
import by.chertko.delivery.Entity.User;
import by.chertko.delivery.Logging.Loggable;
import by.chertko.delivery.Repository.RoleRepository;
import by.chertko.delivery.Repository.UserRepository;
import by.chertko.delivery.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Loggable
    public User register(RegisterUserDto userDto) throws Exception {
        if (userRepository.findByName(userDto.getName()) != null) {
            throw new Exception("User has already registered");
        }

        if(!userDto.getPassword().equals(userDto.getRepeatPassword())) {
            throw new Exception("Passwords are not equal");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role roleUser = roleRepository.findByRole("user");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        return userRepository.save(user);
    }

    @Override
    @Loggable
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Loggable
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    @Loggable
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Loggable
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
