package com.lastcivilization.itemwriteservice.domain;

import com.lastcivilization.itemwriteservice.domain.exception.ItemNotFoundException;
import com.lastcivilization.itemwriteservice.domain.port.ItemRepository;
import com.lastcivilization.itemwriteservice.domain.view.CreateItemModel;
import com.lastcivilization.itemwriteservice.domain.view.ItemModel;

import static com.lastcivilization.itemwriteservice.domain.Mapper.toDomain;
import static com.lastcivilization.itemwriteservice.domain.Mapper.toModel;

public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemModel createItem(CreateItemModel createItemModel) {
        Item item = toDomain(createItemModel);
        ItemModel itemModel = toModel(item);
        return itemRepository.save(itemModel);
    }

    public ItemModel updateItem(ItemModel itemModel) {
        long id = itemModel.id();
        if(notExistsInRepository(id)){
            throw new ItemNotFoundException(id);
        }
        Item item = toDomain(itemModel);
        ItemModel itemModelToSave = toModel(item);
        return itemRepository.save(itemModel);
    }

    private boolean notExistsInRepository(long id) {
        return !itemRepository.existsById(id);
    }
}
