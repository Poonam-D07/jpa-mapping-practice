package com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private String bio;
    private Long profileId;
}
