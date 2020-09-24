package com.Magnanime.personalWebsite.Repositories;

import com.Magnanime.personalWebsite.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Repository for users

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUserName(String username);
}
