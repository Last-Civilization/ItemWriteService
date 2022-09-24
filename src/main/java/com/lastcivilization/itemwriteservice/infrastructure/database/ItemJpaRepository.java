package com.lastcivilization.itemwriteservice.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;

interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> { }
