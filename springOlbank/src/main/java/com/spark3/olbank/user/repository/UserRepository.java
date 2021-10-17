package com.spark3.olbank.user.repository;

import com.spark3.olbank.user.model.Userx;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface UserRepository extends JpaRepository<Userx, Long> {
    Userx findByUserName(String username);
    boolean existsUsersByEmail(String email);
    int countByEnabledEquals(boolean enabled);
    Userx findByEmail(String email);
    int countByJoinDateBetween(Date date1, Date date2);

}
