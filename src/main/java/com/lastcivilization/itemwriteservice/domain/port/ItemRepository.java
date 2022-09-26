package com.lastcivilization.itemwriteservice.domain.port;

import com.lastcivilization.itemwriteservice.domain.view.ItemModel;

public interface ItemRepository {

    ItemModel save(ItemModel item);
    boolean existsById(long id);
}
