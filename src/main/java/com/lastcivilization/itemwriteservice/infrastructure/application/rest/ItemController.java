package com.lastcivilization.itemwriteservice.infrastructure.application.rest;

import com.lastcivilization.itemwriteservice.domain.ItemServiceImp;
import com.lastcivilization.itemwriteservice.domain.dto.CreateItemDto;
import com.lastcivilization.itemwriteservice.domain.dto.ItemDto;
import com.lastcivilization.itemwriteservice.domain.port.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
class ItemController {

    private final ItemService itemService;

    @PostMapping
    @ResponseStatus(CREATED)
    ItemDto createItem(@RequestBody CreateItemDto createItemDto){
        return itemService.createItem(createItemDto);
    }

    @PutMapping
    ItemDto updateItem(@RequestBody ItemDto itemDto){
        return itemService.updateItem(itemDto);
    }
}
