package com.twschool.practice.Service;

import com.twschool.practice.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userRepositoryMap = new HashMap<>();

    public User getUserInfoById(String id) {
        if(id==null){
            return null;
        }
        return userRepositoryMap.get(id);
    }

    public void setUserInfo(String id, User user) {
        if(id==null){
            return ;
        }
        userRepositoryMap.put(id, user);
    }
}
