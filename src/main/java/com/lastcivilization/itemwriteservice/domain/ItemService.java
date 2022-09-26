package com.lastcivilization.itemwriteservice.domain;

import com.lastcivilization.itemwriteservice.domain.exception.ItemNotFoundException;
import com.lastcivilization.itemwriteservice.domain.port.ItemRepository;
import com.lastcivilization.itemwriteservice.domain.view.CreateItemModel;
import com.lastcivilization.itemwriteservice.domain.view.ItemModel;

public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemModel createItem(CreateItemModel createItemModel) {
        Item item = Mapper.toDomain(createItemModel);
        ItemModel itemModel = Mapper.toModel(item);
        return itemRepository.save(itemModel);
    }

    public ItemModel updateItem(ItemModel itemModel) {
        long id = itemModel.id();
        if(notExistsInRepository(id)){
            throw new ItemNotFoundException(id);
        }
        Item item = Mapper.toDomain(itemModel);
        ItemModel itemModelToSave = Mapper.toModel(item);
        return itemRepository.save(itemModelToSave);
    }

    private boolean notExistsInRepository(long id) {
        return !itemRepository.existsById(id);
    }
}
