package com.macys.macysordermessageconsumer.repository;

import com.macys.macysordermessageconsumer.entity.json.OrderJsonMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JsonMessageRepository extends JpaRepository<OrderJsonMessageEntity, Integer> {
}