package com.lastcivilization.itemwriteservice.infrastructure.application.rest;

import com.lastcivilization.itemwriteservice.domain.ItemService;
import com.lastcivilization.itemwriteservice.domain.view.CreateItemModel;
import com.lastcivilization.itemwriteservice.domain.view.ItemModel;
import com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto.CreateItemDto;
import com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.lastcivilization.itemwriteservice.infrastructure.application.rest.RestMapper.MAPPER;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
class ItemController {

    private final ItemService itemService;

    @PostMapping
    @ResponseStatus(CREATED)
    ItemDto createItem(@RequestBody CreateItemDto createItemDto){
        CreateItemModel createItemModel = MAPPER.toModel(createItemDto);
        ItemModel itemModel = itemService.createItem(createItemModel);
        return MAPPER.toDto(itemModel);
    }

    @PutMapping
    ItemDto updateItem(@RequestBody ItemDto itemDto){
        ItemModel itemModel = MAPPER.toModel(itemDto);
        ItemModel updatedItemModel = itemService.updateItem(itemModel);
        return MAPPER.toDto(updatedItemModel);
    }
}
