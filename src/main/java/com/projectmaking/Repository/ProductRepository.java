package com.projectmaking.Repository;

import com.projectmaking.Model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> OrderByName(Pageable pageable);

    List<Product> OrderByType(Pageable pageable);

    List<Product> OrderByPrice(Pageable pageable);

    List<Product> findByName(@Param(value = "name") String name);

    List<Product> findByType(@Param(value = "type") String type);
}
