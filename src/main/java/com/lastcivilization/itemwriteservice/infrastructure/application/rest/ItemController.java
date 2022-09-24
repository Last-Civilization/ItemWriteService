package com.lastcivilization.itemwriteservice.infrastructure.application.rest;

import com.lastcivilization.itemwriteservice.domain.ItemServiceImp;
import com.lastcivilization.itemwriteservice.domain.dto.CreateItemDto;
import com.lastcivilization.itemwriteservice.domain.dto.ItemDto;
import com.lastcivilization.itemwriteservice.domain.port.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
class ItemController {

    private final ItemService itemService;

    @PostMapping
    ItemDto createItem(CreateItemDto createItemDto){
        return itemService.createItem(createItemDto);
    }

    @PutMapping
    ItemDto updateItem(ItemDto itemDto){
        return itemService.updateItem(itemDto);
    }
}
