package com.lastcivilization.itemwriteservice.domain.view;

public record CreateItemModel(
        String name,
        int resistance,
        int damage,
        int strength,
        int dexterity,
        int defense,
        int health,
        int time,
        int lvl,
        String type
) { }
