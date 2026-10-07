package com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.Service;

import com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.DTO.UserRequestDTO;
import com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.DTO.UserResponseDTO;
import com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.ProfileEntity;
import com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.UserEntity;
import com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        // 1. DTO se Profile entity banao
        ProfileEntity profile= new ProfileEntity();
        profile.setBio(userRequestDTO.getBio());

        // 2. DTO se User entity banao aur profile jodo
        UserEntity user = new UserEntity();
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setProfile(profile);

        // 3. Save karo
        UserEntity saved = userRepository.save(user);

        // 4. Saved entity se Response DTO banao
        UserResponseDTO response = new UserResponseDTO();
        response.setId(saved.getId());
        response.setUsername(saved.getUsername());
        response.setEmail(saved.getEmail());
        response.setBio(saved.getProfile().getBio());
        return response;
    }

    @Override
    @Transactional
    public UserResponseDTO getUserById(Long profileId) {
        UserEntity user = userRepository.findById(profileId)
                .orElseThrow(()-> new RuntimeException("No user for profile " + profileId));

        // 2. Response DTO banao
        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());

        // 3. Yahan user se profile ka data nikala
        response.setBio(user.getProfile().getBio());
        return response;
    }
}
