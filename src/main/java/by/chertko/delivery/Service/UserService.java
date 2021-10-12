package by.chertko.delivery.Service;

import by.chertko.delivery.Dto.RegisterUserDto;
import by.chertko.delivery.Entity.User;

import java.util.List;

public interface UserService {
    User register(RegisterUserDto userDto) throws Exception;
    List<User> getAllUsers();
    User findByName(String name);
    User findById(Long id);
    void deleteById(Long id);
}
