package com.example.cours.services;

import com.example.cours.dto.UserDTO;
import com.example.cours.entities.User;
import com.example.cours.exception.ResourceNotFoundException;
import com.example.cours.mapper.UserMapper;
import com.example.cours.repositorie.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "User introuvable : " + id));
        return userMapper.toDTO(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        return userMapper.toDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO update(Long id, UserDTO dto) {
        User existing = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "User introuvable"));
        userMapper.updateFromDTO(dto, existing);
        return userMapper.toDTO(userRepository.save(existing));
    }

    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id))
            throw new ResourceNotFoundException("User introuvable");
        userRepository.deleteById(id);
    }
}
