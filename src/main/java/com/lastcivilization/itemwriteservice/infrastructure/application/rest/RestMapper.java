package com.lastcivilization.itemwriteservice.infrastructure.application.rest;

import com.lastcivilization.itemwriteservice.domain.view.CreateItemModel;
import com.lastcivilization.itemwriteservice.domain.view.ItemModel;
import com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto.CreateItemDto;
import com.lastcivilization.itemwriteservice.infrastructure.application.rest.dto.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface RestMapper {

    RestMapper MAPPER = Mappers.getMapper(RestMapper.class);

    CreateItemModel toModel(CreateItemDto createItemDto);
    ItemModel toModel(ItemDto itemDto);
    ItemDto toDto(ItemModel itemModel);
}
