package com.spark3.olbank.user.repository;

import com.spark3.olbank.user.model.Role;
import com.spark3.olbank.user.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    public List<Role> findByNameEquals(RoleName name);
}
