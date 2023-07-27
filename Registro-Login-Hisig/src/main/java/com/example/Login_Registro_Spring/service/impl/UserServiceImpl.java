package com.example.Login_Registro_Spring.service.impl;

import com.example.Login_Registro_Spring.dto.UserDto;
import com.example.Login_Registro_Spring.entity.Role;
import com.example.Login_Registro_Spring.entity.User;
import com.example.Login_Registro_Spring.repository.RoleRepository;
import com.example.Login_Registro_Spring.repository.UserRepository;
import com.example.Login_Registro_Spring.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setNome(userDto.getNome() + " " + userDto.getSobrenome());
        user.setTelefone(userDto.getTelefone());

        //Encripta a senha no banco de dados
        user.setSenha(passwordEncoder.encode(userDto.getSenha()));
        Role role = roleRepository.findByNome("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByTelefone(String telefone) {
        return userRepository.findByTelefone(telefone);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        String[] name = user.getNome().split(" ");
        userDto.setNome(name[0]);
        userDto.setSobrenome(name[1]);
        userDto.setTelefone(user.getTelefone());
        return userDto;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setNome("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
