package com.lastcivilization.itemwriteservice.domain.port;

import com.lastcivilization.itemwriteservice.domain.Item;

import java.util.Optional;

public interface ItemRepository {

    Item save(Item item);
    boolean existsById(long id);
}
