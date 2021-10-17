package com.spark3.olbank.forum.repository;

import com.spark3.olbank.forum.model.UserView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserViewRepository extends JpaRepository<UserView,Long> {
}
