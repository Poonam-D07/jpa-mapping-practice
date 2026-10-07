package com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.Repository;

import com.poonam.one_to_one_mapping.mapping.Controller.ONE_TO_ONE.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
