package com.lastcivilization.itemwriteservice.domain.port;

import com.lastcivilization.itemwriteservice.domain.dto.CreateItemDto;
import com.lastcivilization.itemwriteservice.domain.dto.ItemDto;

public interface ItemService {

    ItemDto createItem(CreateItemDto createItemDto);
}
