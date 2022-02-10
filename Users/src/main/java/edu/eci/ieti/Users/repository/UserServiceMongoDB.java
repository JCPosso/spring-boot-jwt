package edu.eci.ieti.Users.repository;

import edu.eci.ieti.Users.data.User;
import edu.eci.ieti.Users.dto.UserDto;
import edu.eci.ieti.Users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create( User user )
    {
        userRepository.save(user);
        return null;
    }

    @Override
    public User findById( String id )
    {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById( String id )
    {
        userRepository.deleteById(id);
    }

    @Override
    public User update(UserDto userDto, String id)
    {
        User user = userRepository.findById(id).get();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        userRepository.save(user);
        return null;
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return null;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return null ;
    }
}