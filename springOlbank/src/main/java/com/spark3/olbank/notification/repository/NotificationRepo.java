package com.spark3.olbank.notification.repository;
import com.spark3.olbank.notification.model.NotificationDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepo extends CrudRepository<NotificationDef, Long> {
}
