package pl.sda.grocefy.product.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.entity.UserEntity;
import pl.sda.grocefy.product.mapper.UserMapper;
import pl.sda.grocefy.product.repository.UserRepository;
import pl.sda.grocefy.product.service.UserService;

import javax.transaction.Transactional;
import javax.xml.ws.WebServiceException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO findUser(String username) {
        return userMapper.mapUser(userRepository.findByUsername(username).orElseThrow(()-> new WebServiceException("USER NOT FOUND")));
    }

    @Override
    @Transactional
    public void addUser(UserDTO newUser) {

        UserEntity userEntity = userMapper.mapUserToEntity(newUser);
        userEntity.setUsername(newUser.getUsername());
        userEntity.setEmail(newUser.getEmail());
        userEntity.setPassword(newUser.getPassword());
        userRepository.save(userEntity);
    }

}
