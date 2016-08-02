package com.projectmaking.Repository;

import com.projectmaking.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(excerptProjection = NoPassword.class)
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(@Param(value = "username") String username);
}
