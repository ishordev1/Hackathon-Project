package com.techtraveller.Service;

import java.util.List;

import com.techtraveller.Dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(String userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(String userId, UserDto userDto);
    void deleteUser(String userId);
    public UserDto getUserByEmailToken(String token);
    public UserDto updateVerifyUser(String userId, UserDto userDto) ;
}
