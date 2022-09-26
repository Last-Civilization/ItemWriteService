package com.lastcivilization.itemwriteservice.domain;

import com.lastcivilization.itemwriteservice.domain.view.CreateItemModel;
import com.lastcivilization.itemwriteservice.domain.view.DetailsModel;
import com.lastcivilization.itemwriteservice.domain.view.ItemModel;

class Mapper {

    static ItemModel toModel(Item item){
        Type type = item.getType();
        return new ItemModel(
                item.getId(),
                item.getName(),
                toModel(item.getDetails()),
                type.toString()
        );
    }

    private static DetailsModel toModel(Details details) {
        return new DetailsModel(
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

    static Item toDomain(CreateItemModel createItemModel){
        return Item.Builder.anItem()
                .name(createItemModel.name())
                .details(detailsToDomain(createItemModel))
                .type(Type.valueOf(createItemModel.type()))
                .build();
    }

    private static Details detailsToDomain(CreateItemModel createItemModel){
        return Details.Builder.aDetails()
                .resistance(createItemModel.resistance())
                .damage(createItemModel.damage())
                .strength(createItemModel.strength())
                .dexterity(createItemModel.dexterity())
                .defense(createItemModel.defense())
                .health(createItemModel.health())
                .time(createItemModel.time())
                .lvl(createItemModel.lvl())
                .build();
    }

    static Item toDomain(ItemModel itemModel){
        return Item.Builder.anItem()
                .id(itemModel.id())
                .name(itemModel.name())
                .details(toDomain(itemModel.details()))
                .type(Type.valueOf(itemModel.type()))
                .build();
    }

    private static Details toDomain(DetailsModel details) {
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
