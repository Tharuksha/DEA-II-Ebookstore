package com.nsbm.ebookstore.login.Repository;

import com.nsbm.ebookstore.login.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
   Optional<Users> findByEmail(String email);
}
