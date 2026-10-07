package com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.Service;

import com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.DTO.UserRequestDTO;
import com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.DTO.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    //Find by user id
    UserResponseDTO getUserById(Long id);

    // Find by profile id
//    UserResponseDTO getUserByProfileId(Long profileId);

}
