package com.Sir.Module.Repository;




import com.Sir.Module.Entity.RoleRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleRegistration, Long> {
    Optional<RoleRegistration> findByName(String name);
//With the help of this line we will be able to find the <Role> based on the name of the user.

}

