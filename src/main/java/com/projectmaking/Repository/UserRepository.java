package com.projectmaking.Repository;

import com.projectmaking.Model.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(excerptProjection = NoPassword.class)
public interface UserRepository extends JpaRepository<User,Long> {
}
