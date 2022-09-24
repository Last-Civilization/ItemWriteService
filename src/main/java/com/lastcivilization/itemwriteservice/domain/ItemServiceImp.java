package com.lastcivilization.itemwriteservice.domain;

import com.lastcivilization.itemwriteservice.domain.dto.CreateItemDto;
import com.lastcivilization.itemwriteservice.domain.dto.ItemDto;
import com.lastcivilization.itemwriteservice.domain.exception.ItemNotFoundException;
import com.lastcivilization.itemwriteservice.domain.port.ItemRepository;
import com.lastcivilization.itemwriteservice.domain.port.ItemService;

import static com.lastcivilization.itemwriteservice.domain.Mapper.toDomain;
import static com.lastcivilization.itemwriteservice.domain.Mapper.toDto;

public class ItemServiceImp implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemDto createItem(CreateItemDto createItemDto) {
        Item item = toDomain(createItemDto);
        Item savedItem = itemRepository.save(item);
        return toDto(savedItem);
    }

    @Override
    public ItemDto updateItem(ItemDto itemDto) {
        long id = itemDto.id();
        if(notExistsInRepository(id)){
            throw new ItemNotFoundException(id);
        }
        Item item = toDomain(itemDto);
        Item savedItem = itemRepository.save(item);
        return toDto(savedItem);
    }

    private boolean notExistsInRepository(long id) {
        return !itemRepository.existsById(id);
    }
}
