package com.lastcivilization.itemwriteservice.utils;

import com.lastcivilization.itemwriteservice.domain.port.ItemRepository;
import com.lastcivilization.itemwriteservice.domain.view.DetailsModel;
import com.lastcivilization.itemwriteservice.domain.view.ItemModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class ItemCreator {

    private final ItemRepository itemRepository;

    public void resetTestItemDetails() {
        ItemModel item = new ItemModel(
                1l,
                "test",
                new DetailsModel(
                        1L,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0
                ),
                "USE"
        );
        itemRepository.save(item);
    }
}
