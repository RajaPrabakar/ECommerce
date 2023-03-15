package com.ecommerce.Ecommerce.JPA;

import com.ecommerce.Ecommerce.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {
}
