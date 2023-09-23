package com.Sir.Module.Repository;

import com.Sir.Module.Entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {
    // You can add custom query methods here if needed

    Optional<UserRegistration> findByEmail(String email);

    Boolean existsByEmail(String email);
}

