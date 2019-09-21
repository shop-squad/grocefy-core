package pl.sda.grocefy.product.service.impl;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.grocefy.product.dto.UserDTO;
import pl.sda.grocefy.product.entity.UserEntity;
import pl.sda.grocefy.product.mapper.UserMapper;
import pl.sda.grocefy.product.repository.UserRepository;
import pl.sda.grocefy.product.service.UserService;

import javax.transaction.Transactional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO findUser(String username) {
        return userMapper.mapUser(userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("no such user")));
    }

    @Override
    @Transactional
    public void addUser(UserDTO newUser) {

        UserEntity userEntity = userMapper.mapUserToEntity(newUser);

           userEntity.setUsername(newUser.getUsername());
           userEntity.setEmail(newUser.getEmail());

        String encryptedPassword = passwordEncoder.encode(newUser.getPassword());
        userEntity.setPassword(encryptedPassword);
        userRepository.save(userEntity);
    }



//    @Override
//    public UserDTO findUserByEmail(String email) {
//        return userMapper.mapUser(userRepository.findByUsername(email));
//    }

}
