package edu.eci.ieti.Users.service;


import edu.eci.ieti.Users.data.User;
import edu.eci.ieti.Users.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceHashMap implements UserService{

    private HashMap<String, User>  userHash = new HashMap<>();

    @Override
    public User create(User user) {
        return userHash.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return userHash.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<User>(userHash.values());
    }

    @Override
    public void deleteById(String id) {
        userHash.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        userHash.replace(userId,user);
        return userHash.get(userId);
    }
}
