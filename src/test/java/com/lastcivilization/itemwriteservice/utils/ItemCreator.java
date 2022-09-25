package com.lastcivilization.itemwriteservice.utils;

import com.lastcivilization.itemwriteservice.domain.Details;
import com.lastcivilization.itemwriteservice.domain.Item;
import com.lastcivilization.itemwriteservice.domain.Type;
import com.lastcivilization.itemwriteservice.domain.port.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ItemCreator {

    private final ItemRepository itemRepository;

    public void resetTestItemDetails() {
        Item item = Item.Builder.anItem()
                .id(1L)
                .name("test")
                .details(
                        Details.Builder.aDetails()
                                .id(1L)
                                .build()
                )
                .type(Type.USE)
                .build();
        itemRepository.save(item);
    }
}
