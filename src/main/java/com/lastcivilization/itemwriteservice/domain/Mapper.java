package com.lastcivilization.itemwriteservice.domain;

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
                details.getTime()
        );
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
                .build();
    }
}
