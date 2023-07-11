package com.codegym.cms.model.service.impl;

import com.codegym.cms.model.dto.UserDto;
import com.codegym.cms.model.entity.Role;
import com.codegym.cms.model.entity.User;
import com.codegym.cms.model.repository.UserRepository;
import com.codegym.cms.model.service.RoleService;
import com.codegym.cms.model.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public Iterable<UserDto> findAll() {
        Iterable<User> entities = userRepository.findAll();
        return StreamSupport.stream(entities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(user, UserDto.class));
    }

    @Override
    public void save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        if (!userDto.getPassword().isEmpty()) {
            String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt(10));
            user.setPassword(hashedPassword);
        }
        user.setActivated(true);
        userRepository.save(user);
    }

    @Override
    public void remove(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUsersByFullName(String fullName) {
        String likeFullName = "%" + fullName + "%";
        List<User> users = userRepository.findByFullName(likeFullName);
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        return modelMapper.map(user, UserDto.class);
    }
}