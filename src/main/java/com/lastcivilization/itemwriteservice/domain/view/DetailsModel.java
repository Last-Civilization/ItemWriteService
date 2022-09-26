package com.lastcivilization.itemwriteservice.domain.view;

public record DetailsModel(
        Long id,
        int resistance,
        int damage,
        int strength,
        int dexterity,
        int defense,
        int health,
        int time,
        int lvl
) { }
