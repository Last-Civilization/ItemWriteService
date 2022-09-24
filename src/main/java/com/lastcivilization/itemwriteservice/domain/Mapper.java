package com.lastcivilization.itemwriteservice.domain;

import com.lastcivilization.itemwriteservice.domain.dto.CreateItemDto;
import com.lastcivilization.itemwriteservice.domain.dto.DetailsDto;
import com.lastcivilization.itemwriteservice.domain.dto.ItemDto;

class Mapper {

    static ItemDto toDto(Item item){
        Type type = item.getType();
        return new ItemDto(
                item.getId(),
                item.getName(),
                toDto(item.getDetails()),
                type.toString()
        );
    }

    private static DetailsDto toDto(Details details) {
        return new DetailsDto(
                details.getId(),
                details.getResistance(),
                details.getDamage(),
                details.getStrength(),
                details.getDexterity(),
                details.getDefense(),
                details.getHealth(),
                details.getTime(),
                details.getLvl()
        );
    }

    static Item toDomain(CreateItemDto createItemDto){
        return Item.Builder.anItem()
                .name(createItemDto.name())
                .details(detailsToDomain(createItemDto))
                .type(Type.valueOf(createItemDto.type()))
                .build();
    }

    private static Details detailsToDomain(CreateItemDto createItemDto){
        return Details.Builder.aDetails()
                .resistance(createItemDto.resistance())
                .damage(createItemDto.damage())
                .strength(createItemDto.strength())
                .dexterity(createItemDto.dexterity())
                .defense(createItemDto.defense())
                .health(createItemDto.health())
                .time(createItemDto.time())
                .lvl(createItemDto.lvl())
                .build();
    }

    static Item toDomain(ItemDto itemDto){
        return Item.Builder.anItem()
                .id(itemDto.id())
                .name(itemDto.name())
                .details(toDomain(itemDto.details()))
                .type(Type.valueOf(itemDto.type()))
                .build();
    }

    private static Details toDomain(DetailsDto details) {
        return Details.Builder.aDetails()
                .id(details.id())
                .resistance(details.resistance())
                .damage(details.damage())
                .strength(details.strength())
                .dexterity(details.dexterity())
                .defense(details.defense())
                .health(details.health())
                .time(details.time())
                .lvl(details.lvl())
                .build();
    }
}
